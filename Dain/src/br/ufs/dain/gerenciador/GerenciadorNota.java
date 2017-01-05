package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Nota;

public class GerenciadorNota {

	Conexao conexao = new Conexao();
	GerenciadorAdministrador ger_adm = new GerenciadorAdministrador();
	Connection conn;
	Statement stmt;

	public ArrayList<Nota> buscarNotas(String matric) throws SQLException {
		Administrador adm = ger_adm.buscarAdmMatricula(matric);

		conn = conexao.getConexaoMySQL();
		
		ArrayList<Nota> listaNotas = new ArrayList<>();
		Nota nota;

		String sql = "SELECT * FROM t_nota WHERE n_fk_adm = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			nota = new Nota(rs.getString("n_anotacao"), adm);
			listaNotas.add(nota);
		}

		conn.close();

		return listaNotas;
	}

	public void armazenarAnotacao(String matric, String novaAnotacao) throws SQLException {
		//Nota nota = buscarNota(matric);

		conn = conexao.getConexaoMySQL();
		
		Date data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd"); 

		String sql = "INSERT INTO t_nota (n_anotacao, n_data, n_fk_adm) VALUES "
				+ "(?, ?, ?)";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, novaAnotacao);
		stmt.setString(2, formatarDate.format(data));
		stmt.setString(3, matric);

		stmt.execute();
		stmt.close();

		conn.close();

	}
	
	public int buscarId(String nota) throws SQLException{
		int id = 0;
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "SELECT n_id FROM t_nota WHERE n_anotacao = ?";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, nota);
		
		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			id = rs.getInt("n_id");
		}

		conn.close();
		
		return id;
	}

	public void deletaNota(String anotacao) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "DELETE FROM t_nota WHERE n_id = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setInt(1, buscarId(anotacao));
		
		stmt.execute();
		stmt.close();

		conn.close();
	}
	
	public static void main(String[] args) throws SQLException {
		ArrayList<Nota> notas;
		notas = new GerenciadorNota().buscarNotas("123");
		System.out.println(notas.get(0).getAnotacao());
		System.out.println(notas.get(1).getAnotacao());
		new GerenciadorNota().deletaNota("TestandoBanco");
		System.out.println(new GerenciadorNota().buscarId("outra"));
	
	}

}
