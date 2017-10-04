<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2>Enter Trainee Details</h2>
 <sf:form method="post" modelAttribute="trainee" action="insert.do">
	    <label for="traineeId"> Trainee Id:</label>
	<sf:input path="traineeId" id="traineeId" type="text"/><br/>
	  
	   <label for="traineeName"> Trainee Name:</label>
	  <sf:input path="traineeName" id="name" type="text"/><br/>
	  
	   <label for="traineeLoc"> Trainee Location:</label>
	   <sf:radiobutton path="traineeLoc" for="traineeLoc" value="Chennai" label="Chennai"/><br/>
	   <sf:radiobutton path="traineeLoc" for="traineeLoc" value="Bangalore" label="Bangalore"/><br/>
	   <sf:radiobutton path="traineeLoc" for="traineeLoc" value="Pune" label="Pune"/><br/>
	   <sf:radiobutton path="traineeLoc" for="traineeLoc" value="Mumbai" label="Mumbai"/><br/>
	   
	   <label for="traineeDomain"> Trainee Domain:</label>
	   <sf:select path="traineeDomain" id="traineeDomain">
	   <sf:option path="traineeDomain" value="JEE" for="domain">JEE</sf:option>
	   <sf:option path="traineeDomain" value="DotNet" for="domain">.NET</sf:option>
	   <sf:option path="traineeDomain" value="Mainframe" for="domain">Mainframe</sf:option>
	   </sf:select>
	   
	   
	   
	   
	   
	  <input type="submit" value="Add Trainee"/>
</sf:form>
</center>
</body>
</html>