package br.ufs.dain.dominio;

import java.util.ArrayList;

public class Aluno extends Pessoa {

	private String curso;
	private String matricula;
	private String sexo;
	private Horario horario;
	private ArrayList<Aluno> acompanhantes = new ArrayList<>();
	
	public Aluno(String telefone, String email, String nome, String curso, String matricula, String sexo,
			Horario horario, ArrayList<Aluno> acompanhantes) {
		super(telefone, email, nome);
		this.curso = curso;
		this.matricula = matricula;
		this.sexo = sexo;
		this.horario = horario;
		this.acompanhantes = acompanhantes;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public ArrayList<Aluno> getAcompanhantes() {
		return acompanhantes;
	}

	public void setAcompanhantes(ArrayList<Aluno> acompanhantes) {
		this.acompanhantes = acompanhantes;
	}
}
