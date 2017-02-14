package br.ufs.dain.modelo;

public class Bolsista extends Aluno {
	
	private int tipoAtividade;
	private String matriculaAdm;
	private int statusAtivacao;

	public Bolsista(String telefone, String email, String nome, String curso, 
			String matricula, String sexo,
			Horario horario, int tipoAtividade, int statusAtivacao) {
		super(telefone, email, nome, curso, matricula, sexo, horario);
		this.tipoAtividade = tipoAtividade;
		this.statusAtivacao = statusAtivacao;
	}
	
	public Bolsista(String telefone, String email, String nome, 
			String curso, String matricula, String sexo,
			Horario horario) {
		super(telefone, email, nome, curso, matricula, sexo, horario);
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

	public int getStatusAtivacao() {
		return statusAtivacao;
	}

	public void setStatusAtivacao(int statusAtivacao) {
		this.statusAtivacao = statusAtivacao;
	}

	@Override
	public int compareTo(Pessoa outro) {
		if (this.numero < outro.numero) {
            return -1;
        }
        if (this.numero > outro.numero) {
            return 1;
        }
        return 0;
	}
}
