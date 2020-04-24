package com.ITP.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ITP.model.Financial;
import com.ITP.service.FinancialServiceImpl;
import com.ITP.service.IFinancialService;

/**
 * Servlet implementation class LoginServlet
 */
public class GetFinancialServlet extends HttpServlet {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetFinancialServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

 		String MonthID = request.getParameter("MonthID");			
		IFinancialService iFinancialService = new FinancialServiceImpl();
		Financial financial = iFinancialService.getFinancialByID(MonthID);

		request.setAttribute("financial", financial);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetFinancial.jsp");
		dispatcher.forward(request, response);
	}

}
