<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%-- <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department List</title>
</head>
<body>
 <h2>Department List</h2>
 <TABLE BORDER="1">
<c:forEach var="row" items="${depts}">
<TR>
<td><c:out value="${row.id}"/> </td>
<td><c:out value="${row.name}"/> </td>
</TR>
</c:forEach>
</TABLE> 

</body>
</html>