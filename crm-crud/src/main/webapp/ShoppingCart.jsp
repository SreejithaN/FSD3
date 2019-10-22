<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Shopping Cart</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
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
	<p>
		<strong>Shopping Cart</strong>
	</p>
	<p>
		<a href="ModelList.jsp" class="btn btn-info" role="button">Model List</a>
	</p>
	<table width="75%" border="1" class="table table-striped">
		<tr>
			<td><strong>Model Description</strong></td>
			<td><strong>Quantity</strong></td>
			<td><strong>Unit Price</strong></td>
			<td><strong>Total</strong></td>
		</tr>
		<jsp:useBean id="cart" scope="session" class="comm.example.bean.CartBean" />
		<c:if test="${cart.lineItemCount==0}">
			<tr>
				<td colspan="4">- Cart is currently empty -<br />
			</tr>
		</c:if>
		<c:forEach var="cartItem" items="${cart.cartItems}"
			varStatus="counter">
			<form name="item" method="POST" action="CartController">
				<tr>
					<td><b><c:out value="${cartItem.partNumber}" /></b><br /> <c:out
							value="${cartItem.modelDescription}" /></td>
					<td><input type='hidden' name='itemIndex'
						value='<c:out value="${counter.count}"/>'> <input
						type='text' name="quantity"
						value='<c:out value="${cartItem.quantity}"/>'> <input class="btn btn-info" role="button"
						type="submit" name="action" value="Update">&nbsp;<input class="btn btn-info" role="button"
						type="submit" name="action" value="Delete"></td>
					<td>$<c:out value="${cartItem.unitCost}" /></td>
					<td>$<c:out value="${cartItem.totalCost}" /></td>
				</tr>
			</form>
		</c:forEach>

		<tr>
			<td colspan="2"></td>
			<td></td>
			<td>Subtotal: $<c:out value="${cart.orderTotal}" />
			</td>
		</tr>
	</table></div>
</body>
</html>