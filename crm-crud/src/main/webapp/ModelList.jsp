<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Model List</title>
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

<body><div class="container">
	<p>
		<font size="3" face="Verdana, Arial, Helvetica, sans-serif"><strong>Model
				List </strong></font>
	</p>
	<a href="ShoppingCart.jsp" class="btn btn-info" role="button">View Cart</a>
	<p /><br/>
	<table width="75%" border="1" class="table table-striped">
		<tr>
			<td><form method="POST" action="CartController">
					<strong>Model:</strong> TF-Model1<input type="hidden"
						name="modelNo" value="TF-MODEL1"> <strong>Description:</strong>
					Model 1 <input type="hidden" name="description" value="Model 1">
					<strong>Quantity:<input type="text" size="2" value="1"
						name="quantity"></strong> <strong>Price:</strong> $10.00 <input
						type="hidden" name="price" value="10"> <input
						type="hidden" name="action" value="add"> <input class="btn btn-info" role="button"
						type="submit" name="addToCart" value="Add To Cart">
				</form></td></tr><tr>
			<td>
				<form  method="POST" action="CartController">
					<strong>Model:</strong> TF-Model2 <input type="hidden"
						name="modelNo" value="TF-MODEL2"> <strong>Description:</strong>Model2
					<input type="hidden" name="description" value="Model 2">

					<strong>Quantity</strong><input type="text" size="2" value="1"
						name="quantity"> <strong>Price</strong>$20.00 <input
						type="hidden" name="price" value="20"> <input
						type="hidden" name="action" value="add"> <input class="btn btn-info" role="button"
						type="submit" name="addToCart" value="Add To Cart">
				</form>
			</td>
		</tr>
		<tr>
			<td><form method="POST" action="CartController">
					<strong>Model:</strong> TF-Model3<input type="hidden"
						name="modelNo" value="TF-MODEL3"> <strong>Description:</strong>
					Model 1 <input type="hidden" name="description" value="Model 3">
					<strong>Quantity:<input type="text" size="2" value="1"
						name="quantity"></strong> <strong>Price:</strong> $30.00 <input
						type="hidden" name="price" value="30"> <input
						type="hidden" name="action" value="add"> <input class="btn btn-info" role="button"
						type="submit" name="addToCart" value="Add To Cart">
				</form></td></tr><tr>
			<td>
				<form  method="POST" action="CartController">
					<strong>Model:</strong> TF-Model4 <input type="hidden"
						name="modelNo" value="TF-MODEL4"> <strong>Description:</strong>Model2
					<input type="hidden" name="description" value="Model 4">
					
					<strong>Quantity</strong><input type="text" size="2" value="1"  
						name="quantity"> <strong>Price</strong>$40.00 <input
						type="hidden" name="price" value="40"> <input
						type="hidden" name="action" value="add"><input class="btn btn-info" role="button"
						type="submit" name="addToCart" value="Add To Cart"><br/><br/>
				</form>
			</td>
		</tr>
	</table>
	<a href='list-customers.jsp'>Go To Home Page</a>
	</div>
</body>
</html>
