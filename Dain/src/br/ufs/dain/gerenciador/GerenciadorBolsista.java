package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Horario;

public class GerenciadorBolsista {
	
	Conexao conexao = new Conexao();
	GerenciadorHorario gHor = new GerenciadorHorario();
	Connection conn;
	Statement stmt;
	
	public void armazenarBolsista(Bolsista b, String matricAdm) throws SQLException {
		
		int id = gHor.aramazenarHorario(b.getHorario());
		
		conn = conexao.getConexaoMySQL();

		String sql = "INSERT INTO t_bolsista (b_matricula, b_nome, b_telefone, b_email, "
				+ "b_curso, b_sexo, b_fk_adm, b_fk_horario, b_atividade, b_status) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, b.getMatricula());
		stmt.setString(2, b.getNome());
		stmt.setString(3, b.getTelefone());
		stmt.setString(4, b.getEmail());
		stmt.setString(5, b.getCurso());
		stmt.setString(6, b.getSexo());
		stmt.setString(7, matricAdm);
		stmt.setInt(8, id);
		stmt.setInt(9, b.getTipoAtividade());
		stmt.setInt(10, b.getStatusAtivacao());
		
		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();
	}
	
	public Bolsista buscarBolsistaMatricula(String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Bolsista bolsista = null;

		String sql = "SELECT b_nome, b_telefone, b_email, " + "b_curso, b_sexo, b_atividade, b_fk_adm, b_fk_horario, b_status "
				+ "FROM t_bolsista " + "WHERE b_matricula = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			bolsista = new Bolsista(rs.getString("b_telefone"), rs.getString("b_email"), rs.getString("b_nome"),
					rs.getString("b_curso"), matric, rs.getString("b_sexo"), gHor.buscarHorario(rs.getInt("b_fk_horario")),
					rs.getInt("b_atividade"), rs.getInt("b_status"));
		}
		
		conn.close();

		return bolsista;
	}
	
	public Bolsista buscarBolsistaNome(String nome) throws SQLException {

		conn = conexao.getConexaoMySQL();

		Bolsista bolsista = null;

		String sql = "SELECT b_matricula, b_telefone, b_email, " + "b_curso, b_sexo, b_atividade, b_fk_adm, b_fk_horario, b_status "
				+ "FROM t_bolsista " + "WHERE b_nome = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, nome);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			bolsista = new Bolsista(rs.getString("b_telefone"), rs.getString("b_email"), nome,
					rs.getString("b_curso"), rs.getString("b_matricula"), rs.getString("b_sexo"), gHor.buscarHorario(rs.getInt("b_fk_horario")),
					rs.getInt("b_atividade"), rs.getInt("b_status"));
		}
		
		conn.close();

		return bolsista;
	}
	
	public ArrayList<Bolsista> listarBolsistas() throws SQLException {

		conn = conexao.getConexaoMySQL();
		
		ArrayList<Bolsista> listaBolsistas = new ArrayList<>();
		Bolsista bolsista;
		
		String sql = "SELECT * FROM t_bolsista WHERE b_status = 1";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		ResultSet rs = (ResultSet) stmt.executeQuery();
		
		while (rs.next()) {
			bolsista = new Bolsista(rs.getString("b_telefone"), rs.getString("b_email"), rs.getString("b_nome"),
					rs.getString("b_curso"), rs.getString("b_matricula"), rs.getString("b_sexo"), 
					gHor.buscarHorario(rs.getInt("b_fk_horario")),
					rs.getInt("b_atividade"), rs.getInt("b_status"));
			listaBolsistas.add(bolsista);
		}
				
		conn.close();

		return listaBolsistas;
	}
	
	public Horario buscarHorarioBolsista(String matricula) throws SQLException{
		int idHor = 0;
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "SELECT b_fk_horario FROM t_bolsista WHERE b_matricula = ?";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matricula);

		ResultSet rs = (ResultSet) stmt.executeQuery();
		
		while (rs.next()) {
			idHor = rs.getInt("b_fk_horario");
		}
		
		return gHor.buscarHorario(idHor);
	}
	
	
	public int buscarIdHr(String matric) throws SQLException {

		conn = conexao.getConexaoMySQL();

		int id = 0;

		String sql = "SELECT b_fk_horario FROM t_bolsista "
				+ "WHERE b_matricula = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			id = rs.getInt("b_fk_horario"); 
		}
		
		return id;

	}
	
	public void persistirHorario(Horario h, String matric) throws SQLException{
		int id = buscarIdHr(matric);
		conn = conexao.getConexaoMySQL();
		
		if(id == 0){
			id = gHor.aramazenarHorario(h);
			String sql = "UPDATE t_bolsista SET b_fk_horario = ? WHERE b_matricula = ?";
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			stmt.setString(2, matric);
			
			stmt.execute();
			conn.close();
		}else{
			gHor.atualizarHorario(h, id);
		}
		
	}
	
	public void tipoAtividade(String matric, int idAtv) throws SQLException{
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "UPDATE t_bolsista SET b_atividade = ? WHERE b_matricula = ?";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
		
		stmt.setInt(1, idAtv);
		stmt.setString(2, matric);
		
		stmt.execute();
		conn.close();
		
	}
	
	public static void main(String[] args) throws SQLException {
		//System.out.println(new GerenciadorBolsista().buscarIdHr("5823"));
		System.out.println(new GerenciadorBolsista().buscarBolsistaNome("312").getMatricula());
	}

}

