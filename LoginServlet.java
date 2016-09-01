package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
    Statement stmt;
    ResultSet rs;
    public void init(ServletConfig config) throws ServletException {
 	   
 	   try {
 		   Class.forName("com.mysql.jdbc.Driver");
 		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg?useSSL=false", "root", "manogna");
 		stmt=conn.createStatement();
 	} catch (Exception e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
 	   }
    /**
     * @see HttpServlet#HttpServlet()
     */
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String e=request.getParameter("emailid");
		String p=request.getParameter("password");
		try {
			rs=stmt.executeQuery("select password from register where emailid='"+e+"'");
			while(rs.next()){
				String password=rs.getString("password");
				if(p.equals(password))
				{
					pw.print("successfully logged in");
					
				}
				else{
					pw.print("soryyy!!!!! try again with valid credentials");
					
			}
			
				
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
