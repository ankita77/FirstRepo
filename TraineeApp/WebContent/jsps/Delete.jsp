<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Delete Operation</h2>
<form action="getDeleteId.do">
Please Enter trainee Id:
<input type="text" name="id">
<input type="submit" value="delete">
</form>


<table border="1">
	<tr>
		<th>Trainee Id</th>
		<th>Trainee Name</th>
		<th>Trainee Location</th>
		<th>Trainee Domain</th>
	</tr>


	<tr>
		<td>${trainee.traineeId}</td>
		<td>${trainee.traineeName}</td>
		<td>${trainee.traineeLoc}</td>
		<td>${trainee.traineeDomain}</td>
	</tr>
</table>
<a href="delete.do?id=${trainee.traineeId}">Delete</a>
</center>
</body>
</html>