package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Deficiente;

public class GerenciadorDeficiente {
	
	Conexao conexao = new Conexao();
	GerenciadorHorario gHor = new GerenciadorHorario();
	Connection conn;
	Statement stmt;
	
	public void armazenarDeficiente(Deficiente d, String matricAdm) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "INSERT INTO t_deficiente (d_matricula, d_nome, d_telefone, d_email, d_curso, d_sexo, "
				+ "d_fk_horario, d_tipoDeficiencia, d_fk_adm) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, d.getMatricula());
		stmt.setString(2, d.getNome());
		stmt.setString(3, d.getTelefone());
		stmt.setString(4, d.getEmail());
		stmt.setString(5, d.getCurso());
		stmt.setString(6, d.getSexo());
		stmt.setObject(7, null);
		stmt.setString(8, d.getTipoDeficiencia());
		stmt.setString(9, matricAdm);

		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();
	}
	
	public Deficiente buscarDeficienteM(String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Deficiente deficiente = null;

		String sql = "SELECT d_nome, d_telefone, d_email, "
				+ "d_curso, d_sexo, d_tipoDeficiencia, d_fk_adm, d_fk_horario " + "FROM t_deficiente "
				+ "WHERE d_matricula = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			deficiente = new Deficiente(rs.getString("d_telefone"), rs.getString("d_email"), rs.getString("d_nome"),
					rs.getString("d_curso"), matric, rs.getString("d_sexo"), gHor.buscarHorario(rs.getInt("d_fk_horario")),
					rs.getString("d_tipoDeficiencia"));
		}
		
		conn.close();

		return deficiente;
	}
	
	public Deficiente buscarDeficienteN(String nome) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Deficiente deficiente = null;

		String sql = "SELECT d_matricula, d_telefone, d_email, "
				+ "d_curso, d_sexo, d_tipoDeficiencia, d_fk_adm, d_fk_horario " + "FROM t_deficiente "
				+ "WHERE d_nome = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, nome);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			deficiente = new Deficiente(rs.getString("d_telefone"), rs.getString("d_email"), nome,
					rs.getString("d_curso"), rs.getString("d_matricula"), rs.getString("d_sexo"), gHor.buscarHorario(rs.getInt("d_fk_horario")),
					rs.getString("d_tipoDeficiencia"));
		}
		
		conn.close();

		return deficiente;
	}



}
