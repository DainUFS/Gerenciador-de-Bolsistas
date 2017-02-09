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
	
	public void atualizarHorario(Horario h, String matric) throws SQLException {

		Horario hora = buscarHorario(matric);
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "UPDATE t_horariotrabalho SET ht_segunda = ?, "
				+ "ht_terca = ?, "
				+ "ht_quarta = ?, "
				+ "ht_quinta = ?, "
				+ "ht_sexta = ?, "
				+ "ht_sabado = ? "
				+ "WHERE ht_fk_bolsista = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, h.getSegunda() + "  " + hora.getSegunda());
		stmt.setString(2, h.getTerca() + "  " + hora.getTerca());
		stmt.setString(3, h.getQuarta() + "  " + hora.getQuarta());
		stmt.setString(4, h.getQuinta() + "  " + hora.getQuinta());
		stmt.setString(5, h.getSexta() + "  " + hora.getSexta());
		stmt.setString(6, h.getSabado() + "  " + hora.getSabado());
		stmt.setString(7, matric);

		stmt.execute();
		stmt.close();

		conn.close();

	}
	
	public void criarHorario(Horario h, String matric) throws SQLException {
		
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

		conn.close();

	}
	
	public Horario buscarHorario(String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Horario horario = null;

		String sql = "SELECT ht_segunda, ht_terca, ht_quarta, " 
		+ "ht_quinta, ht_sexta, ht_sabado FROM t_horariotrabalho "
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
