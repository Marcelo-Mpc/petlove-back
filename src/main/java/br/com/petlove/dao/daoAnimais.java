package br.com.petlove.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petlove.modelo.Animal;
import br.com.petlove.modelo.Usuario;

public class daoAnimais extends conexaoBd {
	public boolean AdicionarAnimais(Animal animal) throws ClassNotFoundException, SQLException {
		Connection conn = this.criarConexao();
		String nome, valor, idCondo, data;
		String insert = "INSERT INTO `petlove`.`animais`(`nome`,`nascimento`,`raca`,`sexo`,`caracteristicas`,`tamanho`,`comportamento`)VALUES('"
				+ animal.getNome() + "','" + animal.getNascimento() + "','" + animal.getRaca()
				+ "','" + animal.getSexo() + "','" + animal.getCaracteristicas() + "','"
				+ animal.getTamanho() + "','" + animal.getComportamento() +"')";
		try {
			PreparedStatement prst = conn.prepareStatement(insert);
			System.out.println(insert);
			int rs = prst.executeUpdate();
			return true;

		}catch(Exception e ){
			System.out.println(e);
			return false;

		}
		

	}

	public List<Animal> listarAnimais() throws SQLException, ClassNotFoundException {
		Connection conn = this.criarConexao();
		String select = "select * from Animais";
		PreparedStatement prst = conn.prepareStatement(select);
		ResultSet rs = null;
		System.out.println(select);
		rs = prst.executeQuery();
		List<Animal> lista = new ArrayList<Animal>();

		while (rs.next()) {
			Animal animal = new Animal();
			animal.setCaracteristicas(rs.getString("caracteristicas"));
			animal.setComportamento(rs.getString("comportamento"));
			animal.setCor(rs.getString("cor"));
			animal.setId(rs.getInt("id"));
			animal.setNascimento(rs.getString("nascimento"));
			animal.setNome(rs.getString("nome"));
			animal.setRaca(rs.getString("raca"));
			animal.setRaiva(rs.getString("raiva"));
			animal.setSexo(rs.getString("sexo"));
			animal.setTamanho(rs.getString("tamanho"));
			animal.setV10(rs.getString("v10"));
			lista.add(animal);
		}

		return lista;

	}

	public int excluirAnimal(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = this.criarConexao();
		String select = "delete from animais where id=" + id;
		PreparedStatement pstmt = conn.prepareStatement(select);
		int rs;
		rs = pstmt.executeUpdate();

		return rs;
	}

	public boolean updateAnimal(Animal animal) throws ClassNotFoundException, SQLException {
		Connection conn = this.criarConexao();
		String update = "UPDATE `petlove`.`animais`SET `id` = " + animal.getId() + ",`nome` =' " + animal.getNome()
				+ "',`nascimento` = '" + animal.getNascimento() + "',`raca` ='" + animal.getRaca() + "',`sexo` ='"
				+ animal.getSexo() + "',`cor` ='" + animal.getCor() + "',`caracteristicas` = '"
				+ animal.getCaracteristicas() + "',`tamanho` ='" + animal.getTamanho() + "',`comportamento` = '"
				+ animal.getComportamento() + "',`v10` = '" + animal.getV10() + "',`raiva` = '" + animal.getRaiva()
				+ "' WHERE `id` =" + animal.getId() + ";";

		PreparedStatement pstmt = conn.prepareStatement(update);

		int rs;
		System.out.println(update);
		rs = pstmt.executeUpdate();

		return true;

	}
}
