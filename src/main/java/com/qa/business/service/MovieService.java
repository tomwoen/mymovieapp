package com.qa.business.service;

import javax.inject.Inject;

import com.qa.business.repository.iMovieRepository;

public class MovieService implements iMovieService {

	@Inject
	private iMovieRepository repo;
	
	@Override
	public String getAllMovies() {
		
		return repo.getAllMovies();
	}

	@Override
	public String getAMovie(Long id) {
		
		return repo.getAMovie(id);
		
	}
	
	@Override 
	public String createAMovie(String jSON) {
		
		return repo.createAMovie(jSON);
	}

	@Override
	public String deleteAMovie(Long id) {
		
		return repo.deleteAMovie(id);
	}

}
