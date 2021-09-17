package com.virtualpairprogrammers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body><h1>hello world</h1>");
		out.println("<p>The tiem is : " + new Date() + "</p>");
		out.println("</body></html>");
		out.close();
	}
	
}
