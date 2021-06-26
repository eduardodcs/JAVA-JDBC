package br.com.alura.lojavirtual;

import java.sql.SQLException;

public class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory con = new ConnectionFactory();
		for (int i= 0; i < 20; i ++) {
			con.recuperarConexao();
			System.out.println("Conexão de número: " + i);
		}

	}

}
