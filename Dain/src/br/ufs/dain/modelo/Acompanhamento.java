package br.ufs.dain.modelo;

public class Acompanhamento {

	private Bolsista bolsista;
	private Deficiente deficiente;
	private String hora;
	private String dia;
	
	public Acompanhamento(Bolsista bolsista, Deficiente deficiente, String hora, String dia) {
		super();
		this.bolsista = bolsista;
		this.deficiente = deficiente;
		this.hora = hora;
		this.dia = dia;
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	
	
}
