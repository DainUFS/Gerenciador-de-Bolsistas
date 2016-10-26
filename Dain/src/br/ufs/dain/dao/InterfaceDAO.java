package br.ufs.dain.dao;

import br.ufs.dain.dominio.Administrador;
import br.ufs.dain.dominio.Bolsista;
import br.ufs.dain.dominio.Deficiente;
import br.ufs.dain.dominio.Login;

public interface InterfaceDAO {

	public void cadastraDeficiente(Deficiente d, String matricAdm);
	
	public Deficiente getDeficienteMatricula(String matricula);
	
	public Deficiente getDeficienteNome(String nome);
	
	public void cadastraBolsista(Bolsista d, String matricAdm);
	
	public Bolsista getBolsistaMatricula(String matricula);
	
	public Bolsista getBolsistaNome(String nome);
	
	public void cadastrarAdm(Administrador a);
	
	public boolean validarLogin(Login login);
	
}
