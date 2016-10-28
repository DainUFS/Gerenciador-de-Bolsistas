package br.ufs.dain.dominio;

public class Deficiente extends Aluno {
	
	private String tipoDeficiencia;

	public Deficiente (String telefone, String email, String nome, String curso, String matricula, String sexo,
			Horario horario, String tipoDeficiencia) {
		super(telefone, email, nome, curso, matricula, sexo, horario);
		this.tipoDeficiencia = tipoDeficiencia;
	}

	public String getTipoDeficiencia() {
		return tipoDeficiencia;
	}

	public void setTipoDeficiencia(String tipoDeficiencia) {
		this.tipoDeficiencia = tipoDeficiencia;
	}
}
