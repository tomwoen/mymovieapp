package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String getAMovie(@PathParam("id") Long id) {
		
		return service.getAMovie(id);
	}
	
	@POST
	@Path("/json")
	@Produces( {"application/json"})
	public String createAMovie (String jSON) {
		
		return service.createAMovie(jSON);
	}
	
	@POST
	@Path("/json/{id}")
	@Produces( {"application/json"})
	public String deleteAMovie (@PathParam("id") Long id) {
		
		return service.deleteAMovie(id);
	}

}
