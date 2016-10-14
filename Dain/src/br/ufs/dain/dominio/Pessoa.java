package br.ufs.dain.dominio;

public abstract class Pessoa {

	
	private String telefone;
	private String email;
	private String sexo;
	private String nome;
	
	public Pessoa(String nome, String telefone, String email, String sexo) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
	
}
