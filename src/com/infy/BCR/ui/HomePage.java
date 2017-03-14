package com.infy.BCR.ui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.infy.BCR.beans.Bookings;
import com.infy.BCR.beans.ConferenceRooms;
import com.infy.BCR.dao.BookRoomDAO;

public class HomePage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("pradeep");
		List<Bookings> bookingList=null;
		BookRoomDAO dao=new BookRoomDAO();
		bookingList=dao.getBookingDetails("1");
		
		for(Bookings b:bookingList){
			System.out.println(b.getTeamName());
			System.out.println(b.getBookingTime());
			//System.out.println(b.getEndTime());
		}
		System.out.println("Booking room.... ");
		
		LocalTime from=LocalTime.parse("11:30");
		LocalTime to=LocalTime.parse("11:30");
		//String s=time1.toString();
		//LocalDate date=LocalDate.parse("2007-12-03");
		//LocalDate date2=LocalDate.now().plusDays(2);
		//System.out.println(date2);
		//System.out.println(time1.minusMinutes(1));
		Bookings book=new Bookings();
		book.setBookingId(2);
		book.setEmpId(725040);
		book.setTeamName("IM");
		book.setBookingDate("11-03-2017");
		book.setStartTime(from.toString());
		book.setEndTime(to.toString());
		book.setRoomNo("Mars");
		book.setPurpose("Refinement");
		BookRoomDAO dao1=new BookRoomDAO();
		List<ConferenceRooms> rooms=null;
		rooms=dao1.getRoomDetails();
		for(ConferenceRooms cr:rooms){
			System.out.println(cr.getRoomName());
		}

	}

}
