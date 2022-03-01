package com.addproduct;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.addproduct.EProduct;
import com.addproduct.HibernateUtil;

/**
 * Servlet implementation class Readdata
 */
@WebServlet("/read")
public class ReadData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();

		SessionFactory sf = HibernateUtil.beginSessionFactory();

		Session session = sf.openSession();

		List<EProduct> products = session.createQuery(" from EProduct").list();

		out.print("<h1> Product List :- </h1>");
		out.print("<style> table,td,th { border:2px solid black; padding: 10px; }</style>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th>pId </th>");
		out.print("<th> pname </th>");
		out.print("<th> price </th>");
		out.print("</tr>");

		for (EProduct p : products) {

			out.print("<tr>");
			out.print("<td>" + p.getId() + "</td>");
			out.print("<td>" + p.getName() + "</td>");
			out.print("<td>" + p.getPrice() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");

		session.close();
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