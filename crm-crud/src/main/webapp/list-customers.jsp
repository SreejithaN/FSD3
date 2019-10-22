<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>CRM/Customer Management Systems</h2>

		<%
      if (session != null) {
    	  out.println(session.getId());
         if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
            out.print("Hello, " + name + "  Welcome to ur Profile");
         } else {
            response.sendRedirect("index.jsp");
         }
      }
   %>
		<div id="content">

			<!-- put new button: Add Customer -->

			<a href="add-customer.jsp" class="btn btn-info" role="button">Add customer</a>  <br/><br/>  
			
			<!-- Search form --><form action="search.do">
		<div class="md-form mt-0">
  		<input type="text" placeholder="Search" name="search"/>&nbsp;&nbsp;&nbsp;<input class="btn btn-info" type="submit" value ="submit"></form>
		</div><br/></div>
	
		
		<div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Sorting by FirstName
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="order.do" name="firstName">Ascending Order</a>
      <a class="dropdown-item" href="order_desc.do" name="firstName">Descending Order</a>
    </div>
  </div><br/><br/>
		
		
		
		<table class="table table-striped">
			<thead >
				<tr>
					<th>#</th>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach var="tempCustomer" items="${customers}">
						<c:url var="updateLink" value="update.do">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
			
					<c:url var="deleteLink" value="delete.do">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					<tr>
						<td>${tempCustomer.id}</td>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
												<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							<a href="${updateLink}">Update</a>
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="Logout" method="post">
      <input class="btn btn-info" type="submit" value="Logout">
   </form>
	</div>
	
</body>
</html>