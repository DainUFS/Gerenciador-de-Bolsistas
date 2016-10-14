package br.ufs.dain.dominio;

import java.util.ArrayList;

public class Deficiente extends Aluno {
	
	private String tipoDeficiencia;

	public Deficiente(String telefone, String email, String nome, String curso, String matricula, String sexo,
			ArrayList<Aluno> acompanhantes, ArrayList<String> horarios, String tipoDeficiencia) {
		super(telefone, email, nome, curso, matricula, sexo, acompanhantes, horarios);
		this.tipoDeficiencia = tipoDeficiencia;
	}

	public String getTipoDeficiencia() {
		return tipoDeficiencia;
	}

	public void setTipoDeficiencia(String tipoDeficiencia) {
		this.tipoDeficiencia = tipoDeficiencia;
	}
		
}
