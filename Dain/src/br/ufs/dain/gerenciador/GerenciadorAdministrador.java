package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Administrador;

public class GerenciadorAdministrador {
	Conexao conexao = new Conexao();
	Connection conn;
	Statement stmt;
	
	public void aramazenarAdm(Administrador a) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "INSERT INTO t_adm (a_matricula, a_nome, a_email,  a_telefone, a_senha)"
				+ "VALUES (?, ?, ?, ?, ?)";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, a.getMatricula());
		stmt.setString(2, a.getNome());
		stmt.setString(3, a.getEmail());
		stmt.setString(4, a.getTelefone());
		stmt.setString(5, a.getSenha());

		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();
	}

	public String buscarSenhaAdm(String login) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String senha = null;

		String sql = "SELECT a_senha FROM t_adm " + "WHERE a_matricula = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, login);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			senha = rs.getString("a_senha");
		}

		conn.close();

		return senha;

	}

	public Administrador buscarAdm(String matric, String senha) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "SELECT * FROM t_adm " + "WHERE a_matricula = ? and a_senha = ?";

		Administrador adm = null;

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);
		stmt.setString(2, senha);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			adm = new Administrador(rs.getString("a_nome"), rs.getString("a_telefone"), rs.getString("a_email"), matric,
					senha);
		}

		conn.close();

		return adm;
	}

	public Administrador buscarAdmMatricula(String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "SELECT * FROM t_adm " + "WHERE a_matricula = ?";

		Administrador adm = null;

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			adm = new Administrador(rs.getString("a_nome"), rs.getString("a_telefone"), rs.getString("a_email"), matric,
					rs.getString("a_senha"));
		}

		conn.close();

		return adm;
	}

}