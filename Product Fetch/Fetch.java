package com.fetchproducts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Servlet implementation class Fetch
 */
@WebServlet("/fetch")
public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Properties prop = new Properties();
		prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		Connection conn = DBConfig.getConnect(prop);

		if (conn != null) {
			try {

				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from eproduct ");
				out.print("<h1>Product Details</h1><hr>");
				while (rs.next()) {
					out.print(rs.getString("name") + "<br><br>" + " " + "<a href='detail?ID=" + rs.getInt(1)
							+ "'>detail</a><br>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			out.print("Error while connecting with database");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
