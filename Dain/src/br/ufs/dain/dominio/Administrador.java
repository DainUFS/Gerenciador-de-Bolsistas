package br.ufs.dain.dominio;

public class Administrador extends Pessoa {
	
	private String matricula;
	private String senha;
	
	public Administrador(String nome, String telefone, String email, String login, String senha) {
		super(nome, telefone, email);
		this.matricula = login;
		this.senha = senha;
	}
	
	public String getLogin() {
		return matricula;
	}


	public void setLogin(String login) {
		this.matricula = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
}
