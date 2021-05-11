<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*" %>
<%!
Connection con=null;
public void jspInit(){
try{
	Class.forName("com.mysql.jdbc.Driver");
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "dbmanager", "dbmanager");
	 System.out.println("Connected:"+con);
}
catch(Exception e){
	 System.out.println(e);
     }
}
%>
<%
try{
String name=request.getParameter("name");
String upass=request.getParameter("upass");
PreparedStatement pst = con
.prepareStatement("insert into user(username,password)values(?,?)");
pst.setString(1, name);
pst.setString(2, upass);
int num=pst.executeUpdate();
if(num>0){
	out.println("<h1 style=color:pink>Inserted</h1>");
}
else{
	out.println("<h1 style=color:pink>Try Again</h1>");
}
}
catch(Exception e){
	System.out.println(e);
}
%>
</body>
</html>