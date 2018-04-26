package com.qa.business.repository;

public interface iMovieRepository {
	
	String getAllMovies();
	
	String getAMovie(Long id);
	
	String createAMovie(String jSON);
	
	String deleteAMovie(Long id);
	
	String updateMovie (Long id, String newJSON);

}
