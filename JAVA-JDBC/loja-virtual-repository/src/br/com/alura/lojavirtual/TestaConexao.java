package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexao();
		
		System.out.println("Fechando conexão");
		
		con.close();
	}

}
