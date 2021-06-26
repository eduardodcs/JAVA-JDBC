package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection con = connectionFactory.recuperarConexao()){
			try(PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO")){
				stm.execute();
				exibirListagem(stm);
			};
		}
	}
	
	public static void exibirListagem(PreparedStatement stm) throws SQLException {
		try(ResultSet rst = stm.getResultSet()){
			while(rst.next()) {
				Integer id = rst.getInt("ID");
				System.out.println(id);
				String nome = rst.getString("NOME");
				System.out.println(nome);
				String descricao = rst.getString("DESCRICAO");
				System.out.println(descricao);
			}
		}
	}

}
