		package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection con = connectionFactory.recuperarConexao()){
			con.setAutoCommit(false); //tira o auto commit do JDBC
			
			try (PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)"
					, Statement.RETURN_GENERATED_KEYS); //colocado  o statement no try não precisa fazer o fechamento stm.close()
					){
				adicionarVariavel("SMART TV", "45 POLEGADAS", stm);
				adicionarVariavel("RADIO", "RADIO DE BATERIA", stm);
				con.commit();
			} catch (Exception e) {
				//Caso tenha erro em algum registro retorna o erro e não executa nenhuma transação
				e.printStackTrace();
				System.out.println("ROLL BACK EXECUTADO");
				con.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm)
			throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		
		try(ResultSet rst = stm.getGeneratedKeys()){
			while(rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
	}
}
