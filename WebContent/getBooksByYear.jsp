<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search for a book by Year</title>
</head>
<body>
	<h1>Search for books by specific year</h1>
	<form action="GetBooksByYear" method="get">
 		Year: <input type="text" name="year"/>
 			  <input type="submit" value="get"/> 
	</form>
</body>
</html>