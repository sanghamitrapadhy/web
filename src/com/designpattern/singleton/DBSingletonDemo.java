package com.designpattern.singleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.designpattern.singleton.DBSingleton;

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
