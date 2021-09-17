package com.virtualpairprogrammers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class OrderServlet extends HttpServlet {
	
	MenuDataService mds = new MenuDataService();
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		List<MenuItem> fullMenu = mds.getFullMenu();
		
		out.println("<html><body>");
		out.println("<h1>Ricky's Restaurant</h1>");
		out.println("<h2>Order your food</h2>");
		out.println("<form action='orderReceived.html' method='POST' ><ul>");
		
		for (int i = 0; i < fullMenu.size(); i++) {
			MenuItem item = fullMenu.get(i);
			out.println("<li>" + item + "<input type='text' name='item_" + item.getId() + "' /></li>");
			
		}
		out.println("</ul><input type='submit' /></form></body></html>");
		out.close();
	}
}
