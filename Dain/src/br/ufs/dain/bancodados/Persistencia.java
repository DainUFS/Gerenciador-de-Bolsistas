package br.ufs.dain.bancodados;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import br.ufs.dain.dominio.Administrador;
import br.ufs.dain.dominio.Bolsista;
import br.ufs.dain.dominio.Deficiente;
import br.ufs.dain.dominio.Horario;

public class Persistencia {
	
	Conexao conexao = new Conexao();
	Connection conn;
	Statement stmt;
	
	public void armazenarBolsista(Bolsista b, String matricAdm) throws SQLException{
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "INSERT INTO t_bolsista (b_matricula, b_nome, b_telefone, b_email, "
				+ "b_curso, b_sexo, b_fk_adm, b_fk_horario) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
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
	
	public void aramazenarAdm(Administrador a) throws SQLException{
		
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
	
	
	public void armazenarDeficiente(Deficiente d, String matricAdm) throws SQLException{
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "INSERT INTO t_deficiente (d_matricula, d_nome, d_telefone, d_email, d_curso, d_sexo, "
				+ "d_fk_horario, d_tipoDeficiencia, d_fk_adm) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
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
	
	public void aramazenarHorario(Horario h) throws SQLException{
		
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

	}
	
	public int buscarIdHorario(Horario h) throws SQLException{
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "SELECT h_id FROM t_horario "
				+ "WHERE h_segunda = ? and h_terca = ? and h_quarta = ?  and h_quinta = ?  and h_sexta = ? and h_sabado = ?;" ;
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
		
		stmt.setString(1, h.getSegunda());
		stmt.setString(2, h.getTerca());
		stmt.setString(3, h.getQuarta());
		stmt.setString(4, h.getQuinta());
		stmt.setString(5, h.getSexta());
		stmt.setString(6, h.getSabado());
		
		ResultSet rs = (ResultSet) stmt.executeQuery();
		
		while (rs.next()) {
			  int id = rs.getInt("h_id");
		}
		
		
		return 0;
	}
	
	
	public static void main(String[] args) throws SQLException {
		Persistencia per = new Persistencia();
		//Deficiente d = new Deficiente("09876543", "@souSangrento", "Tarantino", 
		//		"Pulp Fiction", "20122012", "M", null, "sangue");
		//per.armazenarDeficiente(d, "32509874");
		//Administrador a = new Administrador("113456", "Kubrick", "@leo", "32509874", "789456");
		//per.aramazenarAdm(a);
		//Bolsista b = new Bolsista("99999ggvnn9", "@alfred", "Alfred Hitchcook", "Cinema", "211053337882", "M", 
			//	null, 1);
		//per.armazenarBolsista(b, "32509874");
		//Horario h = new Horario("7h-8h", "9h-19h", null, null, "7h-12h", "9h-12h");
		//per.aramazenarHorario(h);
		Horario h = new Horario("s", "s", "s", "s", "s", "s");
		System.out.println(per.buscarIdHorario(h));
		
	}
	
}
