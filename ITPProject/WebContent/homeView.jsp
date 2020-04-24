<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <title>Financial Management</title>
	<link rel="stylesheet" type="text/css" href="Financial.css">
     <meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<img class="wave" src="wave.png">
	<div class="container">
		<div class="img">
			<img src="wallet.svg">
		</div>        
		<div class="login-content">
			 <form method="POST" action="AddFinancialServlet">
				<h2 class="title">Financial Management</h2>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-calculator"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Enter Phone Bills cost</h5>
           		   		<input type="text"  class="input" name="PhoneCost" required>
           		   </div>
           		</div>
                
                	<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-calculator"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Enter Income</h5>
           		   		<input type="text" name="Income" class="input" required>
           		   </div>
           		</div>
                
                	<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-calculator"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Enter Water Bills cost</h5>
           		   		<input type="text" name="WaterCost" class="input" required>
           		   </div>
                </div>
                
                	<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-calculator"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Enter Transport Bills cost</h5>
           		   		<input type="text" name="TransportCost" class="input" required>
           		   </div>
           		</div>
                
                <div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-calculator"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Enter Expenses Bills cost</h5>
           		   		<input type="text" name="ExpensesCost" class="input" required>
           		   </div>
           		</div>
               
            	<input type="submit" class="btn" value="CALCULATE">
                <input type="reset" class="btn" value="RESET">
                
             
            </form>
            <form method="POST" action="ListFinancialServlet">   
                
                <input type="submit" class="btn1" value="LIST INCOME">
                 </form>
        </div>
    </div>
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
    });</script>
     <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>
</html>
