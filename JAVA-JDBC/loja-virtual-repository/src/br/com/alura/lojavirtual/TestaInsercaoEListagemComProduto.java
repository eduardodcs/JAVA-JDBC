package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.alura.lojavirtual.dao.ProdutoDAO;
import br.com.alura.lojavirtual.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("CÔMODA", "CÔMODA VERTICAL");
		
		try(Connection con = new ConnectionFactory().recuperarConexao()){
			ProdutoDAO produtoDao = new ProdutoDAO(con);
			produtoDao.salvarProduto(comoda);
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
		}
	}
}
