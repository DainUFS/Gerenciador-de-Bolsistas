package br.ufs.dain.dominio;

public class Administrador extends Pessoa {
	
	private String login;
	private String senha;
	
	public Administrador(String nome, String telefone, String email, String login, String senha) {
		super(nome, telefone, email);
		this.login = login;
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
}
