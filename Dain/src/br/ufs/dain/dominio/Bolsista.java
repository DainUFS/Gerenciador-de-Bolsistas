package br.ufs.dain.dominio;

import java.util.ArrayList;

public class Bolsista extends Aluno {
	
	private short tipoAtividade;

	public Bolsista(String nome, String telefone, String email, String sexo, String curso, String matricula,
			ArrayList<Aluno> acompanhantes, ArrayList<String> horarios, short tipoAtividade) {
		super(nome, telefone, email, sexo, curso, matricula, acompanhantes, horarios);
		this.tipoAtividade = tipoAtividade;
	}

	public short getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(short tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
	
	
}
