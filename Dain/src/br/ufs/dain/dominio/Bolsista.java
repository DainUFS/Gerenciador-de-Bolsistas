package br.ufs.dain.dominio;

import java.util.ArrayList;

public class Bolsista extends Aluno {
	
	private short tipoAtividade;

	public Bolsista(String telefone, String email, String nome, String curso, String matricula, String sexo,
			Horario horario, ArrayList<Aluno> acompanhantes, short tipoAtividade) {
		super(telefone, email, nome, curso, matricula, sexo, horario, acompanhantes);
		this.tipoAtividade = tipoAtividade;
	}

	public short getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(short tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
}
