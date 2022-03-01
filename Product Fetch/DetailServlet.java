package com.fetchproducts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("ID");
		int ID = Integer.parseInt(param);
		PrintWriter out = response.getWriter();
		Properties prop = new Properties();
		prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		Connection conn = DBConfig.getConnect(prop);

		if (conn != null) {
			try {
				PreparedStatement stmt = conn.prepareStatement("select * from eproduct where ID=?");
				stmt.setInt(1, ID);
				ResultSet rs = stmt.executeQuery();
				out.println("<h1>Welcome User,details of eproduct in console</h1>");
				while (rs.next()) {
					System.out.println("ID=" + rs.getInt(1));
					System.out.println("name=" + rs.getString(2));
					System.out.println("price=" + rs.getBigDecimal(3));
					System.out.println("date_added=" + rs.getDate(4));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.getWriter().print("Error while connecting with DB");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}