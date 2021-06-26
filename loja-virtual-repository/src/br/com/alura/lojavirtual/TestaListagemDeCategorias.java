package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.lojavirtual.dao.CategoriaDAO;
import br.com.alura.lojavirtual.modelo.Categoria;
import br.com.alura.lojavirtual.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection con = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(con);
			List<Categoria> listaDeCategoria = categoriaDAO.listarComProdutos();
			listaDeCategoria.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for(Produto produto : ct.getProdutos()) {
						System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}		
	}

}
