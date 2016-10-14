package br.ufs.dain.dominio;

import java.util.ArrayList;

public class Bolsista extends Aluno {
	
	private short tipoAtividade;

	public Bolsista(String telefone, String email, String nome, String curso, String matricula, String sexo,
			ArrayList<Aluno> acompanhantes, ArrayList<String> horarios, short tipoAtividade) {
		super(telefone, email, nome, curso, matricula, sexo, acompanhantes, horarios);
		this.tipoAtividade = tipoAtividade;
	}

	public short getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(short tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

}
