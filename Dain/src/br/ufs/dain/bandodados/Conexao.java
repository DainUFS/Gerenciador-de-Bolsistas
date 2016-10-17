package br.ufs.dain.bandodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	 
	public static String status = "Não conectou...";
	 
	public Conexao() {}
	 
	 
	public static java.sql.Connection getConexaoMySQL() {
	        Connection connection = null;          

	        try {
		
	        	String driverName = "com.mysql.jdbc.Driver"; 
	        	Class.forName(driverName);
	 
	        	String serverName = "localhost:3306";    //caminho do servidor do BD
	 
	        	String mydatabase = "sakila";        //nome do seu banco de dados
	 
	        	String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
	 
	        	String username = "root";        //nome de um usuário de seu BD      
	 
	        	String password = "dainsql";      //sua senha de acesso
	 
	        	connection = DriverManager.getConnection(url, username, password);
	 
	  
	        	if (connection != null) 
	        		System.out.println("Conectou!");
	        	else 
	        		System.out.println("Não Conectou!");;
	    
	 
	        	return connection;
	 
	        } catch (ClassNotFoundException e) {  //Driver não encontrado
	 
	        	System.out.println("O driver expecificado nao foi encontrado.");
	 
	        	return null;
	 
	        } catch (SQLException e) {
	 
	        	System.out.println("Nao foi possivel conectar ao Banco de Dados.");
		 
	        	return null;
	     
	        }
	
	}
	 
	public static String statusConection() {
		return status;
	 
	 }
	 
	 
	 public static boolean FecharConexao() {
		 try {
			 Conexao.getConexaoMySQL().close();
			 return true;
	 
	     } catch (SQLException e) {
	            return false;
	     }
	 
	  }
	 
	 
	 public static java.sql.Connection ReiniciarConexao() {
	    FecharConexao();
	    return Conexao.getConexaoMySQL();
	 
	 }
	
	 public static void main(String[] args) {
		java.sql.Connection c;
		Conexao con = new Conexao();
		c = con.getConexaoMySQL();
	}
}
