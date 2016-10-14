package br.ufs.dain.dominio;

import java.util.ArrayList;

public class Deficiente extends Aluno {
	
	private String tipoDeficiencia;

	public Deficiente(String nome, String telefone, String email, String sexo, String curso, String matricula,
			ArrayList<Aluno> acompanhantes, ArrayList<String> horarios, String tipoDeficiencia) {
		super(nome, telefone, email, sexo, curso, matricula, acompanhantes, horarios);
		this.tipoDeficiencia = tipoDeficiencia;
	}

	public String getTipoDeficiencia() {
		return tipoDeficiencia;
	}

	public void setTipoDeficiencia(String tipoDeficiencia) {
		this.tipoDeficiencia = tipoDeficiencia;
	}	
		
}
