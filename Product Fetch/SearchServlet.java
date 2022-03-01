package com.fetchproducts;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
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
				DataInputStream data = new DataInputStream(System.in);

				// input a particular employee id of which we want to display record
				System.out.print("Enter Product name:");
				String name = data.readLine();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from eproduct where name='" + name + "' ");
				while (rs.next()) {
					System.out.println("ID=" + rs.getInt(1));
					System.out.println("name=" + rs.getString(2));
					System.out.println("price=" + rs.getBigDecimal(3));
					System.out.println("date_added=" + rs.getDate(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			out.print("connection field");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}