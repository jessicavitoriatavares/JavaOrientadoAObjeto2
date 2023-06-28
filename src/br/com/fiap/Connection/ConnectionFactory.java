package br.com.fiap.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection conectar() {
		
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","tm_jessica_tavares","170504");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
		

}