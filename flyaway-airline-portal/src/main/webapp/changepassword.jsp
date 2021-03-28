<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway Airline Portal</title>
</head>
<body>
<%
String username = request.getParameter("username");
String password=request.getParameter("current");
String newpassword =request.getParameter("new");
String conpass=request.getParameter("confirm");
String connurl = "jdbc:mysql://localhost:3306/studentdb?useSSL=false";
Connection con=null;
String pass="";
int uid=0;
try{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(connurl, "root", "root");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from login where password='"+password+"'");
while(rs.next()){
uid=rs.getInt(1);
pass=rs.getString(3);
} 
System.out.println(uid+ " "+pass);
if(pass.equals(password)){
Statement st1=con.createStatement();
int i=st1.executeUpdate("update login set password='"+newpassword+"' where uid='"+uid+"'");
out.println("Password changed successfully");
st1.close();
con.close();
}
else{
out.println("Invalid Current Password");
}
}
catch(Exception e){
out.println(e);
}
%>
        
   <a href="/flyaway-airline-portal/index.html">Logout</a>
	</body>
</html>