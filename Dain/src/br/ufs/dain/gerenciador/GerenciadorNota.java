package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Nota;

public class GerenciadorNota {

	Conexao conexao = new Conexao();
	GerenciadorAdministrador ger_adm = new GerenciadorAdministrador();
	Connection conn;
	Statement stmt;

	public Nota buscarNota(String matric) throws SQLException {
		Nota nota = null;
		Administrador adm = ger_adm.buscarAdmMatricula(matric);

		conn = conexao.getConexaoMySQL();

		String sql = "SELECT * FROM t_nota WHERE n_fk_adm = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, matric);

		ResultSet rs = (ResultSet) stmt.executeQuery();

		while (rs.next()) {
			nota = new Nota(rs.getString("n_anotacao"), adm);
		}

		conn.close();

		return nota;
	}

	public void armazenarAnotacao(String matric, String novaAnotacao) throws SQLException {
		Nota nota = buscarNota(matric);

		conn = conexao.getConexaoMySQL();

		String sql = "UPDATE t_nota SET n_anotacao = ? WHERE n_fk_adm = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, nota.getAnotacao() + " " + novaAnotacao);
		stmt.setString(2, matric);

		stmt.execute();
		stmt.close();

		conn.close();

	}

	/*public void deletaNota(String anotacao) {
		Nota nota;

		conn = conexao.getConexaoMySQL();

		String sql = "UPDATE t_nota SET n_anotacao = ? WHERE n_fk_adm = ?";

		PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);

		stmt.setString(1, nota.getAnotacao() + " " + novaAnotacao);
		stmt.setString(2, matric);

		stmt.execute();
		stmt.close();

		conn.close();
	}
*/
}
