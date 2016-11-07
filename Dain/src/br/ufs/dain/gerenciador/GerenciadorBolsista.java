package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Bolsista;

public class GerenciadorBolsista {
	
	Conexao conexao = new Conexao();
	GerenciadorHorario gHor = new GerenciadorHorario();
	Connection conn;
	Statement stmt;
	
	public void armazenarBolsista(Bolsista b, String matricAdm) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "INSERT INTO t_bolsista (b_matricula, b_nome, b_telefone, b_email, "
				+ "b_curso, b_sexo, b_fk_adm, b_fk_horario) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, b.getMatricula());
		stmt.setString(2, b.getNome());
		stmt.setString(3, b.getTelefone());
		stmt.setString(4, b.getEmail());
		stmt.setString(5, b.getCurso());
		stmt.setString(6, b.getSexo());
		stmt.setString(7, matricAdm);
		stmt.setObject(8, null);

		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();
	}
	
	public Bolsista buscarBolsistaMatricula(String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Bolsista bolsista = null;

		String sql = "SELECT b_nome, b_telefone, b_email, " + "b_curso, b_sexo, b_atividade, b_fk_adm, b_fk_horario "
				+ "FROM t_bolsista " + "WHERE b_matricula = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			bolsista = new Bolsista(rs.getString("b_telefone"), rs.getString("b_email"), rs.getString("b_nome"),
					rs.getString("b_curso"), matric, rs.getString("b_sexo"), gHor.buscarHorario(rs.getInt("b_fk_horario")),
					rs.getInt("b_atividade"));
		}
		
		conn.close();

		return bolsista;
	}
	
	public Bolsista buscarBolsistaNome(String nome) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Bolsista bolsista = null;

		String sql = "SELECT b_matricula, b_telefone, b_email, " + "b_curso, b_sexo, b_atividade, b_fk_adm, b_fk_horario "
				+ "FROM t_bolsista " + "WHERE b_nome = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, nome);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			bolsista = new Bolsista(rs.getString("b_telefone"), rs.getString("b_email"), nome,
					rs.getString("b_curso"), rs.getString("b_matricula"), rs.getString("b_sexo"), gHor.buscarHorario(rs.getInt("b_fk_horario")),
					rs.getInt("b_atividade"));
		}
		
		conn.close();

		return bolsista;
	}
	
	public ArrayList<Bolsista> listarBolsistas() throws SQLException {

		conn = conexao.getConexaoMySQL();
		
		ArrayList<Bolsista> listaBolsistas = new ArrayList<>();
		Bolsista bolsista;
		
		String sql = "SELECT * FROM t_bolsista";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		ResultSet rs = (ResultSet) stmt.executeQuery();
		
		while (rs.next()) {
			bolsista = new Bolsista(rs.getString("b_telefone"), rs.getString("b_email"), rs.getString("b_nome"),
					rs.getString("b_curso"), rs.getString("b_matricula"), rs.getString("b_sexo"), 
					gHor.buscarHorario(rs.getInt("b_fk_horario")),
					rs.getInt("b_atividade"));
			listaBolsistas.add(bolsista);
		}
				
		conn.close();

		return listaBolsistas;
	}
	
}
