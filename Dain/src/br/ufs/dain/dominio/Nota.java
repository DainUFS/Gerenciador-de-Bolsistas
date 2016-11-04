package br.ufs.dain.dominio;

public class Nota {
	
	String anotacao;
	Administrador adm;
	
	public Nota(String anotacao, Administrador adm) {
		super();
		this.anotacao = anotacao;
		this.adm = adm;
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
