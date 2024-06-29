<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.UserBean" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/navbar-unlogged-style.css">
    <meta charset="UTF-8">
    <title>e-Cycle</title>
</head>
<body>
<header>
    <div class="cont-bar">
        <div class="logo">
            <a href="home.jsp"><img class="logo" src="img/logo.png"></a>
        </div>
        <nav>
            <a href="home.jsp"><img src="img/img-casa.svg" class="img-nav">Home</a>
            <a href="carrello.jsp"><img src="img/img-carrello.svg" class="img-nav">Carrello</a>
            <a href="login.jsp"><button class="btn">Login</button></a>

            <% 
            // Controlla se l'utente è loggato
            if (session.getAttribute("registeredUser") != null) {
                UserBean bean = (UserBean) session.getAttribute("registeredUser");
                if (bean.getEmail() != null && !bean.getEmail().isEmpty()) {
                    // Se l'utente è loggato, mostra il ruolo
                    if (bean.getRole().compareTo("admin") == 0) { %>
                        <p>admin</p>
                    <% } else { %>
                        <p>user</p>
                    <% }
                }
            }
            %>
         

        </nav>
    </div>
</header>
</body>
</html>
