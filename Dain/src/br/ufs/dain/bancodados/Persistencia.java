package br.ufs.dain.bancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufs.dain.dominio.Administrador;
import br.ufs.dain.dominio.Bolsista;
import br.ufs.dain.dominio.Deficiente;
import br.ufs.dain.dominio.Horario;
import br.ufs.dain.dominio.Login;

public class Persistencia {

	Conexao conexao = new Conexao();
	Connection conn;
	Statement stmt;

	public void armazenarBolsista(Bolsista b, String matricAdm) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "INSERT INTO t_bolsista (b_matricula, b_nome, b_telefone, b_email, "
				+ "b_curso, b_sexo, b_atividade, b_fk_adm, b_fk_horario) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, b.getMatricula());
		stmt.setString(2, b.getNome());
		stmt.setString(3, b.getTelefone());
		stmt.setString(4, b.getEmail());
		stmt.setString(5, b.getCurso());
		stmt.setString(6, b.getSexo());
		stmt.setInt(7, b.getTipoAtividade());
		stmt.setString(8, matricAdm);
		stmt.setObject(9, null);

		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();
	}

	public void aramazenarAdm(Administrador a) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "INSERT INTO t_adm (a_matricula, a_nome, a_email,  a_telefone, a_senha)"
				+ "VALUES (?, ?, ?, ?, ?)";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, a.getLogin());
		stmt.setString(2, a.getNome());
		stmt.setString(3, a.getEmail());
		stmt.setString(4, a.getTelefone());
		stmt.setString(5, a.getSenha());

		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();
	}

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

		String sql = "SELECT h_id FROM t_horario " + "WHERE h_segunda = ? and h_terca = ? and h_quarta = ?  "
				+ "and h_quinta = ? and h_sexta = ? and h_sabado = ?";

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
	
	public void aramazenarHorarioDef(Horario h, String matric) throws SQLException{
		int id = buscarIdHorario(h);
		if(id == -1){
			id = aramazenarHorario(h);
		}
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "UPDATE t_deficiente SET d_fk_horario = ? WHERE d_matricula = ?";		
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
		
		stmt.setInt(1, id);
		stmt.setString(2, matric);
		
		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();
	}
		
	public void aramazenarHorarioBol(Horario h, String matric) throws SQLException{
		int id = buscarIdHorario(h);
		if(id == -1){
			id = aramazenarHorario(h);
		}
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "UPDATE t_bolsista SET b_fk_horario = ? WHERE b_matricula = ?";		
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
		
		stmt.setInt(1, id);
		stmt.setString(2, matric);
		
		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

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

	public Bolsista buscarBolsistaM(String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Bolsista bolsista = null;

		String sql = "SELECT b_nome, b_telefone, b_email, " + "b_curso, b_sexo, b_atividade, b_fk_adm, b_fk_horario "
				+ "FROM t_bolsista " + "WHERE b_matricula = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			bolsista = new Bolsista(rs.getString("b_telefone"), rs.getString("b_email"), rs.getString("b_nome"),
					rs.getString("b_curso"), matric, rs.getString("b_sexo"), buscarHorario(rs.getInt("b_fk_horario")),
					rs.getInt("b_atividade"));
		}
		
		conn.close();

		return bolsista;
	}
	
	public Bolsista buscarBolsistaN(String nome) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Bolsista bolsista = null;

		String sql = "SELECT b_matricula, b_telefone, b_email, " + "b_curso, b_sexo, b_atividade, b_fk_adm, b_fk_horario "
				+ "FROM t_bolsista " + "WHERE b_nome = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, nome);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			bolsista = new Bolsista(rs.getString("b_telefone"), rs.getString("b_email"), nome,
					rs.getString("b_curso"), rs.getString("b_matricula"), rs.getString("b_sexo"), buscarHorario(rs.getInt("b_fk_horario")),
					rs.getInt("b_atividade"));
		}
		
		conn.close();

		return bolsista;
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
					rs.getString("d_curso"), matric, rs.getString("d_sexo"), buscarHorario(rs.getInt("d_fk_horario")),
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
					rs.getString("d_curso"), rs.getString("d_matricula"), rs.getString("d_sexo"), buscarHorario(rs.getInt("d_fk_horario")),
					rs.getString("d_tipoDeficiencia"));
		}
		
		conn.close();

		return deficiente;
	}
	
	public String buscarSenhaAdm(String login) throws SQLException{
		
		conn = conexao.getConexaoMySQL();
		
		String senha = null;
		
		String sql = "SELECT a_senha FROM t_adm "
				+ "WHERE a_matricula = ?";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, login);
		
		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			senha = rs.getString("a_senha");
		}
		
		conn.close();
		
		return senha;

	}

	
	
	
	
	
	public static void main(String[] args) throws SQLException {
		Persistencia per = new Persistencia();
		Login l = new Login("22", "21");
		System.out.println(per.buscarSenhaAdm(l.getLogin()));
	}

}
