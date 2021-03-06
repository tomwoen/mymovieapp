package com.qa.business.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;
import static javax.transaction.Transactional.TxType.REQUIRED;


@Default
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

	@Override
	public String getAMovie(Long id) {
		
		Movie aMovie = findMovie(id);
		
		if (aMovie != null) {
			
			return util.getJSONForObject(aMovie);
			
		}
		else {
			
			return "{\"message\":\"movie not found\"}";
		}
		
	}

	private Movie findMovie(Long id) {
		return manager.find(Movie.class, id);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAMovie(String jSON) {
		Movie newmovie = util.getObjectforJSON(jSON, Movie.class);
		manager.persist(newmovie);
		
		return "{\"message\":\"movie added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAMovie(Long id) {
		
		Movie amovie = findMovie(id);
		
		if (amovie != null) {
			
		manager.remove(amovie);
		
		return "{\"message\":\"movie deleted\"}";
		
		}
		
		else {
			
			return "{\"message\":\"movie not found\"}";
		}
	}

	@Override
	@Transactional(REQUIRED)
	public String updateMovie(Long id, String newJSON) {
		
		Movie oldmovie = findMovie(id);
		Movie newmovie = util.getObjectforJSON(newJSON, Movie.class);
		
		if (oldmovie != null) {
			
			oldmovie = newmovie;
			manager.merge(oldmovie);
			
		return "{\"message\":\"movie updated\"}";
		
		}
		
		else {
			
 		return "{\"message\":\"movie not found\"}";
 		
		}
	}
		

}
