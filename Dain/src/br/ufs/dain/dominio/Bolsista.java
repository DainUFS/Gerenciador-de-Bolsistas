package br.ufs.dain.dominio;

public class Bolsista extends Aluno {
	
	private int tipoAtividade;
	private String matriculaAdm;

	public Bolsista(String telefone, String email, String nome, String curso, String matricula, String sexo,
			Horario horario, int tipoAtividade) {
		super(telefone, email, nome, curso, matricula, sexo, horario);
		this.tipoAtividade = tipoAtividade;
	}

	public int getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(int tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
}
