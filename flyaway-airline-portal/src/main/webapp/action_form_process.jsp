<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h1>Form Processing</h1>
 
<p><b>Welcome FlyAway User: Here is your user input details</b><br>
   <h3> Flying From: <%= request.getParameter("source")%></h3><br>
   <h3> Flying To:<%= request.getParameter("destination")%></h3><br>
   <h3> Date of Departure:<%= request.getParameter("departure")%></h3><br>
   <h3> Date of Return:<%= request.getParameter("returning")%></h3><br>
</p>
 
</body>
</html>
</body>
</html>