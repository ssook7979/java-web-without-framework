package com.virtualpairprogrammers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class MenuServlet extends HttpServlet  {
	
	MenuDataService mds = new MenuDataService();
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body><h1>Menu</h1>");
		out.println("<ul>");
		
		for (MenuItem menuItem: mds.getFullMenu()) {
			out.println("<li>" + menuItem + "</li>");
		}
		
		out.println("</ul></body></html>");
		out.close();
	}
	
}
