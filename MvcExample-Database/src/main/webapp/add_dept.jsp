<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Department</h2>
<sf:form method="post" modelAttribute="dept">
Id:<sf:input  path="id"/>
Name:<sf:input  path="name"/><p>
<p/>
<input type="submit" value="Add Dept"/>
</sf:form>
</body>
</html>