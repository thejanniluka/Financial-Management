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

public class AddFinancialServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFinancialServlet() {
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

		
			
		
		int phoneCost = Integer.parseInt(request.getParameter("PhoneCost"));
		int waterCost = Integer.parseInt(request.getParameter("WaterCost"));
		int transportCost = Integer.parseInt(request.getParameter("TransportCost"));
		int expensesCost = Integer.parseInt(request.getParameter("ExpensesCost"));
		int income = Integer.parseInt(request.getParameter("Income"));
		
		
		int netProfit = 0;
		
		netProfit = income - (phoneCost + waterCost + transportCost + expensesCost);
		
		
		Financial  financial = new Financial();
		
		financial.setPhoneCost(phoneCost);
		financial.setWaterCost(waterCost);
		financial.setTransportCost(transportCost);
		financial.setExpensesCost(expensesCost);
		financial.setIncome(income);
		financial.setNetProfit(netProfit);
		
				
		
		
		
		
		

		IFinancialService iFinancialService = new FinancialServiceImpl();
		iFinancialService.addFinancial(financial);

		request.setAttribute("financial", financial);
	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListFinancial.jsp");
		dispatcher.forward(request, response);
	}

}
