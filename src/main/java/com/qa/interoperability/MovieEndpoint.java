package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.iMovieService;

@Path("/movie")
public class MovieEndpoint {
	
	@Inject
	private iMovieService service;
	
	@GET
	@Path("/json")
	@Produces({"application/json"})
	public String getAllMovies() {
		
		return service.getAllMovies();
	}

}
