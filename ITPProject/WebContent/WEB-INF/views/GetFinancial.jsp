<%@page import="com.ITP.model.Financial"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Financial Management</title>
    <link rel="stylesheet" type="text/css" href="update.css">
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
    <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
    <%
		Financial financial = (Financial) request.getAttribute("financial");
	%>
    <div class="container">
        <div class="img">

        </div>
        <div class="login-content">
            <form method="POST" action="UpdateFinancialServlet">
            <h2 class="title">Financial Management</h2>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-calculator"></i>
                    </div>
                    <div class="div">
                        <td>
                            <h4>Month ID</h4>
                        </td>
                        <input type="text" disabled="disabled" 	name = "MonthID" class="input" value="<%=financial.getIncome()%>" />
                    </div>
                </div>
                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-calculator"></i>
                    </div>
                    <div class="div">
                        <td>
                            <h5>Phone Bills</h5>
                        </td>
                        <input type="text" name = "phoneCost" class="input" value="<%=financial.getPhoneCost()%>" />
                    </div>
                </div>

                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-calculator"></i>
                    </div>
                    <div class="div">
                        <td>
                            <h5>Income</h5>
                        </td>
                        <input type="text" class="input" name = "income" value="<%=financial.getIncome()%>" />
                    </div>
                </div>

                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-calculator"></i>
                    </div>
                    <div class="div">
                        <td>
                            <h5>Water Bills</h5>
                        </td>
                        <input type="text" class="input" name = "waterCost" value="<%=financial.getWaterCost()%>" />
                    </div>
                </div>

                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-calculator"></i>
                    </div>
                    <div class="div">
                        <td>
                            <h5>Transport Bills</h5>
                        </td>
                        <input type="text" class="input" name = "transportCost" value="<%=financial.getTransportCost()%>" />
                    </div>
                </div>

                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-calculator"></i>
                    </div>
                    <div class="div">
                        <td>
                            <h5>Expenses Bills</h5>
                        </td>
                        <input type="text" class="input" name = "expensesCost" value="<%=financial.getExpensesCost()%>" />
                    </div>
                </div>

                <div class="input-div one">
                    <div class="i">
                        <i class="fas fa-calculator"></i>
                    </div>
                    <div class="div">
                        <td>
                            <h4>Netprofit</h4>
                        </td>
                        <input type="text" disabled="disabled"  class="input" value="<%=financial.getNetProfit()%>" />
                    </div>
                </div>
                
<input type="hidden" name="MonthID" value="<%=financial.getMonthID()%>" /> 
                <input type="submit" class="btn1" value="UPDATE COST">
                </form>
                
					<form method="POST" action="DeleteFinancialServlet">

                    <input type="hidden" name="MonthID" value="<%=financial.getMonthID()%>" />
                    <input type="submit" class="btn" value="DELETE INCOME">
                        
                </form>
        </div>
    </div>
    </%>
    <script>const inputs = document.querySelectorAll(".input");


function addcl(){
	let parent = this.parentNode.parentNode;
	parent.classList.add("focus");
}

function remcl(){
	let parent = this.parentNode.parentNode;
	if(this.value == ""){
		parent.classList.remove("focus");
	}
}


inputs.forEach(input => {
	input.addEventListener("focus", addcl);
	input.addEventListener("blur", remcl);
});
</script>
    <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

</html>
