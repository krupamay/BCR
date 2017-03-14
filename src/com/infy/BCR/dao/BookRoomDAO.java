package com.infy.BCR.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.infy.BCR.beans.Bookings;
import com.infy.BCR.beans.ConferenceRooms;

public class BookRoomDAO {
	
	private static Integer bookId=20;
	
	public List<Bookings> getBookingDetails(String roomNo){
		Connection con=null;
		PreparedStatement stmt=null;
		CreateDBConnection db=new CreateDBConnection();
		//con=db.getDBConnection();
		
		LocalDate date=LocalDate.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String today=date.format(formatter);
		//System.out.println("Room No : " + roomNo);
		List<Bookings> list=new ArrayList<Bookings>();
		String query="select * from BookingDetails where room_no=? and booking_date=?";
		try {
			con = CreateDBConnection.DefaultJdbcTransaction();
			stmt=con.prepareStatement(query);
			stmt.setString(1, roomNo);
			stmt.setString(2, today);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()){
				//System.out.println("hii");
				Bookings book=new Bookings();
				book.setBookingId(rs.getInt("booking_id"));
				book.setRoomNo(roomNo);
				book.setTeamName(rs.getString("team_name"));
				book.setStartTime(rs.getString("start_time"));
				book.setEndTime(rs.getString("end_time"));
				book.setBookingTime(rs.getString("start_time")+" - "+rs.getString("end_time"));
				book.setBookingDate(rs.getString("booking_date"));
				book.setEmpId(rs.getInt("emp_id"));
				book.setPurpose(rs.getString("purpose"));
				list.add(book);
			}
			if(list.size()==0){
				Bookings book=new Bookings();
				book.setRoomNo(roomNo);
				list.add(book);
			}
			
			con.close();
			//return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insertBookingDetails(Bookings book){
		Connection con=null;
		PreparedStatement stmt=null;
		CreateDBConnection db=new CreateDBConnection();
		//con=db.getDBConnection();
		
		int success=0;
		String query="insert into bookingdetails values(?,?,?,?,?,?,?,?)";
		try {
			con = CreateDBConnection.DefaultJdbcTransaction();
			stmt=con.prepareStatement(query);
			stmt.setInt(1, BookRoomDAO.bookId++);
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
	
	public List<ConferenceRooms> getRoomDetails(){
		Connection con=null;
		PreparedStatement stmt=null;
		CreateDBConnection db=new CreateDBConnection();
		//con=db.getDBConnection();
		
		List<ConferenceRooms> roomDetails=new ArrayList<ConferenceRooms>();
		String query="select * from ConferenceRooms";
		try {
			con = CreateDBConnection.DefaultJdbcTransaction();
			System.out.println("Connection "+con);
			stmt=con.prepareStatement(query);
			
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				ConferenceRooms room=new ConferenceRooms();
				room.setRoomNo(rs.getString(1));
				room.setRoomName(rs.getString(2));
				
				roomDetails.add(room);
			}
			con.close();
			//return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomDetails;
	}

}
