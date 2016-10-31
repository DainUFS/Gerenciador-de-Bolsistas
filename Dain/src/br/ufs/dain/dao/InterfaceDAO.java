package br.ufs.dain.dao;

import br.ufs.dain.dominio.Administrador;
import br.ufs.dain.dominio.Bolsista;
import br.ufs.dain.dominio.Deficiente;
import br.ufs.dain.dominio.Horario;
import br.ufs.dain.dominio.Login;

public interface InterfaceDAO {

	public boolean cadastraDeficiente(Deficiente d, String matricAdm);
	
	public Deficiente getDeficienteMatricula(String matricula);
	
	public Deficiente getDeficienteNome(String nome);
	
	public boolean cadastrHorarioDef(Horario h, String matric);
	
	
	public boolean cadastraBolsista(Bolsista d, String matricAdm);
	
	public Bolsista getBolsistaMatricula(String matricula);
	
	public Bolsista getBolsistaNome(String nome);
	
	public boolean cadastrHorarioBol(Horario h, String matric);
	

	public boolean cadastrarAdm(Administrador a);
	
	public boolean validarLogin(Login login);
	
	public Administrador buscarAdm(String matric, String senha);
	
}
