package br.com.petlove.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petlove.modelo.Usuario;

public class daoUsuarios extends conexaoBd {
	public boolean AdicionarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
		Connection conn = this.criarConexao();
		String nome, valor, idCondo, data;
		String insert = "INSERT INTO `petlove`.`usuarios`(`id`,`nome`,`cpf`,`email`,`cidade`,`estado`,`Endereco`,`senha`)VALUES("
				+ usuario.getId() + ",'" + usuario.getNome() + "','" + usuario.getCpf() + "','" + usuario.getEmail()
				+ "','" + usuario.getCidade() + "','" + usuario.getEstado() + "','" + usuario.getEndereco() + "','"
				+ usuario.getSenha() + "')";
		PreparedStatement prst = conn.prepareStatement(insert);
		System.out.println(insert);
		int rs = prst.executeUpdate();
		return true;
	}

	public List<Usuario> listarUsuarios() throws SQLException, ClassNotFoundException {
		Connection conn = this.criarConexao();
		String select = "select * from usuarios";
		PreparedStatement prst = conn.prepareStatement(select);
		ResultSet rs = null;
		System.out.println(select);
		rs = prst.executeQuery();
		List<Usuario> lista = new ArrayList<Usuario>();
		while (rs.next()) {
			Usuario user = new Usuario();
			user.setId(rs.getInt("id"));
			user.setCidade(rs.getString("cidade"));
			user.setCpf(rs.getLong("cpf"));
			user.setEmail(rs.getString("email"));
			user.setEndereco(rs.getString("endereco"));
			user.setEstado(rs.getString("estado"));
			user.setNome(rs.getString("nome"));
			user.setSenha(rs.getString("senha"));
			lista.add(user);
		}

		return lista;

	}

	public int ExcluirUsuario(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = this.criarConexao();
		String select = "delete from usuarios where id=" + id;
		PreparedStatement pstmt = conn.prepareStatement(select);
		int rs;
		rs = pstmt.executeUpdate();

		return rs;
	}

	public boolean updateUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
		Connection conn = this.criarConexao();
		String select = "UPDATE `petlove`.`usuarios`SET `nome` = '" + usuario.getNome() + "',`cpf` = '"
				+ usuario.getCpf() + "',`email` = '" + usuario.getEmail() + "',`cidade` = '" + usuario.getCidade()
				+ "',`estado` = '" + usuario.getEstado() + "',`Endereco` =' " + usuario.getEndereco() + "',`senha` ='"
				+ usuario.getSenha() + "'WHERE `id` =" + usuario.getId() + "";

		PreparedStatement pstmt = conn.prepareStatement(select);

		int rs;
		System.out.println(select);
		rs = pstmt.executeUpdate();

		return true;

	}

	public Usuario getUsuario(String email) throws SQLException, ClassNotFoundException {
		Connection conn = this.criarConexao();
		String select = "select * from usuarios where email = '" + email + "'";
		System.out.println(select);
		PreparedStatement prst = conn.prepareStatement(select);
		ResultSet rs = null;
		rs = prst.executeQuery();

		while (rs.next()) {
			Usuario user = new Usuario();
			user.setId(rs.getInt("id"));
			user.setCidade(rs.getString("cidade"));
			user.setEmail(rs.getString("email"));
			user.setEndereco(rs.getString("endereco"));
			user.setEstado(rs.getString("estado"));
			user.setNome(rs.getString("nome"));
			user.setSenha(rs.getString("senha"));
			return user;

		}
		return null;

	}

	public Usuario getUsuarioUnico(String id) throws ClassNotFoundException, SQLException {
		Connection conn = this.criarConexao();
		String select = "select * from usuarios where id = " + id + "";
		PreparedStatement prst = conn.prepareStatement(select);
		ResultSet rs = null;
		try {
			rs = prst.executeQuery();
			System.out.println(select);
					rs.next();
						Usuario user = new Usuario();
						user.setId(rs.getInt("id"));
						user.setCidade(rs.getString("cidade"));
						user.setEmail(rs.getString("email"));
						user.setEndereco(rs.getString("endereco"));
						user.setEstado(rs.getString("estado"));
						user.setNome(rs.getString("nome"));
						user.setSenha(rs.getString("senha"));
						return user;
					
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
	public boolean insertSessao(String token,String user) throws ClassNotFoundException, SQLException {
		Connection conn = this.criarConexao();
		String nome, valor, idCondo, data;
		String insert = "insert sessao(sessao,user) values('"+token+"','"+user+"') ";
		PreparedStatement prst = conn.prepareStatement(insert);
		System.out.println(insert);
		int rs = prst.executeUpdate();
		return true;
		
	}
}
