<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

	<%
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
	if (isAdmin == null){
		response.sendRedirect(request.getContextPath()+ "/login.jsp");
		return;
	}
	%>

<body>
	
	<h1>ADMIN</h1>
    
	<a href="Logout">Esci</a>
</body>
</html>