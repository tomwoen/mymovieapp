package com.qa.business.repository;

public interface iMovieRepository {
	
	String getAllMovies();
	
	String getAMovie(Long id);
	
	String createAMovie(String jSON);
	

}
