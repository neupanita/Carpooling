package com.carpooling.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

	public static Connection getConnection() throws Exception {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/carpoolingdb?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull", "root", "root");
		} catch (Exception e) {
			System.out.println("MySQL JDBC driver not found in DBConnection\n" + e);
			System.exit(0);
		}
		return con;
	}
}