package br.ufs.dain.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ufs.dain.gerenciador.GerenciadorAdministrador;
import br.ufs.dain.gerenciador.GerenciadorBolsista;
import br.ufs.dain.gerenciador.GerenciadorDeficiente;
import br.ufs.dain.gerenciador.GerenciadorHorario;
import br.ufs.dain.gerenciador.GerenciadorLogin;
import br.ufs.dain.gerenciador.GerenciadorNota;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Deficiente;
import br.ufs.dain.modelo.Horario;
import br.ufs.dain.modelo.Login;

public class DAO implements InterfaceDAO {
	
	GerenciadorAdministrador gAdm = new GerenciadorAdministrador();
	GerenciadorBolsista gBol = new GerenciadorBolsista();
	GerenciadorDeficiente gDef = new GerenciadorDeficiente();
	GerenciadorHorario gHor = new GerenciadorHorario();
	GerenciadorLogin gLogin = new GerenciadorLogin();
	GerenciadorNota gNota = new GerenciadorNota();

	@Override
	public boolean cadastraDeficiente(Deficiente d, String matricAdm) {
		try {
			gDef.armazenarDeficiente(d, matricAdm);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Deficiente getDeficienteMatricula(String matricula) {
		try {
			gDef.buscarDeficienteMatricula(matricula);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Deficiente getDeficienteNome(String nome) {
		try {
			gDef.buscarDeficienteNome(nome);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean cadastraBolsista(Bolsista b, String matricAdm) {
		try {
			gBol.armazenarBolsista(b, matricAdm);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Bolsista getBolsistaMatricula(String matric) {
		// TODO Auto-generated method stub
		try {
			return gBol.buscarBolsistaMatricula(matric);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Bolsista getBolsistaNome(String nome) {
		try {
			gBol.buscarBolsistaNome(nome);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean cadastrarAdm(Administrador a) {
		try {
			gAdm.aramazenarAdm(a);
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
			if(gAdm.buscarSenhaAdm(login.getLogin()) != null &&
					gAdm.buscarSenhaAdm(login.getLogin()).equals(login.getSenha())) 
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean cadastrHorarioDef(Horario h, String matric) {
	/*	// TODO Auto-generated method stub
		try {
			//gHor.aramazenarHorarioDef(h, matric);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return false;
	}
	
	@Override
	public boolean cadastrarHorarioBolsista(Horario h, String matric) {
		try {
			gHor.aramazenarHorarioBol(h, matric);
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
			return gAdm.buscarAdmAtivo(matric, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Bolsista> buscarBolsistas() {
		
		try {
			return gBol.listarBolsistas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public Horario buscarHorarioBolsista(String matricula) {
		try {
			return gBol.buscarHorarioBolsista(matricula);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public static void main(String[] args) {
		System.out.println(new DAO().buscarAdm("794613", "xurita").getNome());
	}

	@Override
	public ArrayList<Deficiente> buscarDeficiente() {
		// TODO Auto-generated method stub
		try {
			return gDef.listarDeficiente();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public ArrayList<Administrador> buscarAdm() {
		try {
			return gAdm.listarAdm();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
