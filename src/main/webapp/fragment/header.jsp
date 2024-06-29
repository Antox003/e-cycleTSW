<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style-header.css">

</head>
<body>
	<header>
        <div class="cont-bar">
            <a href="#home"><img class="logo" src="./File Immagini/img-logo.png" alt="Logo"></a>
            <input class="side-menu" type="checkbox" id="side-menu"/>
            <label class="hamb" for="side-menu">
                <span class="hamb-line"></span>
            </label>
            <nav>
                <ul class="menu">
                    <li><a href="#home"><img src="./File Immagini/img-casa2.svg" class="img-nav" alt="Home Icon"><span class="nav-testo">Home</span></a></li>
                    <li><a href="#carrello"><img src="./File Immagini/img-carrello.svg" class="img-nav" alt="Carrello Icon"><span class="nav-testo">Carrello</span></a></li>
                    <li class="menu-profilo">
                        <a><img src="./File Immagini/img-utente2.svg" class="img-nav" alt="Profilo Icon"><span class="nav-testo">Profilo<img src="./File Immagini/img-frecciagiu.svg" class="freccia-giu"></span></a>
                        <ul class="sottomenu">
                            <li><a href="#profilo"><img src="./File Immagini/img-settaggi.svg" class="img-nav" alt="Settaggi Icon">Profilo</a></li>
                            <li><a href="#ordini"><img src="./File Immagini/img-ordini.svg" class="img-nav" alt="Ordini Icon">Ordini</a></li>
                            <li><a class="logout" href="#logout"><img src="./File Immagini/img-logout.svg" class="img-nav" alt="Logout Icon">Esci</a></li>
                        </ul>
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
                    </li>
                </ul>
            </nav>
        </div>
    </header>
</body>
</html>