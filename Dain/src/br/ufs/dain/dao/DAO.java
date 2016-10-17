package br.ufs.dain.dao;

import br.ufs.dain.bancodados.Persistencia;
import br.ufs.dain.dominio.Administrador;
import br.ufs.dain.dominio.Bolsista;
import br.ufs.dain.dominio.Deficiente;

public class DAO implements InterfaceDAO {

	Persistencia P = new Persistencia();
	
	@Override
	public void cadastraDeficiente(Deficiente D) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Deficiente getDeficienteMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deficiente getDeficienteNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastraBolsista(Bolsista B) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Deficiente getBolsistaMatricula(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Deficiente getBolsistaNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrarAdm(Administrador A) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
