<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Modify Operation</h2>
<form action="getUpdateId.do">
Please Enter trainee Id:
<input type="text" name="id">
<input type="submit" value="modify">
</form>


<form action="update.do">
<table border="1">
	<tr>
		<th>Trainee Id</th>
		<th>Trainee Name</th>
		<th>Trainee Location</th>
		<th>Trainee Domain</th>
	</tr>


	<tr>
		<td><input type="text" name="id" value="${trainee.traineeId}" readonly></td>
		<td><input type="text" name="name" value="${trainee.traineeName}"></td>
		<td><input type="text" name="loc" value="${trainee.traineeLoc}"></td>
		<td><input type="text" name="domain" value="${trainee.traineeDomain}"></td>
	</tr>
</table>
<input type="submit" value="update">
</form>
</body>
</html>