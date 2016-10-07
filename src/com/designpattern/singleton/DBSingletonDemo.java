package com.designpattern.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.designpattern.singleton.DBSingleton;

/*		Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class 
		exists in the java virtual machine. It seems to be a very simple design pattern but when it comes to implementation, 
		it comes with a lot of implementation concerns. The implementation of Singleton pattern has always been a controversial topic among developers. 
		Check out Singleton Design Pattern to learn about different ways to implement Singleton pattern and pros and cons of each of the method. 
		This is one of the most discussed java design patterns.*/
public class DBSingletonDemo {

	public static void main(String args[]) {
		long timeBefore;
		long timeAfter;

		DBSingleton instance = DBSingleton.getInstance();

		timeBefore = System.currentTimeMillis();
		Connection conn = instance.getConnection();
		timeAfter = System.currentTimeMillis();

		System.out.println(timeAfter - timeBefore);
		try {

			Statement statement = conn.createStatement();
			statement.executeUpdate("CREATE TABLE ADDRESS(ID integer, STREET varchar(50), CITY varchar(30))");
			System.out.println("Address Table created");
			statement.executeUpdate("DROP table ADDRESS");
			System.out.println("Address Table dropped ");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		timeBefore = System.currentTimeMillis();
		conn = instance.getConnection();
		timeAfter = System.currentTimeMillis();

		System.out.println(timeAfter - timeBefore);

	}

}
