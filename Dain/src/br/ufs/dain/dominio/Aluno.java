package br.ufs.dain.dominio;

import java.util.ArrayList;

public class Aluno extends Pessoa {

	private String curso;
	private String matricula;
	private String sexo;
	private ArrayList<Aluno> acompanhantes = new ArrayList<>();
	private ArrayList<String> horarios = new ArrayList<>();
	
	public Aluno(String telefone, String email, String nome, String curso, String matricula, String sexo,
			ArrayList<Aluno> acompanhantes, ArrayList<String> horarios) {
		super(telefone, email, nome);
		this.curso = curso;
		this.matricula = matricula;
		this.sexo = sexo;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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
