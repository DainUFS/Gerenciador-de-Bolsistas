package br.ufs.dain.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ufs.dain.gerenciador.GerenciadorAdministrador;
import br.ufs.dain.gerenciador.GerenciadorBolsista;
import br.ufs.dain.gerenciador.GerenciadorDeficiente;
import br.ufs.dain.gerenciador.GerenciadorHorTrabalho;
import br.ufs.dain.gerenciador.GerenciadorHorario;
import br.ufs.dain.gerenciador.GerenciadorLogin;
import br.ufs.dain.gerenciador.GerenciadorNota;
import br.ufs.dain.gerenciador.GerenciadorAcompanhamento;
import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Deficiente;
import br.ufs.dain.modelo.Acompanhamento;
import br.ufs.dain.modelo.Horario;
import br.ufs.dain.modelo.Login;
import br.ufs.dain.modelo.Nota;

public class DAO implements InterfaceDAO {
	
	GerenciadorAdministrador gAdm = new GerenciadorAdministrador();
	GerenciadorBolsista gBol = new GerenciadorBolsista();
	GerenciadorDeficiente gDef = new GerenciadorDeficiente();
	GerenciadorHorario gHor = new GerenciadorHorario();
	GerenciadorLogin gLogin = new GerenciadorLogin();
	GerenciadorNota gNota = new GerenciadorNota();
	GerenciadorAcompanhamento gAcom = new GerenciadorAcompanhamento();
	GerenciadorHorTrabalho gHT = new GerenciadorHorTrabalho();
	
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
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Deficiente getDeficienteNome(String nome) {
		try {
			return gDef.buscarDeficienteNome(nome);
		} catch (SQLException e) {
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
		try {
			return gBol.buscarBolsistaMatricula(matric);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Bolsista getBolsistaNome(String nome) {
		try {
			return gBol.buscarBolsistaNome(nome);
		} catch (SQLException e) {
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
		try {
			if(gAdm.buscarSenhaAdm(login.getLogin()) != null &&
					gAdm.buscarSenhaAdm(login.getLogin()).equals(login.getSenha())) 
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean cadastrHorarioDeficiente(Horario h, String matric) {
		try {
			gDef.persistirHorario(h, matric);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean cadastrarHorarioBolsista(Horario h, String matric) {
		try {
			gBol.persistirHorario(h, matric);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public Administrador buscarAdm(String matric, String senha) {
		try {
			return gAdm.buscarAdmAtivo(matric, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Bolsista> buscarBolsistas() {
		
		try {
			return gBol.listarBolsistas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public Horario buscarHorarioBolsista(String matricula) {
		try {
			return gBol.buscarHorarioBolsista(matricula);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Deficiente> buscarDeficiente() {
		try {
			return gDef.listarDeficiente();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public ArrayList<Administrador> buscarAdm() {
		try {
			return gAdm.listarAdm();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void cadastrarNota(String matric, String anotacao) {
		try {
			gNota.armazenarAnotacao(matric, anotacao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletarNota(String anotacao) {
		try {
			gNota.deletaNota(anotacao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Nota> buscarNota(String matric) {
		ArrayList<Nota> notas = null;
		try {
			notas = gNota.buscarNotas(matric);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notas;
	}

	@Override
	public Horario buscarHorarioDeficiente(String matricula) {
		try {
			return gDef.buscarHorarioDeficiente(matricula);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void editarNota(String novaNota, String nota) {
		try {
			gNota.editarNota(nota, novaNota);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int aramazenarHor(Horario hr) {
		try {
			 return gHor.aramazenarHorario(hr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void atualizarDados(Administrador adm, String mat) {
		try {
			gAdm.altualizarDados(adm, mat);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void mudarSenha(Administrador adm, String novaSenha) {
		try {
			gAdm.mudarSenha(adm, novaSenha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Nota> TodasAsNota() {
		ArrayList<Nota> notas = null;
		try {
			notas = gNota.TodasAsNotas();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notas;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new DAO().buscarDeficiente().get(0).getNome());
	}

	@Override
	public void salvarAcomapanhamento(Acompanhamento acompanhamento) {
		try {
			gAcom.aramazerAcompanhamento(acompanhamento);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Administrador getAdm(String nome) {
		try {
			return gAdm.getAdm(nome);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void tipoAtividade(String matric, int idAtv) {
		try {
			gBol.tipoAtividade(matric, idAtv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void hrTrabalho(String dia, String hora, String matric) {
		try {
			gHT.atualizarHorario(dia, hora, matric);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void criarHrTrabalho(Horario h, String matric) {
		try {
			gHT.criarHorario(h, matric);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Horario buscarHorarioBolsistaT(String matricula) {
		try {
			return gHT.buscarHorario(matricula);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
