package br.ufs.dain.dominio;

public abstract class Pessoa {

	private String nome;
	private String telefone;
	private String email;
	
	public Pessoa(String nome, String telefone, String email) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}
	
}
