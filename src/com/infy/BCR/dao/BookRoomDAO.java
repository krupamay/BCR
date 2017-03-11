package com.infy.BCR.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infy.BCR.beans.Bookings;
import com.infy.BCR.beans.ConferenceRooms;

public class BookRoomDAO {
	
	public List<Bookings> getBookingDetails(){
		Connection con=null;
		PreparedStatement stmt=null;
		CreateDBConnection db=new CreateDBConnection();
		con=db.getDBConnection();
		
		List<Bookings> list=new ArrayList<Bookings>();
		String query="select * from BookingDetails";
		try {
			stmt=con.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				Bookings book=new Bookings();
				book.setBookingId(rs.getInt("booking_id"));
				book.setEmpId(rs.getInt("emp_id"));
				book.setTeamName(rs.getString("team_name"));
				
				list.add(book);
			}
			con.close();
			//return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int bookRooms(Bookings book){
		Connection con=null;
		PreparedStatement stmt=null;
		CreateDBConnection db=new CreateDBConnection();
		con=db.getDBConnection();
		int success=0;
		String query="insert into bookingdetails values(?,?,?,?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(query);
			stmt.setInt(1, book.getBookingId());
			stmt.setInt(2, book.getEmpId());
			stmt.setString(3, book.getTeamName());
			stmt.setString(4, book.getBookingDate());
			stmt.setString(5, book.getStartTime());
			stmt.setString(6, book.getEndTime());
			stmt.setString(7, book.getRoomNo());
			stmt.setString(8, book.getPurpose());
			
			success=stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public void validateTime(){
		
	}
	
	public String getRoomNames(String roomNo){
		Connection con=null;
		PreparedStatement stmt=null;
		CreateDBConnection db=new CreateDBConnection();
		con=db.getDBConnection();
		String roomName=null;
		String query="select * from ConferenceRooms where room_no=?";
		try {
			stmt=con.prepareStatement(query);
			stmt.setString(1, roomNo);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				roomName=rs.getString("Room_Name");
			}
			con.close();
			//return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomName;
	}

}
