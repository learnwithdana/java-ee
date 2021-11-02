package com.hca.sakila.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(description = "A hello world servlet", urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
//		writer.append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
//		writer.println("<img src='images/hot-air-balloons.jpeg' alt='logo'>"); 
//		writer.println("<h1>First Servlet</h1>"); 
//		writer.println("<h3>Hello world</h3>"); 
//		writer.println("<0>asd.masdlk adslk gkods aolds fkl alkjfdg da fgiok  adf zdlofkgdbj</0>"); 
		
		StringBuilder html = new StringBuilder();
		html.append("<!DOCTYPE html>");
		html.append("<html>");
		html.append("<head>");
		html.append("<title>Home</title>");
		html.append("</head>");
		html.append("<body>");
		html.append("<img src='images/hot-air-balloons.jpeg' alt='logo'>");
		html.append("<h1>Welcome</h1>");
		html.append("<h3>My Servlet</h3>");
		html.append("<p>skljd kl  sdklsd sjhf slvfjf skjd</p>");
		html.append("</body>");
		html.append("</html>");
		
		writer.println(html.toString());
		
	}

}
