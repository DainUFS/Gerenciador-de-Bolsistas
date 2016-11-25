package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufs.dain.conexao.Conexao;

public class GerenciadorLogin {
	
	Conexao conexao = new Conexao();
	Connection conn;
	Statement stmt;
	
	GerenciadorAdministrador gAdm = new GerenciadorAdministrador();
	
	public boolean validarSenha(String login, String snh) throws SQLException{
		String senha = gAdm.buscarSenhaAdm(login);
		
		if(snh.equals(senha)) return true;
		else return false;
	}

}
