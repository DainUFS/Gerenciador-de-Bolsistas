package br.ufs.dain.modelo;

public class Discente {

	private Bolsista bolsista;
	private Deficiente deficiente;
	
	public Discente(Bolsista bolsista, Deficiente deficiente) {
		super();
		this.bolsista = bolsista;
		this.deficiente = deficiente;
	}
	public Bolsista getBolsista() {
		return bolsista;
	}
	public void setBolsista(Bolsista bolsista) {
		this.bolsista = bolsista;
	}
	public Deficiente getDeficiente() {
		return deficiente;
	}
	public void setDeficiente(Deficiente deficiente) {
		this.deficiente = deficiente;
	}
}
