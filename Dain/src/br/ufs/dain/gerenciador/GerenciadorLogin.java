package br.ufs.dain.gerenciador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.ufs.dain.conexao.Conexao;
import br.ufs.dain.modelo.Administrador;

public class GerenciadorLogin {
	
	Conexao conexao = new Conexao();
	Connection conn;
	Statement stmt;
	
	GerenciadorAdministrador gAdm = new GerenciadorAdministrador();
	
	Administrador administrador = null;
	
	public boolean validarSenha(String login, String senha) throws SQLException{
		administrador = gAdm.buscarAdmAtivo(login, senha);
		if(administrador != null){
			return true;
		}else return false;
	}
	
	public static void main(String[] args) throws SQLException {
		GerenciadorLogin g = new GerenciadorLogin();
		System.out.println(g.validarSenha("123", "123"));
	}

}
