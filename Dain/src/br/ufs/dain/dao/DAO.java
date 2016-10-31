package br.ufs.dain.dao;

import java.sql.SQLException;

import br.ufs.dain.bancodados.Persistencia;
import br.ufs.dain.dominio.Administrador;
import br.ufs.dain.dominio.Bolsista;
import br.ufs.dain.dominio.Deficiente;
import br.ufs.dain.dominio.Horario;
import br.ufs.dain.dominio.Login;

public class DAO implements InterfaceDAO {

	Persistencia p = new Persistencia();

	@Override
	public boolean cadastraDeficiente(Deficiente d, String matricAdm) {
		try {
			p.armazenarDeficiente(d, matricAdm);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
	public boolean cadastraBolsista(Bolsista b, String matricAdm) {
		try {
			p.armazenarBolsista(b, matricAdm);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

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
	public boolean cadastrarAdm(Administrador a) {
		try {
			p.aramazenarAdm(a);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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

	@Override
	public boolean cadastrHorarioDef(Horario h, String matric) {
		// TODO Auto-generated method stub
		try {
			p.aramazenarHorarioDef(h, matric);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean cadastrHorarioBol(Horario h, String matric) {
		try {
			p.aramazenarHorarioBol(h, matric);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public Administrador buscarAdm(String matric, String senha) {
		try {
			return p.buscarAdm(matric, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public static void main(String[] args) {
		DAO dao = new DAO();
		//Login login = new Login("21", "21");
		//System.out.println(dao.validarLogin(login));
		//Horario h = new Horario("12h-16h", "08h-16h", "12h-16h", "12h-16h", "12h-16h", "12h-16h");
		//Deficiente d = new Deficiente("987455452", "@kubrick", "Stanley Kubrick", "Iluminado", "odisseia2001", "M", h, "louco");
		//System.out.println(dao.cadastraDeficiente(d, "32509874"));
		//System.out.println(dao.cadastrHorarioDef(h, "odisseia2001"));
		//System.out.println(dao.cadastrHorarioBol(h, "211053337882"));
		
		System.out.println(dao.buscarAdm("12345", "12345").getNome());
	}

	
	
}
