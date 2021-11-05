package com.hca.sakila.models;

import java.util.HashMap;

public class MovieLibrary {

	public String[] getMovies(String genre) {
		// imaging this is getting the movies from a file or database or other REST API
		// (in other words, they wouldn't be hardcoded)
		HashMap<String, String[]> myMovies = new HashMap<String, String[]>();
		myMovies.put("comedy", new String[] {"Dumb and Dumber", "Ace Ventura", "Rocketman"} );
		myMovies.put("sci-fi", new String[] {"Alien", "Aliens"} );
		myMovies.put("action", new String[] {"Star Wars", "Star Trek", "007"} );
		
		return myMovies.get(genre);
	}
}
