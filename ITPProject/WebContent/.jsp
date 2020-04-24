<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Financial.css" />

<meta charset="UTF-8">
<title>SLIIT OOP Employee Management</title>
</head>
<body class="body">

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<h2 class="h2">Add Employee Page</h2>

	   SLIIT Employee Management App for Object Orineted Progrmming
	<br>
	<br>

	<form method="POST" action="AddFinancialServlet">
	<table>

			<tr>
				<td>Enter Phone Bills cost</td>
				<td><input type="text" name="PhoneCost" /></td>
			</tr>
			<tr>
				<td>Enter Income </td>
				<td><input type="text" name="Income" /></td>
			</tr>
			<tr>
				<td>Enter Water Bills cost</td>
				<td><input type="text" name="WaterCost" /></td>
			</tr>
			<tr>
				<td>Enter Transport Bills cost</td>
				<td><input type="text" name="TransportCost" /></td>
			</tr>
			<tr>
				<td>Enter Expenses Bills cost</td>
				<td><input type="text" name="ExpensesCost" /></td>
			</tr>
		
			<tr>
				<td colspan="2"><input type="submit" value="Add Employee" class="add-button" /> </td>
			</tr>
			<tr>	
				<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
			</tr>
		</table>
	</form>

	<form method="POST" action="ListFinancialServlet">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List All Employees" class="list-button" />
				</td>
			</tr>
		</table>
	</form>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>