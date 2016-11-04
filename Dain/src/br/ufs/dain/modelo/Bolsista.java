package br.ufs.dain.modelo;

public class Bolsista extends Aluno {
	
	private int tipoAtividade;
	private String matriculaAdm;

	public Bolsista(String nome, String telefone, String email, String curso, String matricula, String sexo,
			Horario horario, int tipoAtividade) {
		super(nome, telefone, email, curso, matricula, sexo, horario);
		this.tipoAtividade = tipoAtividade;
	}
	
	public Bolsista(String nome, String telefone, String email, String curso, String matricula, String sexo,
			Horario horario) {
		super(nome, telefone, email, curso, matricula, sexo, horario);
	}

	public int getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(int tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public String getMatriculaAdm() {
		return matriculaAdm;
	}

	public void setMatriculaAdm(String matriculaAdm) {
		this.matriculaAdm = matriculaAdm;
	}

}
