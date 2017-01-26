package br.ufs.dain.modelo;

public abstract class Pessoa implements Comparable<Pessoa> {

	private String telefone;
	private String email;
	private String nome;
	protected int numero;
	
	public Pessoa(String telefone, String email, String nome) {
		super();
		this.telefone = telefone;
		this.email = email;
		this.nome = nome;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
