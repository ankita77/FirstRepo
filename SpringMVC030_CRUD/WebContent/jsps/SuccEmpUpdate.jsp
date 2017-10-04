<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update successful</title>
 <script src="jsLib/jquery-1.12.3.js" type="text/javascript"></script>
  <script src="jsLib/MyJsLib.js" type="text/javascript"></script>
</head>
<body>
<h1>Capgemini India Pvt Ltd, Mumbai</h1>
   <h3>${pageHead}</h3>
   
   <table border='1'>
   <tr>
   <th>Employee Number</th>
   <th>Employee Name</th>
   <th>Salary</th>
   <th>Hire Date</th>
   </tr>
   
  
   <tr>
   <td>${emp.empNo}</td>
   <td>${emp.empNm}</td>
    <td>${emp.empSal}</td>
   <td>${emp.hireDate}</td>
   </tr>
   
   
   </table>
   <a href="getUpdateName.do">Go back to update</a><br>
   <a href="getHomePage.do">home</a>
</body>
</html>