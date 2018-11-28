package com.pf_programacionVII.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	// Librería de MySQL
	private String driver = "com.mysql.cj.jdbc.Driver";

	// Nombre de la base de datos
	private String database = "materias_u";

	// Host
	private String hostname = "localhost";

	// Puerto
	private String port = "3306";

	// Ruta de nuestra base de datos (desactivamos el uso de SSL con
	// "?useSSL=false")
	private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

	// Nombre de usuario
	private String username = "connect";

	// Clave de usuario
	private String password = "Javier*123";

	private Connection conn = null;

	public Connection conectarMySQL() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void cerrarMySQL() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}