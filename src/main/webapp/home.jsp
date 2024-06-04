<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
// Check user credentials
Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
if (isAdmin == null){	
    response.sendRedirect(request.getContextPath() + "/login.jsp"); 
    return;
}
%>
<body>
	
	<h1>HOME</h1>
	
	 
    
	<a href="/e-cycle/Logout">Esci</a>
</body>
</html>