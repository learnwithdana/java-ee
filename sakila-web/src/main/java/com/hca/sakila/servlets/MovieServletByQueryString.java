package com.hca.sakila.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieServletByQueryString
 */
@WebServlet(description = "Get movies by query string", urlPatterns = { "/movies/findall" })
public class MovieServletByQueryString extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServletByQueryString() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		// get query string parameters
		Map<String, String[]> queryStringMap = request.getParameterMap();
		
		if (!queryStringMap.containsKey("genre")) {
			writer.println("<h3>No genre provided!</h3>");
			return;
		}
		
		// gets the values for the key "genre" (ex:  /movies/findall?genre=comedy&genre=action )
		String[] allGenresPassedToThisServlet = queryStringMap.get("genre"); 
		
		for(String genre : allGenresPassedToThisServlet) {
			// generate a movie genre heading
			writer.println("<h3>" + genre + "</h3>");
			
			// find the movies in the specified genre
			String[] matchingMovies = getMovies(genre);
	
			// generate a list of all the movies in that genre
			writer.println("<ul>");
			for(String movie : matchingMovies) {
				writer.println("<li>" + movie + "</li>");
			}
			writer.println("</ul>");
		}
	}
	
	
	protected String[] getMovies(String genre) {
		// imaging this is getting the movies from a file or database or other REST API
		// (in other words, they wouldn't be hardcoded)
		HashMap<String, String[]> myMovies = new HashMap<String, String[]>();
		myMovies.put("comedy", new String[] {"Dumb and Dumber", "Ace Ventura", "Rocketman"} );
		myMovies.put("sci-fi", new String[] {"Alien", "Aliens"} );
		myMovies.put("action", new String[] {"Star Wars", "Star Trek", "007"} );
		
		return myMovies.get(genre);
	}

}
