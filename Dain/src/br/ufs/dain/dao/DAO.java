package br.ufs.dain.dao;

import java.sql.SQLException;

import br.ufs.dain.bancodados.Persistencia;
import br.ufs.dain.dominio.Administrador;
import br.ufs.dain.dominio.Bolsista;
import br.ufs.dain.dominio.Deficiente;

public class DAO implements InterfaceDAO {

	Persistencia p = new Persistencia();
	
	@Override
	public void cadastraDeficiente(Deficiente d, String matricAdm) {
		try {
			p.armazenarDeficiente(d, matricAdm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public void cadastraBolsista(Bolsista b, String matricAdm) {
		try {
			p.armazenarBolsista(b, matricAdm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
	public void cadastrarAdm(Administrador a) {
		try {
			p.aramazenarAdm(a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
