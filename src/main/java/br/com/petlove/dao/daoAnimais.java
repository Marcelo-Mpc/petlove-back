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
		String insert =" INSERT INTO `petlove`.`animais`"+
				"(`nome`,`idade`,`tempo`,`raca`,`caracteristicas`,`especie`,`sexo`,`comportamento`,"
				+ "`imagem`,`status`)VALUES('"+animal.getNome()+"','"+animal.getIdade()+"','"+animal.getTempo()+"','"+animal.getRaca()+"','"+animal.getCaracteristicas()+"',"
				+ "'"+animal.getEspecie()+"','"+animal.getSexo()+"','"+animal.getComportamento()+"','"+animal.getImagem()+"','"+animal.getStatus()+"')";
				System.out.println(insert);

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
			animal.setId(rs.getInt("id"));
			animal.setNome(rs.getString("nome"));
			animal.setIdade((rs.getString("idade")));
			animal.setTempo(rs.getString("tempo"));
			animal.setRaca(rs.getString("raca"));
			animal.setCaracteristicas(rs.getString("caracteristicas"));
			animal.setEspecie(rs.getString("especie"));
			animal.setSexo(rs.getString("sexo"));
			animal.setTamanho(rs.getString("tamanho"));
			animal.setComportamento(rs.getString("comportamento"));
			animal.setImagem(rs.getString("imagem"));

			lista.add(animal);
		}

		return lista;

	}
	public Animal AnimailUnico(String id) throws SQLException, ClassNotFoundException {
		Connection conn = this.criarConexao();
		String select = "select * from Animais where id like " +id;
		PreparedStatement prst = conn.prepareStatement(select);
		ResultSet rs = null;
		System.out.println(select);
		rs = prst.executeQuery();

		rs.next();
			Animal animal = new Animal();
			animal.setId(rs.getInt("id"));
			animal.setNome(rs.getString("nome"));
			animal.setIdade((rs.getString("idade")));
			animal.setTempo(rs.getString("tempo"));
			animal.setRaca(rs.getString("raca"));
			animal.setCaracteristicas(rs.getString("caracteristicas"));
			animal.setEspecie(rs.getString("especie"));
			animal.setSexo(rs.getString("sexo"));
			animal.setTamanho(rs.getString("tamanho"));
			animal.setComportamento(rs.getString("comportamento"));
			animal.setImagem(rs.getString("imagem"));


		return animal;

	}

	public int excluirAnimal(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = this.criarConexao();
		String select = "delete from animais where id=" + id;
		PreparedStatement pstmt = conn.prepareStatement(select);
		int rs;
		rs = pstmt.executeUpdate();

		return rs;
	}

	/*public boolean updateAnimal(Animal animal) throws ClassNotFoundException, SQLException {
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

	}*/
}
