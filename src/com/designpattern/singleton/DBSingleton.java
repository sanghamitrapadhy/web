package com.designpattern.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {

	// private static DBSingleton instance= new DBSingleton();
	private static DBSingleton instance = null;
	private Connection conn = null;
	//derby
	private String JDBC_URL = "jdbc:derby:demo;create=true";
	//postgre
	private static final String HOST = "jdbc:postgresql://localhost:5432/";
	
	private static final String DB_NAME = "LOCAL";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "password";

	private DBSingleton() {
		/*
		 try{ 
		 	DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver()); 
		 } 
		 catch(SQLException e) {
		  e.printStackTrace();
		 }
		 */
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(HOST + DB_NAME, USERNAME, PASSWORD);
			System.out.println("DB connected");
		} catch (ClassNotFoundException | SQLException e) {
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
						//conn = DriverManager.getConnection(JDBC_URL);
						conn= DriverManager.getConnection(HOST + DB_NAME, USERNAME, PASSWORD);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}

}
