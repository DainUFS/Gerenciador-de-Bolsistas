package br.ufs.dain.modelo;

public class Administrador extends Pessoa{
	
	private String matricula;
	private String senha;
	private int statusAtivacao;
	
	private int numero;
	
	public Administrador(String email, String nome, String telefone, String matricula, String senha, int statusAtivacao) {
		super(telefone, nome, email);
		this.matricula = matricula;
		this.senha = senha;
		this.statusAtivacao = statusAtivacao;
	}
	
	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
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
