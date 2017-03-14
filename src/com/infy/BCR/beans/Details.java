package com.infy.BCR.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Details {
	private String roomNo;
	private String booked;
	private String roomName;

	@XmlElement
	private List<BookedBy> bookedBy;

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
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
