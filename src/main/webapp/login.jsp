<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Cycle | Login</title>
    <link rel="stylesheet" href="css/style-login.css">
    <link rel="shortcut icon" href="img/logo_circle.png">
</head>
<body>
    
    <section class="header-container">
        <%@include file="navbar_unlogged.jsp" %>
    </section>

    <section class="login-form">
        <div class="container">
            <h2>LOGIN</h2>
            <form action="Login" method="post">
                <label for="email">Email</label>
                <br>
                <input type="email" name="email" id="email" placeholder="Inserisci il tuo email" required>
                <br>
                <% 
                    if (request.getSession().getAttribute("login-error") != null && (boolean) request.getSession().getAttribute("login-error")) {
                %>
                    <span style="color: red;">Login non riuscito. Verifica le credenziali.</span><br>
                <% } %>
                <br>
                <label for="password">Password</label>
                <br>
                <input type="password" name="password"  id="password" placeholder="Inserisci la tua password" required>
                <br>
                <br>
                <div class="button-container">
                    <input type="submit" id="button" value="Accedi">
                    <p><a href="registration.jsp">Non hai un account? Registrati</a></p>
                </div>
            </form>
        </div>
    </section>
    <br>
    <section class="footer-container">
        <%@include file="footer.jsp" %>
    </section>

</body>
</html>
