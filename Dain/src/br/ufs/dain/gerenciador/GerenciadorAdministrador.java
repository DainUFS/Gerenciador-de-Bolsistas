package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Bolsista;

public class GerenciadorAdministrador {
	Conexao conexao = new Conexao();
	Connection conn;
	Statement stmt;
	
	public void aramazenarAdm(Administrador a) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "INSERT INTO t_adm (a_matricula, a_nome, a_email,  a_telefone, a_senha, a_status)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, a.getMatricula());
		stmt.setString(2, a.getNome());
		stmt.setString(3, a.getEmail());
		stmt.setString(4, a.getTelefone());
		stmt.setString(5, a.getSenha());
		stmt.setInt(6, a.getStatusAtivacao());

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

	public Administrador buscarAdmAtivo(String matric, String senha) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "SELECT * FROM t_adm WHERE a_matricula = ? "
				+ "AND a_senha = ? AND a_status = 1";

		Administrador adm = null;

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);
		stmt.setString(2, senha);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			adm = new Administrador(rs.getString("a_telefone"), rs.getString("a_email"), rs.getString("a_nome"), matric,
					senha, rs.getInt("a_status"));
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
					rs.getString("a_senha"), rs.getInt("a_status"));
		}

		conn.close();

		return adm;
	}
	
	public ArrayList<Administrador> listarAdm() throws SQLException{
		
		conn = conexao.getConexaoMySQL();
		
		ArrayList<Administrador> listaAdminstrador = new ArrayList<>();
		Administrador adm;
		
		String sql = "SELECT * FROM t_adm WHERE a_status = 1";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		ResultSet rs = (ResultSet) stmt.executeQuery();
		
		while (rs.next()) {
			adm = new Administrador(rs.getString("a_telefone"), rs.getString("a_email"), rs.getString("a_nome"),
					rs.getString("a_matricula"), rs.getString("a_senha"),
					rs.getInt("a_status"));
			
			listaAdminstrador.add(adm);
		}
				
		conn.close();
		
		return listaAdminstrador;
	}
	
	public void altualizarDados(Administrador adm, String matr) throws SQLException{
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "UPDATE t_adm SET "
				+ "a_nome = ?, "
				+ "a_email = ?, "
				+ "a_telefone = ?, "
				+ "a_status = ? WHERE a_matricula = ? ";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
		
		stmt.setString(1, adm.getNome());
		stmt.setString(2, adm.getEmail());
		stmt.setString(3, adm.getTelefone());
		stmt.setInt(4, adm.getStatusAtivacao());
		stmt.setString(5, matr);
		
		stmt.execute();
		conn.close();
		
	}
	
	public void mudarSenha(Administrador adm, String novaSenha) throws SQLException{
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "UPDATE t_adm SET "
				+ "a_senha = ? WHERE a_matricula = ? ";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
		
		stmt.setString(1, novaSenha);
		stmt.setString(2, adm.getMatricula());
		
		stmt.execute();
		conn.close();
	}
	
	public static void main(String[] args) throws SQLException {
		GerenciadorAdministrador ger = new GerenciadorAdministrador();
		Administrador adm = new Administrador("11", "11", "no", "123", "123", 1);
		ger.mudarSenha(adm, "789");
	}
}
