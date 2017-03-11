package com.infy.BCR.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDBConnection {
	
	public Connection getDBConnection(){
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:sqlite:C:/SQLite/Conference_Room_Booking.db");
			System.out.println("Opened database successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}

}
