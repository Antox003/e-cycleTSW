<%@ page language="java"  import="java.util.List" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/style-login.css">
</head>
<body>
	
	<section class="header-container>">
     	<%@include file="navbar_unlogged.html" %>
    </section>
    
               <% 
					List<String> errors = (List<String>) request.getAttribute("errors");
						if (errors != null){
							for (String error: errors){ %>
								<%=error %> <br>		
								<%
							}
						}
				%>

    <section class="login-form">
        <div class="container">
            <h2>LOGIN</h2>
            <form action="/e-cycle/Login" method="post">
                <label for="email">Username</label>
                <br>
                <input type="text" name="username" id="username" placeholder=" Inserisci il tuo username">
                <br>
                <br>
                <label for="password">Password</label>
                <br>
                <input type="password" name="password"  id="password" placeholder=" Inserisci la tua password">
                <br>
                <br>
                <div class="button-container">
                    <input type="submit" id="button" value="Accedi">
                    <p><a href="">Non hai un account?Registrati</a></p>
                </div>
                <br>
            </form>
        </div>
    </section>
    <br>
    <section class="footer-container">
     	<%@include file="footer.jsp" %>
    </section>
    

</body>
</html>