package com.huashukang.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

import org.glassfish.jersey.server.ContainerRequest;
import org.springframework.stereotype.Component;

@Path("/demo")
@Component
public class Service { 	
	
	@Context
	Request request;
 
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayName() {	
		
		ContainerRequest cr=(ContainerRequest) request;		
		System.out.println(cr.getRequestUri().toString());
		System.out.println(request.getClass().getName());
		return "hello";	
	}
	
	@Path("test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "test";
	}

}
