package br.ufs.dain.modelo;

public abstract class Aluno extends Pessoa {

	private String curso;
	private String matricula;
	private String sexo;
	private Horario horario;
	
	public Aluno(String telefone, String email, String nome, String curso, String matricula, String sexo, Horario horario) {
		super(telefone, email, nome);
		this.curso = curso;
		this.matricula = matricula;
		this.sexo = sexo;
		this.horario = horario;
	}

	public String getCurso() {
		return curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getSexo() {
		return sexo;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
}
