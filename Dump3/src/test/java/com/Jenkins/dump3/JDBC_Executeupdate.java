package com.Jenkins.dump3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBC_Executeupdate {
	public static void main(String[] args) throws SQLException {

		// non select query

		// Step1: Register the driver

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		// step 2: Get connection for database

		Connection Connectivity = DriverManager.getConnection("jdbc:mysql://localhost:3306/EDBApplication", "root",
				"root");

		// step 3: Create Statement

		Statement state = Connectivity.createStatement();
//		String query = "create database EDBautomation;";
		String query1 = "use EDBautomation;";
//		String query2 = " create table staff(name varchar(10), staffid bigint(12));";
		String query11="insert into staff values('abhay',100);";
//		String query3 =" insert into staff values('Xavier', 122);";
//		String query4 =" insert into staff values('Peter', 123);"; 
//		String query5 =" insert into staff values('Hanna', 124);"; 
//		String query6 =" insert into staff values('James', 125);"; 
//		String query7 =" insert into staff values('Daniel', 126);"; 

//		state.executeUpdate(query);
		state.executeUpdate(query1);
//		state.executeUpdate(query2);
//		state.executeUpdate(query3);
//		state.executeUpdate(query4);
//		state.executeUpdate(query5);
//		state.executeUpdate(query6);
//		state.executeUpdate(query7);
		state.executeUpdate(query11);
//result.set
		Connectivity.close();

	}
}
