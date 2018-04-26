package com.qa.business.service;

public interface iMovieService {
	
	
	String getAllMovies();
	String getAMovie(Long id);
	String createAMovie(String jSON);
	String deleteAMovie(Long id);

}
