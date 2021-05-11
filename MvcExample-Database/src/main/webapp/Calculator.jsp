<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    int fno = Integer.parseInt(request.getParameter("fno"));
    int sno = Integer.parseInt(request.getParameter("sno"));
    String bValue = request.getParameter("b1");
    if (bValue.equals("ADD")) {
        out.println("SUM=" + (fno + sno));
    } else if (bValue.equalsIgnoreCase("SUB")) {
        out.println("SUB=" + (fno - sno));
    } else if (bValue.equalsIgnoreCase("MUL")) {
        out.println("PRODUCT=" + (fno * sno));
    } else if (bValue.equalsIgnoreCase("DIV")) {
        out.println("DIVISION=" + (fno / sno));
    }
    %>

 
</body>
</html>