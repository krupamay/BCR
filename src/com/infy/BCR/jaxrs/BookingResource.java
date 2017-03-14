package com.infy.BCR.jaxrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.infy.BCR.beans.BookedBy;
import com.infy.BCR.beans.Bookings;
import com.infy.BCR.beans.ConferenceRooms;
import com.infy.BCR.beans.Details;
import com.infy.BCR.dao.BookRoomDAO;

@Path("book")
public class BookingResource {
	
	private BookRoomDAO daoObject = new BookRoomDAO();

	@Path("get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response testMethod(){
		return Response.ok("pradeep").build();
	}
	@Path("getBookingStatus")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRoomStatus() {
		
		List<ConferenceRooms> rooms = daoObject.getRoomDetails();
		Details details = null;
		List<Details> detailsList = new ArrayList<Details>();
		for (ConferenceRooms room : rooms) {
			details = new Details();
			details.setRoomName(room.getRoomName());
			details.setRoomNo(room.getRoomNo());
			List<Bookings> listOfBookings = daoObject.getBookingDetails(room.getRoomNo());
			System.out.println("List Of "+listOfBookings);
			if(listOfBookings.isEmpty()) {
				details.setBooked("Open");
				details.setBookedBy(Collections.emptyList());
			} else {
				details.setBooked("Booked");
				List<BookedBy> bookedBylist = new ArrayList<BookedBy>();
				for(Bookings booking : listOfBookings) {
					BookedBy bookedBy = new BookedBy();
					bookedBy.setTeam(booking.getTeamName());
					bookedBy.setTime(booking.getBookingTime());
					bookedBylist.add(bookedBy);
				}
				details.setBookedBy(bookedBylist);
			}
			detailsList.add(details);
		}
		return Response.ok(detailsList).build();
	}
	
	@Path("{roomNo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoomBookingDetails(@PathParam("roomNo") String roomNo) {
		
		List<Bookings> listOfBookings = daoObject.getBookingDetails(roomNo);
		
		return Response.ok(listOfBookings).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("bookroom")
	public void bookRooms(Bookings bookings){
		daoObject.insertBookingDetails(bookings);
	}
}
