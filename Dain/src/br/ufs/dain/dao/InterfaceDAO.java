package br.ufs.dain.dao;

import br.ufs.dain.dominio.Administrador;
import br.ufs.dain.dominio.Bolsista;
import br.ufs.dain.dominio.Deficiente;

public interface InterfaceDAO {

	public void cadastraDeficiente(Deficiente D);
	
	public Deficiente getDeficienteMatricula(String matricula);
	
	public Deficiente getDeficienteNome(String nome);
	
	public void cadastraBolsista(Bolsista B);
	
	public Deficiente getBolsistaMatricula(String matricula);
	
	public Deficiente getBolsistaNome(String nome);
	
	
	public void cadastrarAdm(Administrador A);
	
	
	
}
