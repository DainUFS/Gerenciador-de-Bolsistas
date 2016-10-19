package br.ufs.dain.dominio;

import java.util.ArrayList;

public class Bolsista extends Aluno {
	
	private int tipoAtividade;
	private String matrAdm;

	public Bolsista(String telefone, String email, String nome, String curso, String matricula, String sexo,
			Horario horario, int tipoAtividade) {
		super(telefone, email, nome, curso, matricula, sexo, horario);
		this.tipoAtividade = tipoAtividade;
	}

	public int getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(short tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
}
