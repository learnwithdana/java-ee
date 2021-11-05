package com.hca.sakila.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hca.sakila.models.Snack;
import com.hca.sakila.models.SnackCounter;

/**
 * Servlet implementation class SnacksServletByURL
 */
@WebServlet(description = "Returns snacks based on URL", urlPatterns = { "/snacks/type/*" })
public class SnacksServletByURL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SnacksServletByURL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		
		// set content type so the browser knows its HTML
		response.setContentType("text/html");
		
		// Get the URI and find the snack type portion of the URI
		String uri = request.getRequestURI();
		String[] parts = uri.split("/");
		
		if(parts.length >= 5) {
			// use the snack type to get the matching snacks we carry
			String snackType = parts[4].toLowerCase();
			
			// Get the snacks by the snackType
//			String[] matchingSnacks = getSnacks(snackType);
			
			SnackCounter snackCounter = new SnackCounter();
			Snack[] matchingSnacks = snackCounter.getSnacksByCategory(snackType);
						
// IN THIS VERSION, THE SERVLET DOES NOT GENERATE HTML -- IT ASKS A JSP TO DO THAT
			
			// add the data the JSP needs to the request scope
			request.setAttribute("snack-type", snackType);
			request.setAttribute("matching-snacks", matchingSnacks);
		}
		else {
			// since no snack type was specified, tell the JSP we have an issue
			request.setAttribute("snack-type", "missing");
		}
			
		// select the JSP that will render the HTML and forward the request/response to it
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/snacks.jsp");
		dispatcher.forward(request, response);
		
			
// IN THIS VERSION, THE SERVLET GENERATED HTML WITH A <TABLE>
//			// generate the HTML displayed 
//			writer.println("<h3>Your matching snacks are: </h3>");
//			
//			writer.println("<table>");
//			writer.println("<thead>");
//			writer.println("<tr>");
//			writer.println("<td>Product Name</td>");
//			writer.println("<td>Price</td>");
//			writer.println("</tr>");
//			writer.println("</thead>");
//			
//			writer.println("<tbody>");			
//			for(Snack snack : matchingSnacks) {
//				writer.println("<tr>");			
//				writer.println("<td>" + snack.getProductName() + "</td>");
//				writer.println("<td>" + String.format("$ %.2f", snack.getPrice()) + "</td>");
//				writer.println("</tr>");			
//			}
//			writer.println("</tbody>");		
//			
//			writer.println("</table>");
			
//  IN THIS VERSION, THE SERVLET GENERATED HTML WITH A <UL>
//			writer.println("<ul>");
//			for(Snack snack : matchingSnacks) {
//				writer.println("<li>" +  snack.getProductName() + " ($" + snack.getPrice() + ")</li>");		
//				writer.println("<li>" +  snack.getProductName()
//						       + String.format(" ($%.2f)", snack.getPrice()) 
//						       + "</li>");	
//				writer.printf("<li>%s ($%.2f)</li>",  snack.getProductName(), snack.getPrice());
//			}
//			writer.println("</ul>");
//		}
	}

//	protected String[] getSnacks(String snackType) {
//		// imaging this is getting the snack from a file or database or other REST API
//		// (in other words, they wouldn't be hardcoded)
//		HashMap<String, String[]> mySnacks = new HashMap<String, String[]>();
//		mySnacks.put("drinks", new String[] {"Coke", "Coke Icee", "Sweet Tea", "Bottled Water"} );
//		mySnacks.put("salty", new String[] {"Popcorn", "Buttered Popcorn", "Pickle", "Nachos"} );
//		mySnacks.put("sweet", new String[] {"M&Ms", "Peanut M&Ms", "Reeses Peanut Butter Cups", "Sour Gummy Worms"} );
//		
//		return mySnacks.get(snackType);
//	}
}
