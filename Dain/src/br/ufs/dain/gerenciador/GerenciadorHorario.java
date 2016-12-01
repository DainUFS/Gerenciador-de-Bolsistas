package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Horario;

public class GerenciadorHorario {
	
	Conexao conexao = new Conexao();
	Connection conn;
	Statement stmt;
	
	public int aramazenarHorario(Horario h) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "INSERT INTO t_horario (h_segunda, h_terca, h_quarta, h_quinta, h_sexta, h_sabado)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, h.getSegunda());
		stmt.setString(2, h.getTerca());
		stmt.setString(3, h.getQuarta());
		stmt.setString(4, h.getQuinta());
		stmt.setString(5, h.getSexta());
		stmt.setString(6, h.getSabado());

		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();
		
		return buscarIdHorario(h);

	}

	public int buscarIdHorario(Horario h) throws SQLException {

		conn = conexao.getConexaoMySQL();

		int id = -1;

		String sql = "SELECT h_id FROM t_horario " + "WHERE h_segunda = ? AND h_terca = ? AND h_quarta = ?  "
				+ "AND h_quinta = ? AND h_sexta = ? AND h_sabado = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, h.getSegunda());
		stmt.setString(2, h.getTerca());
		stmt.setString(3, h.getQuarta());
		stmt.setString(4, h.getQuinta());
		stmt.setString(5, h.getSexta());
		stmt.setString(6, h.getSabado());

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			id = rs.getInt("h_id");
		}
		
		conn.close();

		return id;
	}
	
	public void atualizarHorario(Horario h, int id) throws SQLException{
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "UPDATE t_horario SET h_segunda = ?, "
				+ "h_terca = ?, "
				+ "h_quarta = ?, "
				+ "h_quinta = ?, "
				+ "h_sexta = ?, "
				+ "h_sabado = ? "
				+ "WHERE h_id = ?";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
		
		stmt.setString(1, h.getSegunda());
		stmt.setString(2, h.getTerca());
		stmt.setString(3, h.getQuarta());
		stmt.setString(4, h.getQuinta());
		stmt.setString(5, h.getSexta());
		stmt.setString(6, h.getSabado());
		stmt.setInt(7, id);
		
		stmt.execute();
		stmt.close();

		conn.close();
	}
	
	public Horario buscarHorario(int id) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Horario horario = null;

		String sql = "SELECT h_segunda, h_terca, h_quarta, " + "h_quinta, h_sexta, h_sabado FROM t_horario "
				+ "WHERE h_id = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setInt(1, id);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			horario = new Horario(rs.getString("h_segunda"), rs.getString("h_terca"), rs.getString("h_quarta"),
					rs.getString("h_quinta"), rs.getString("h_sexta"), rs.getString("h_sabado"));
		}
		
		conn.close(); 
		
		return horario;

	}

	
	public static void main(String[] args) throws SQLException {
		GerenciadorHorario g = new GerenciadorHorario();
		Horario h = new Horario("11:00h - 12:00h|10:00h - 11:00h|", 
				"11:00h - 12:00h|10:00h - 11:00h|", 
				"11:00h - 12:00h|10:00h - 11:00h|", 
				"11:00h - 12:00h|10:00h - 11:00h|", 
				"11:00h - 12:00h|10:00h - 11:00h|", 
				"11:00h - 12:00h|10:00h - 11:00h|");
		
		System.out.println(g.aramazenarHorario(h));
		
	}


}
