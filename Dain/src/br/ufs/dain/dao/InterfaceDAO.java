package br.ufs.dain.dao;

import java.util.ArrayList;

import br.ufs.dain.modelo.Administrador;
import br.ufs.dain.modelo.Bolsista;
import br.ufs.dain.modelo.Deficiente;
import br.ufs.dain.modelo.Acompanhamento;
import br.ufs.dain.modelo.Horario;
import br.ufs.dain.modelo.HorariosApoio;
import br.ufs.dain.modelo.Login;
import br.ufs.dain.modelo.Nota;

public interface InterfaceDAO {
	
	
	//Deficiente
	public boolean cadastraDeficiente(Deficiente d, String matricAdm);
	
	public Deficiente getDeficienteMatricula(String matricula);
	
	public Deficiente getDeficienteNome(String nome);
	
	public boolean cadastrHorarioDeficiente(Horario h, String matric);
	
	public ArrayList<Deficiente> buscarDeficiente ();
	
	public Horario buscarHorarioDeficiente(String matricula);
	
	
	//Bolsista
	public boolean cadastraBolsista(Bolsista d, String matricAdm);
	
	public Bolsista getBolsistaMatricula(String matricula);
	
	public Bolsista getBolsistaNome(String nome);
	
	public boolean cadastrarHorarioBolsista(Horario h, String matric);
	
	public ArrayList<Bolsista> buscarBolsistas();
	
	public Horario buscarHorarioBolsista(String matricula);
	
	public void tipoAtividade (String matric, int idAtv);
	
	public void hrTrabalho(String dia, String hora, String matric);
	
	public void criarHrTrabalho(Horario h, String matric);
	
	public Horario buscarHorarioBolsistaT(String matricula);
	
	public ArrayList<HorariosApoio> buscarBolsistasApoio();
	
	public ArrayList<Bolsista> buscarBolsistasDain();
	
	public ArrayList<Bolsista> buscarBolsistasBicen();
	
	
	//Administrador
	public boolean cadastrarAdm(Administrador a);
	
	public Administrador getAdm(String nome);
	
	public boolean validarLogin(Login login);
	
	public Administrador buscarAdm(String matric, String senha);
	
	public ArrayList<Administrador> buscarAdm();
	
	public void atualizarDados(Administrador adm, String mat);
	
	public void mudarSenha(Administrador adm, String novaSenha);
	
	
	//Notas
	public void cadastrarNota(String matric, String anotacao);
	
	public void deletarNota(String anotacao);
	
	public ArrayList<Nota> buscarNota(String matric);
	
	public void editarNota(String novaNota, String antigaNota);
	
	public ArrayList<Nota> TodasAsNota();
	
	
	//Horario
	public int aramazenarHor(Horario hr);
	
	
	//Acompanhamento
	public void salvarAcomapanhamento(Acompanhamento acompanhamento);
	
//	public ArrayList<Acompanhamento> listaAcompanhamento(); 
	
	
}
