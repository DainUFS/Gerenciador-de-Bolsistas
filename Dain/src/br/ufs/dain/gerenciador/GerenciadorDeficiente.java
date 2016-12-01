package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Deficiente;
import br.ufs.dain.modelo.Horario;

public class GerenciadorDeficiente {
	
	Conexao conexao = new Conexao();
	GerenciadorHorario gHor = new GerenciadorHorario();
	Connection conn;
	Statement stmt;
	
	public void armazenarDeficiente(Deficiente d, String matricAdm) throws SQLException {

		conn = conexao.getConexaoMySQL();

		String sql = "INSERT INTO t_deficiente (d_matricula, d_nome, d_telefone, d_email, d_curso, d_sexo, "
				+ "d_fk_horario, d_tipoDeficiencia, d_fk_adm, d_status) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
		stmt.setInt(10, d.getStatusAtivacao());

		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();
	}
	
	public Deficiente buscarDeficienteMatricula(String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Deficiente deficiente = null;

		String sql = "SELECT d_nome, d_telefone, d_email, "
				+ "d_curso, d_sexo, d_tipoDeficiencia, d_fk_adm, d_fk_horario, d_status " + "FROM t_deficiente "
				+ "WHERE d_matricula = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			deficiente = new Deficiente(rs.getString("d_telefone"), rs.getString("d_email"), rs.getString("d_nome"),
					rs.getString("d_curso"), matric, rs.getString("d_sexo"), gHor.buscarHorario(rs.getInt("d_fk_horario")),
					rs.getString("d_tipoDeficiencia"), rs.getInt("d_status"));
		}
		
		conn.close();

		return deficiente;
	}
	
	public Deficiente buscarDeficienteNome(String nome) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Deficiente deficiente = null;

		String sql = "SELECT d_matricula, d_telefone, d_email, "
				+ "d_curso, d_sexo, d_tipoDeficiencia, d_fk_adm, d_fk_horario, d_status " + "FROM t_deficiente "
				+ "WHERE d_nome = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, nome);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			deficiente = new Deficiente(rs.getString("d_telefone"), rs.getString("d_email"), nome,
					rs.getString("d_curso"), rs.getString("d_matricula"), rs.getString("d_sexo"), gHor.buscarHorario(rs.getInt("d_fk_horario")),
					rs.getString("d_tipoDeficiencia"), rs.getInt("d_status"));
		}
		
		conn.close();

		return deficiente;
	}
	
	public ArrayList<Deficiente> listarDeficiente() throws SQLException {

		conn = conexao.getConexaoMySQL();
		
		ArrayList<Deficiente> listaDeficiente = new ArrayList<>();
		Deficiente deficiente;
		
		String sql = "SELECT * FROM t_deficiente WHERE d_status = 1";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		ResultSet rs = (ResultSet) stmt.executeQuery();
		
		while (rs.next()) {
			deficiente = new Deficiente(rs.getString("d_telefone"), 
					rs.getString("d_email"), 
					rs.getString("d_nome"),
					rs.getString("d_curso"), 
					rs.getString("d_matricula"), 
					rs.getString("d_sexo"), 
					gHor.buscarHorario(rs.getInt("d_fk_horario")),
					rs.getString("d_tipoDeficiencia"), 
					rs.getInt("d_status"));
			
			listaDeficiente.add(deficiente);
		}
				
		conn.close();

		return listaDeficiente;
	}
	
	public int buscarIdHr(String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		int id = 0;

		String sql = "SELECT d_fk_horario FROM t_deficiente "
				+ "WHERE d_matricula = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			id = rs.getInt("d_fk_horario"); 
		}
		
		return id;

	}
	
	public void persistirHorario(Horario h, String matric) throws SQLException{
		int id = buscarIdHr(matric);
		conn = conexao.getConexaoMySQL();
		
		if(id == 0){
			id = gHor.aramazenarHorario(h);
			String sql = "UPDATE t_deficiente SET d_fk_horario = ? WHERE d_matricula = ?";
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			stmt.setString(2, matric);
			
			stmt.execute();
			conn.close();
		}else{
			gHor.atualizarHorario(h, id);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Horario h = new Horario("MUDOU", 
				"MUDOU", 
				"MUDOU", 
				"MUDOU", 
				"MUDOU", 
				"MUDOU");
		new GerenciadorDeficiente().persistirHorario(h, "789456");
	}

}
