<%@page import="com.ITP.model.Financial"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ITP.service.FinancialServiceImpl"%>
<%@page import="com.ITP.service.IFinancialService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "List.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SLIIT ITP Management</title>
</head>
<body>
	  <div align="left">
		<table border="1" cellpadding="12" class="content-table">
		 
		 <a href="homeView.jsp"><input type="submit" class="btn" value="ADD INCOME"></a>
		  <tr>
                <th>Month ID</th>
                <th>Phone Cost</th>
                <th>Income </th>
                <th>Water Cost</th>
                <th>Transport Cost</th>
                <th>Expenses Cost</th>
                <th>Netprofit</th>
            </tr>
            <%
            	IFinancialService iFinancialService= new FinancialServiceImpl();
                                                                        	ArrayList<Financial> arrayList = iFinancialService.getFinancials();
                                                                        	
                                                                        	for(Financial financial : arrayList){
            %>
			 <tr>
				<td> <%=financial.getMonthID() %> </td>
				<td> <%=financial.getPhoneCost() %> </td>
				<td> <%=financial.getIncome() %> </td>
				<td> <%=financial.getWaterCost() %> </td>
				<td> <%=financial.getTransportCost() %> </td>
				<td> <%=financial.getExpensesCost() %> </td>
				<td> <%=financial.getNetProfit() %> </td>	
				<td> 
				<form method="POST" action="GetFinancialServlet">
				<input type="hidden" name="MonthID" value="<%=financial.getMonthID()%>"/>
				  <input type="submit" class="btn" value="UPDATE INCOME">
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div>
		
</body>
</html>