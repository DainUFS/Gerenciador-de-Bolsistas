package br.ufs.dain.modelo;

public class HorariosDain {

	private Bolsista bolsista;
	private Horario horario;
	
	public HorariosDain(Bolsista bolsista, Horario horario) {
		super();
		this.bolsista = bolsista;
		this.horario = horario;
	}
	
	public Bolsista getBolsista() {
		return bolsista;
	}
	public void setBolsista(Bolsista bolsista) {
		this.bolsista = bolsista;
	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
}
