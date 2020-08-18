package com.georgefuior.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//setup connection variables
		String user = "springstudent";
		String password = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:8889/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//get the connection to DB
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connection to the database: "+jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
			
			out.println("Connection succesfull!");
			
			myConn.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
		
	}

}
