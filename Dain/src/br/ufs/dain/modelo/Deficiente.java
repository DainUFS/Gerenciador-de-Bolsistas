package br.ufs.dain.modelo;

public class Deficiente extends Aluno {
	
	private String tipoDeficiencia;
	private int statusAtivacao;

	public Deficiente (String telefone, String email, String nome, String curso, 
			String matricula, String sexo,
			Horario horario, String tipoDeficiencia, int statusAtivacao) {
		super(telefone, email, nome, curso, matricula, sexo, horario);
		this.tipoDeficiencia = tipoDeficiencia;
		this.statusAtivacao = statusAtivacao;
	}

	public String getTipoDeficiencia() {
		return tipoDeficiencia;
	}

	public void setTipoDeficiencia(String tipoDeficiencia) {
		this.tipoDeficiencia = tipoDeficiencia;
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
