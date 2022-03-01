package com.addproduct;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.addproduct.EProduct;
import com.addproduct.HibernateUtil;

/**
 * Servlet implementation class Adddata
 */
@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SaveServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.html").include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String productName = request.getParameter("pname");
		String productPrice = request.getParameter("price");

		SessionFactory sf = HibernateUtil.beginSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		EProduct product = new EProduct();
		product.setName(productName);
		product.setPrice(Double.parseDouble(productPrice));
		session.save(product);

		tx.commit();

		out.print("<h3> Product is Inserted successfully ! <h3>");
		session.close();
	}
}