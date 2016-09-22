package com.designpattern.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {

	// private static DBSingleton instance= new DBSingleton();
	private static DBSingleton instance = null;
	private Connection conn = null;
	private String JDBC_URL="jdbc:derby:demo;create=true";
	

	private DBSingleton() {
			try{
				DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			}
			catch(SQLException e){
				e.printStackTrace();
			}
	} 

	public static DBSingleton getInstance() {
		// lazy loading
		if (instance == null) {
			synchronized (DBSingleton.class) {
				if (instance == null) {
					instance = new DBSingleton();
				}
			}
		}
		return instance;
	}
	
	public Connection getConnection() {
		if (conn == null) {
			synchronized (DBSingleton.class) {
				if (conn == null) {
					try {
						conn = DriverManager.getConnection(JDBC_URL);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}

}
