package com.qa.business.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qa.persistence.domain.*;
import com.qa.util.JSONUtil;

@Alternative
public class MovieMapRepository implements iMovieRepository  {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	private Map <Long, Movie> movieMap;
		
	public MovieMapRepository() {
		
		this.movieMap = new HashMap <Long, Movie>();
				
	}
	
	@Inject
	JSONUtil JUtil;


	@Override
	public String getAllMovies() {
		
		return JUtil.getJSONForObject(movieMap);
	}


	@Override
	public String getAMovie(Long ID) {
		
			
		return JUtil.getJSONForObject(movieMap.get(ID));
	}

	private Movie findMovie(Long id) {
		return manager.find(Movie.class, id);
	}

	@Override
	public String createAMovie(String jSON) {
		
		Movie newmovie = JUtil.getObjectforJSON(jSON, Movie.class);
		movieMap.put(1L, newmovie);

		return "{\"message\":\"movie added\"}";
	}


	@Override
	public String deleteAMovie(Long ID) {
		
		Movie deletemovie = movieMap.get(ID);
		
		if (deletemovie != null) {
		movieMap.remove(ID);
		
		return "{\"message\":\"movie deleted\"}";
		
		}
		
		else {
		
		return "{\"message\":\"movie not found\"}";
			
		}
	}


	@Override
	public String updateMovie(Long ID, String newJSON) {
		
		Movie newmovie = JUtil.getObjectforJSON(newJSON, Movie.class);
		
		Movie updatemovie = movieMap.get(ID);
		
		if (updatemovie != null) {
			
		movieMap.put(ID, newmovie);
		
		return "{\"message\":\"movie updated\"}";
		
		}
		
		else {
		
		return "{\"message\":\"movie not found\"}";
			
		}	
	}

}
