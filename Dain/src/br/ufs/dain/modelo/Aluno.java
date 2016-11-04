package br.ufs.dain.modelo;

public abstract class Aluno extends Pessoa {

	private String curso;
	private String matricula;
	private String sexo;
	private Horario horario;
	
	public Aluno(String nome, String telefone, String email, String curso, String matricula, String sexo, Horario horario) {
		super(nome, telefone, email);
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

}
