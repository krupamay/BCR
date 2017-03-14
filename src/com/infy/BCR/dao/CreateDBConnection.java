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
	
	public static Connection DefaultJdbcTransaction() throws SQLException {
		Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC").newInstance();

            
             connection = DriverManager.getConnection("jdbc:sqlite:C:/SQLite/Conference_Room_Booking.db");
            
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            throw new SQLException(e);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            throw new SQLException(e);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            throw new SQLException(e);
        }
        return connection;
    }

}
