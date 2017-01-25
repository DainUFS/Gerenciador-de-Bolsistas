package br.ufs.dain.modelo;

public class Nota {
	
	String anotacao;
	String data;
	Administrador adm;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Nota(String anotacao, Administrador adm, String data) {
		super();
		this.anotacao = anotacao;
		this.adm = adm;
		this.data = data;
	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

	public Administrador getAdm() {
		return adm;
	}

	public void setAdm(Administrador adm) {
		this.adm = adm;
	}
		
	
	

}
