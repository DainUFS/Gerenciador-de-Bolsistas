package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Nota;

public class GerenciadorNota {

	Conexao conexao = new Conexao();
	GerenciadorAdministrador ger_adm = new GerenciadorAdministrador();
	Connection conn;
	Statement stmt;

	public Nota buscarNota(String matric) throws SQLException {
		Nota nota = null;
		Administrador adm = ger_adm.buscarAdmMatricula(matric);

		conn = conexao.getConexaoMySQL();

		String sql = "SELECT * FROM t_nota WHERE n_id = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setLong(1, buscarId(matric));

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			nota = new Nota(rs.getString("n_anotacao"), adm);
		}

		conn.close();

		return nota;
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
	
	public int buscarId(String matr) throws SQLException{
		int id = 0;
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "SELECT n_id FROM banco_dain.t_nota WHERE n_fk_adm = ?";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matr);
		
		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			id = rs.getInt("n_id");
		}

		conn.close();
		
		return id;
	}

	public void deletaNota(String anotacao) throws SQLException {
		Nota nota;

		conn = conexao.getConexaoMySQL();

		String sql = "DELETE FROM t_nota WHERE n_id = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setInt(1, new GerenciadorNota().buscarId(anotacao));
		
		stmt.execute();
		stmt.close();

		conn.close();
	}
	
	public static void main(String[] args) throws SQLException {
		//System.out.println(new GerenciadorNota().buscarNota("32509874").getAnotacao());
		Nota nota = new GerenciadorNota().buscarNota("123");
		System.out.println(nota.getAnotacao());
	}

}
