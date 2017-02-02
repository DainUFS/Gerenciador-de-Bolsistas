package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Acompanhamento;

public class GerenciadorAcompanhamento {
	
	Conexao conexao = new Conexao();
	Connection conn;
	Statement stmt;
	
	GerenciadorBolsista gb = new GerenciadorBolsista();
	GerenciadorDeficiente gd = new GerenciadorDeficiente();
	
	public void aramazerAcompanhamento(Acompanhamento acompanhamento) throws SQLException{
		
		conn = conexao.getConexaoMySQL();
		
		String sql = "INSERT INTO t_acompanhamento (a_d_matricula, a_b_matricula, a_hora, a_dia)"
				+ "VALUES (?, ?, ?, ?)";
		
		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, acompanhamento.getDeficiente().getMatricula());
		stmt.setString(2, acompanhamento.getBolsista().getMatricula());
		stmt.setString(3, acompanhamento.getHora());
		stmt.setString(4, acompanhamento.getDia());
		
		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		conn.close();
		
	}
//	
//	public ArrayList<Acompanhamento> buscarAmcompanhados() throws SQLException{
//		
//		conn = conexao.getConexaoMySQL();
//		
//		ArrayList<Acompanhamento> acompanhamento = new ArrayList<>();
//		Acompanhamento discente;
//		
//		String sql = "SELECT * FROM t_acompanhamento";
//		
//		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
//
//		ResultSet rs = (ResultSet) stmt.executeQuery();
//		
//		while (rs.next()) {
//			discente = new Acompanhamento(gb.buscarBolsistaMatricula(rs.getString("a_b_matricula")), 
//					gd.buscarDeficienteMatricula(rs.getString("a_d_matricula")));
//		}
//				
//		conn.close();
//
//		return acompanhamento;
//		
//	}

}
