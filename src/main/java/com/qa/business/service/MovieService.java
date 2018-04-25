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

}
