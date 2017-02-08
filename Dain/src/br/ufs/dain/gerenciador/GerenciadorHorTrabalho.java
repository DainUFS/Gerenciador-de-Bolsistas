package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Horario;

public class GerenciadorHorTrabalho {
	
	Conexao conexao = new Conexao();
	Connection conn;
	Statement stmt;
	
	public void aramazenarHorario(Horario h, String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "INSERT INTO t_horariotrabalho (ht_segunda, ht_terca, ht_quarta,"
				+ " ht_quinta, ht_sexta, ht_sabado, ht_fk_bolsista)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, h.getSegunda());
		stmt.setString(2, h.getTerca());
		stmt.setString(3, h.getQuarta());
		stmt.setString(4, h.getQuinta());
		stmt.setString(5, h.getSexta());
		stmt.setString(6, h.getSabado());
		stmt.setString(7, matric);

		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();

	}
	
	public Horario buscarHorario(String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Horario horario = null;

		String sql = "SELECT hT_segunda, hT_terca, hT_quarta, " 
		+ "hT_quinta, hT_sexta, hT_sabado FROM t_horariotrabalho "
				+ "WHERE ht_fk_bolsista = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			horario = new Horario(rs.getString("ht_segunda"), rs.getString("ht_terca"), rs.getString("ht_quarta"),
					rs.getString("ht_quinta"), rs.getString("ht_sexta"), rs.getString("ht_sabado"));
		}
		
		conn.close(); 
		
		return horario;

	}

}