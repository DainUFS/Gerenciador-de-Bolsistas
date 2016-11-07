package br.ufs.dain.modelo;

public class Administrador extends Pessoa {
	
	private String matricula;
	private String senha;
	
	public Administrador(String telefone, String email, String nome, String matricula, String senha) {
		super(telefone, email, nome);
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
