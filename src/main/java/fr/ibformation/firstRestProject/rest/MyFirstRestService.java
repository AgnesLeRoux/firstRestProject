package fr.ibformation.firstRestProject.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/hello")
public class MyFirstRestService 
{
	
	@GET
	public Response sayHello2()
	{
		String output = "hello 2 !";
		return Response.status(200).entity(output).build();
	}
	
	@GET
	@Path("/monHello")
	public Response sayHello()
	{
		String output = "hello!";
		return Response.status(200).entity(output).build();
		
	}
	

}
