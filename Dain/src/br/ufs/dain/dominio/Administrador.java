package br.ufs.dain.dominio;

public class Administrador extends Pessoa {
	
	private String matricula;
	private String senha;
	
	public Administrador(String nome, String telefone, String email, String matricula, String senha) {
		super(nome, telefone, email);
		this.matricula = matricula;
		this.senha = senha;
	}
	
	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
}
