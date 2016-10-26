package br.ufs.dain.dao;

import java.sql.SQLException;

import br.ufs.dain.bancodados.Persistencia;
import br.ufs.dain.dominio.Administrador;
import br.ufs.dain.dominio.Bolsista;
import br.ufs.dain.dominio.Deficiente;
import br.ufs.dain.dominio.Login;

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
		try {
			p.buscarDeficienteM(matricula);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Deficiente getDeficienteNome(String nome) {
		try {
			p.buscarBolsistaN(nome);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public Bolsista getBolsistaMatricula(String matricula) {
		// TODO Auto-generated method stub
		try {
			return p.buscarBolsistaM(matricula);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Bolsista getBolsistaNome(String nome) {
		try {
			p.buscarBolsistaN(nome);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public boolean validarLogin(Login login) {
		// TODO Auto-generated method stub

		try {
			if(p.buscarSenhaAdm(login.getLogin()) != null &&
					p.buscarSenhaAdm(login.getLogin()).equals(login.getSenha())) 
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		Login login = new Login("21", "21");
		System.out.println(dao.validarLogin(login));
	}
}
