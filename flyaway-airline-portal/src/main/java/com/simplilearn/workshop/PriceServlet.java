 package com.simplilearn.workshop;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.workshop.util.DatabaseConnection;


public class PriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SELECT_QUERY = "SELECT * FROM booking_details WHERE source = 'Los Angeles' && destination = 'Tokyo'";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();

			out.println("<html> <body>");
			out.println("<h1> Welcome to Flyaway Portal</h1>");
			out.println("<hr size=\"5\" color=\"blue\"/>");

			InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/jdbc.properties");

			Properties properties = new Properties();
			properties.load(inputStream);
			DatabaseConnection connection = new DatabaseConnection(properties.getProperty("url"),
					properties.getProperty("user"), properties.getProperty("password"));

			
			Statement statement = connection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		 
			
			ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
			out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Flying From</th><th>Flying To</th><th>Airline</th><th>Price</th></tr>"); 
			while (resultSet.next()) {
			String a = resultSet.getString("source");
			String b = resultSet.getString("destination");
			String c = resultSet.getString("airline");
			BigDecimal d = resultSet.getBigDecimal("price");
			out.println("<tr><td>" + a + "</td><td>" + b + "</td><td>" + c + "</td><td>" + d + "</td></tr>");
			}
			resultSet.close();
			statement.close();
			out.println("</html> </body>");
			out.println("If you like to book the ticket please click the checkout link.");
	        out.println("<a href=\"/flyaway-airline-portal/payments.html\">Checkout</a>");
			connection.closeConnection();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
