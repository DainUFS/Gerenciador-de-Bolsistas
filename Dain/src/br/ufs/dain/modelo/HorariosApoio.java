package br.ufs.dain.modelo;

public class HorariosApoio {
	
	private Bolsista bolsista;
	private Deficiente deficiente;
	private String dia;
	private String hora;
	
	public HorariosApoio(Bolsista bolsista, Deficiente deficiente, String dia, String hora) {
		super();
		this.bolsista = bolsista;
		this.deficiente = deficiente;
		this.dia = dia;
		this.hora = hora;
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

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
}
