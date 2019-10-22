<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Add Customer</h2>
 
  <form action="add.view" method="post">
    <div class="form-group">
      <label for="first_name">First Name:</label>
      <input type="text" class="form-control" id="firstName" name="firstName">
    </div>
    <div class="form-group">
      <label for="last_name">Last Name:</label>
      <input type="text" class="form-control" id="lastName" name="lastName">
    </div>
     <div class="form-group">
      <label for="last_name">Email:</label>
      <input type="email" class="form-control" id="email" name="email">
    </div>
     <button class="btn btn-info btn-block my-4" type="submit">Add A New Customer</button><br/>
     <a href='index.jsp'>Go To Home Page</a></body></html>
  </form>
</div>

</body>
</html>
