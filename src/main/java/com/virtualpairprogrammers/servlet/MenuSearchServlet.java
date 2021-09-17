package com.virtualpairprogrammers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class MenuSearchServlet extends HttpServlet {
	
	MenuDataService mds = new MenuDataService();
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String searchTerm = request.getParameter("searchTerm");
		List<MenuItem> menuItems = mds.find(searchTerm);
		
		if (menuItems.size() > 0) {
			out.println("<html><body><h1<Ricky's Restaurant</h1>");
			out.println("<h2>Dishes containing " + searchTerm + "</h2><ul>");
			
			for (MenuItem menuItem: menuItems) {
				out.println("<li>" + menuItem + " " + menuItem.getDescription() + "</li>");
			}
			
			out.println("</ul></body></html>");			
		} else {
			out.println("<html><body><h1><h1<Ricky's Restaurant</h1>");
			out.println("<p>Sorry, no dishes containing " + searchTerm + "</p></body></html>");
		}
		out.close();
	}
	
}
