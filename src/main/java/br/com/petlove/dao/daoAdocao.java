package br.com.petlove.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petlove.modelo.Adocao;

public class daoAdocao extends conexaoBd {

	public boolean AdicionarAdocao(Adocao adocao) throws ClassNotFoundException, SQLException {
		Connection conn = this.criarConexao();
		String insert = "INSERT INTO `petlove`.`formularioadocao`(`qtnAnimais`,`motivo`,`qtnmoradores`,"
				+ "`tipoMoradia`,`crianca`,`ficarsozinho`,`rendimento`,`idAnimal`,`idUser`)VALUES('"
				+ adocao.getQtnAnimail() + "'," + "'" + adocao.getMotivo() + "','" + adocao.getQtnmoradores() + "','"
				+ adocao.getTipoMoradia() + "','" + adocao.getCrianca() + "','" + adocao.getFicarsozinho() + "','"
				+ adocao.getRendimento() + "','" + adocao.getIdAnimal() + "','" + adocao.getIdUser() + "');";
		try {
			PreparedStatement prst = conn.prepareStatement(insert);
			System.out.println(insert);
			int rs = prst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;

		}

	}
	
	public List<Adocao> getAdocao(int idUser) throws ClassNotFoundException, SQLException{
		Connection conn = this.criarConexao();
		String select = "select * from Adocao where idUser like '"+idUser+"'";
		PreparedStatement prst = conn.prepareStatement(select);
		ResultSet rs = null;
		System.out.println(select);
		rs = prst.executeQuery();
		List<Adocao> lista = new ArrayList<Adocao>();
		while (rs.next()) {
			Adocao adocao = new Adocao();
			adocao.setId(rs.getInt("id"));
			adocao.setQtnAnimail(rs.getInt("qtnAnimais"));
			adocao.setMotivo(rs.getString("motivo"));
			adocao.setQtnmoradores(rs.getInt("qtnmoradores"));
			adocao.setTipoMoradia(rs.getString("tipoMoradia"));
			adocao.setCrianca(rs.getString("crianca"));
			adocao.setFicarsozinho(rs.getString("ficarsozinho"));
			adocao.setRendimento(rs.getDouble("rendimento"));
			adocao.setIdAnimal(rs.getInt("idAnimal"));
			adocao.setIdUser(rs.getInt("idUser"));
			lista.add(adocao);
		}

		return lista;

	}
		
	

}
