package com.kiblerdude.example.web.service;

import java.util.Random;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/v1/entity")
public class ExampleResource {

	private final Random random;
	
	public ExampleResource() {
		this.random = new Random();
	}
	
	@POST
	public Response create() {
		try {
			String uuid = UUID.randomUUID().toString();
			// fake this request to take between 40 and 60 ms to complete
			Thread.sleep(40 + random.nextInt(20));
			return Response.ok(uuid).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}	
	
	@GET
	@Path("/{id}")
	public Response retrieve(@PathParam("id") String id) {
		// this request will return as fast as possible
		return Response.ok().build();
	}
	
	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") String id) {
		try {
			// fake this request to take between 200 and 250 ms to complete
			Thread.sleep(200 + random.nextInt(50));
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}		
	}
}
