package br.ufs.dain.dominio;

public abstract class Pessoa {

	private String telefone;
	private String email;
	private String nome;
	
	public Pessoa(String telefone, String email, String nome) {
		super();
		this.telefone = telefone;
		this.email = email;
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
