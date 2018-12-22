package com.pf_programacionVII.connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	Properties prop =new Properties();
	private String driver ;
	private String url ;
	private String username ;
	private String password ;
	private static Connection conn = null;
	private InputStream inputStream;

	
	public Connection conectarMySQL()  {
		try {

		    inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
		    if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + prop + "' not found in the classpath");
			}
			
			driver=prop.getProperty("jdbc.driver");
			url=prop.getProperty("jdbc.url");
			username=prop.getProperty("jdbc.user");
			password=prop.getProperty("jdbc.password");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException | IOException e) {
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