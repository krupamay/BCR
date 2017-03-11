package com.infy.BCR.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("book")
public class BookingResource {

	@Path("get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response testMethod(){
		return Response.ok("pradeep").build();
	}
}
