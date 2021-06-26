package br.com.alura.lojavirtual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPoolDataSource = new ComboPooledDataSource();
		comboPoolDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPoolDataSource.setUser("root");
		comboPoolDataSource.setPassword("Silva056@");
		
		comboPoolDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPoolDataSource;
	}

	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();		
	}
	
//	Abaixo é o modo de abrir a conexão sem o Pool de Conexão 
	
//	public Connection recuperarConexao() throws SQLException {
//		return DriverManager
//				.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "Silva056@");
//		
//	}

}
