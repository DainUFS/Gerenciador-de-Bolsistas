package br.ufs.dain.dominio;

import java.util.ArrayList;

public class Aluno extends Pessoa {

	private String curso;
	private String matricula;
	private ArrayList<Aluno> acompanhantes = new ArrayList<>();
	private ArrayList<String> horarios = new ArrayList<>();
	
	public Aluno(String nome, String telefone, String email, String sexo, String curso, String matricula,
			ArrayList<Aluno> acompanhantes, ArrayList<String> horarios) {
		super(nome, telefone, email, sexo);
		this.curso = curso;
		this.matricula = matricula;
		this.acompanhantes = acompanhantes;
		this.horarios = horarios;
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

	public ArrayList<Aluno> getAcompanhantes() {
		return acompanhantes;
	}

	public void setAcompanhantes(ArrayList<Aluno> acompanhantes) {
		this.acompanhantes = acompanhantes;
	}

	public ArrayList<String> getHorarios() {
		return horarios;
	}

	public void setHorarios(ArrayList<String> horarios) {
		this.horarios = horarios;
	}
	
	
}
