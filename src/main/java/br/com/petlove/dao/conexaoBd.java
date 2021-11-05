package br.com.petlove.dao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



public class conexaoBd {
	private String login ="root";
	private String senha = "Tesla@523897";
	
	private String dbName = "petlove";
	private String url = "jdbc:mysql://127.0.0.1:3306/" + dbName+"?useTimezone=true&serverTimezone=UTC";
	public Connection conexao = null;
	
	public conexaoBd() {	}
	
	public Connection criarConexao() throws SQLException, ClassNotFoundException{
	  
	    try {
	    	
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    }
	    catch(ClassNotFoundException ex)
	    {
	    	return null;
	    }
	    
	   
	    this.conexao = (Connection)DriverManager.getConnection(url, login, senha);
	    	
	  
	    
	    return this.conexao;
	}
	
	
	  public static void main(String [] args) throws SQLException,
	  ClassNotFoundException {
	  
	  conexaoBd conexao = new conexaoBd();
	  
	  Connection conn =conexao.criarConexao();
	  System.out.println(conn);
	  }

}