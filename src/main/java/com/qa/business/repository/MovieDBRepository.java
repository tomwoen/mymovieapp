package com.qa.business.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.*;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;

public class MovieDBRepository implements iMovieRepository {

	private static final Logger LOGGER = Logger.getLogger(MovieDBRepository.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllMovies() {
		LOGGER.info("MovieDBRepository getAllMovies");
		
		Query query = manager.createQuery("Select m FROM Movie m");
		
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		
		return util.getJSONForObject(movies);
	}
	
	

}
