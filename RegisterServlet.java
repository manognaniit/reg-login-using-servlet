package com.niit.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection conn;
     Statement stmt;
@Override
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	      PrintWriter pw=response.getWriter();
	      String fn=request.getParameter("firstname");
	      String ln=request.getParameter("lastname");
	      String id=request.getParameter("emailid");
	      String p=request.getParameter("password");
	      
		try {
			int i=stmt.executeUpdate("insert into register values('"+fn+"','"+ln+"','"+id+"','"+p+"')");
			if (i!=0){
				pw.print("sucessfully registered");
				
			}
			else{
				pw.print("not successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
