package br.ufs.dain.dominio;

import java.util.ArrayList;

public class Deficiente extends Aluno {
	
	private String tipoDeficiencia;

	public Deficiente(String telefone, String email, String nome, String curso, String matricula, String sexo,
			Horario horario, ArrayList<Aluno> acompanhantes, String tipoDeficiencia) {
		super(telefone, email, nome, curso, matricula, sexo, horario, acompanhantes);
		this.tipoDeficiencia = tipoDeficiencia;
	}

	public String getTipoDeficiencia() {
		return tipoDeficiencia;
	}

	public void setTipoDeficiencia(String tipoDeficiencia) {
		this.tipoDeficiencia = tipoDeficiencia;
	}

}
