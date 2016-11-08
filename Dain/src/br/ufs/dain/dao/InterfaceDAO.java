package br.ufs.dain.dao;

import java.util.ArrayList;

import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Deficiente;
import br.ufs.dain.modelo.Horario;
import br.ufs.dain.modelo.Login;

public interface InterfaceDAO {

	public boolean cadastraDeficiente(Deficiente d, String matricAdm);
	
	public Deficiente getDeficienteMatricula(String matricula);
	
	public Deficiente getDeficienteNome(String nome);
	
	public boolean cadastrHorarioDef(Horario h, String matric);
	
	
	public boolean cadastraBolsista(Bolsista d, String matricAdm);
	
	public Bolsista getBolsistaMatricula(String matricula);
	
	public Bolsista getBolsistaNome(String nome);
	
	public boolean cadastrHorarioBolsista(Horario h, String matric);
	
	public ArrayList<Bolsista> buscarBolsistas ();
	
	public Horario buscarHorarioBolsista(String matricula);
	

	public boolean cadastrarAdm(Administrador a);
	
	public boolean validarLogin(Login login);
	
	public Administrador buscarAdm(String matric, String senha);
	
	
}
