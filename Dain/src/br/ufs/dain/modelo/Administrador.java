package br.ufs.dain.modelo;

public class Administrador extends Pessoa {
	
	private String matricula;
	private String senha;
	private int statusAtivacao;
	
	public Administrador(String nome, String telefone, String email, String matricula, String senha, int statusAtivacao) {
		super(telefone, email, nome);
		this.matricula = matricula;
		this.senha = senha;
		this.statusAtivacao = statusAtivacao;
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

	public int getStatusAtivacao() {
		return statusAtivacao;
	}

	public void setStatusAtivacao(int statusAtivacao) {
		this.statusAtivacao = statusAtivacao;
	}	
	
}
