package com.infy.BCR.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Details {
	private String room;
	private String booked;
	
	@XmlElement
	private List<BookedBy> bookedBy;
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getBooked() {
		return booked;
	}
	public void setBooked(String booked) {
		this.booked = booked;
	}
	public List<BookedBy> getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(List<BookedBy> bookedBy) {
		this.bookedBy = bookedBy;
	}
	
	
}
