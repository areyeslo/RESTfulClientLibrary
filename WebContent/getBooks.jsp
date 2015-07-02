<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Search for the list of books</h1>
	<form action="GetBooks" method="get">
 		  Please press the button to search the list of books <input type="submit" value="get"/> 
	</form>
	<br />
	<br />
	<br />
	<form action="GetBooks" method="Post">
		Name:   <input type="text" name="name"/>
		<br /><br />
		Author: <input type="text" name="author"/>
		<br /><br />
		Year: <input type="text" name="year"/>
		<br /><br />
		Publisher: <input type="text" name="publisher"/>
		<br /><br />
 		<input type="submit" value="Post"/>  

	</form>
</body>
</html>