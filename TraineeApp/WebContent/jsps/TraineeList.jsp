<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table border='1' id="traineeList">
   <tr>
		<th>Trainee Id</th>
		<th>Trainee Name</th>
		<th>Trainee Location</th>
		<th>Trainee Domain</th>
	</tr>
	
	
   <c:forEach items="${traineeList}" var="trainee">
   <tr>
   <td>${trainee.traineeId}</td>
   <td>${trainee.traineeName}</td>
   <td>${trainee.traineeLoc}</td>
   <td>${trainee.traineeDomain}</td>
   </tr>
   </c:forEach>
   
   </table>
</body>
</html>