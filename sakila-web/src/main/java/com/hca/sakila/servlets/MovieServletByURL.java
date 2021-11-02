package com.hca.sakila.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// URL PATTERN  /sakila-web/moviesbygenre/{genre}
@WebServlet("/movies/bygenre/*")
public class MovieServletByURL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServletByURL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		
		response.setContentType("text/html");
		
		String uri = request.getRequestURI();
		System.out.println("********" + uri);  // example:  /sakila-web/movies/bygenre/comedy
		
		String[] parts = uri.split("/");
		if (parts.length >= 5) {
			String genre = parts[4];
			HashMap<String, String[]> myMovies = getMovies();
			
			writer.println("<h3>You are interested in " + genre + "movies.  Below are some good ones:</h3>");
			writer.println("<p>" + myMovies.get(genre).toString() + "</p>");
		}
		else {
			writer.println("<h3>You failed to specify a genre</h3>");
		}
		
	}
	
	protected HashMap<String, String[]> getMovies() {
		HashMap<String, String[]> myMovies = new HashMap<String, String[]>();
		myMovies.put("comedy", new String[] {"Dumb and Dumber", "Ace Ventura", "Rocketman"} );
		myMovies.put("sci-fi", new String[] {"Alien", "Aliens" } );
		myMovies.put("action", new String[] {"Star Wars", "Star Trek", "007"} );
		
		return myMovies;
	}

}
