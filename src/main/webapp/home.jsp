<%@ page language="java"  import="java.util.List" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="css/style-home.css">
</head>
    <body>
    
    <section class="header-container>">
     	<%@include file="header_guest.jsp" %>
    </section>
    
    <section id="background">
    <h1>Ciao</h1>
    </section>
    
    <div id="riquadro">
        <br>
        <section id="barra_ricerca">
            <div class="container_strumenti">
                <input type="search" placeholder=" Cerca nel catalogo" id="search">
                <button>
                    <img src="img/search.svg" alt="" id="search">
                </button>
            </div>
        </section>
    
        <section id="tendenza">
            <h2>Di tendenza ></h2>
    
            <div class="container_card">
    
                <div class="card">
                    <img class="immagine-prodotto" src="img/img-xiaomi14.jpeg">
                    <h3>Iphone 12</h3>
                    <p>Prestazioni top con chip A14, doppia fotocamera. Testato e garantito!</p>
                    <h5>269 &#8364</h5>
                </div>
        
                <div class="card">
                    <img class="immagine-prodotto" src="img/img-xiaomi14.jpeg" alt="Iphone 12">
                    <h3>Xiaomi 14</h3>
                    <p>Chip potente, display OLED e camera avanzata. Testato e garantito!</p>
                    <h5>455 &#8364</h5>
                </div>
        
                <div class="card">
                    <img class="immagine-prodotto" src="img/img-xiaomi14.jpeg" alt="Iphone 12">
                    <h3>Huawei mate 50</h3>
                    <p>Potente ed elegante. Esplora l'ultima tecnologia con il display OLED</p>
                    <h5>420 &#8364</h5>
                </div>
        
                <div class="card">
                    <img class="immagine-prodotto" src="img/img-xiaomi14.jpeg" alt="Iphone 12">
                    <h3>Iphone 13</h3>
                    <p>Prestazioni top con chip A15, doppia fotocamera. Testato e garantito!</p>
                    <h5>389 &#8364</h5>
                </div>
    
            </div>
            
        </section>
            <br>
            <br>
            <h2>Visualizza tutti ></h2>
            <section id="visualizza_tutti">
                <div class="container_card">
    
                    <div class="card">
                        <img class="immagine-prodotto" src="img/img-xiaomi14.jpeg" alt="Iphone 12">
                        <h3>Samsung book 3</h3>
                        <p>Design elegante, prestazioni potenti. Esplora il futuro dell'informatica!</p>
                        <h5>400 &#8364</h5>
                    </div>
            
                    <div class="card">
                        <img class="immagine-prodotto" src="img/img-xiaomi14.jpeg" alt="Iphone 12">
                        <h3>Iphone 12</h3>
                        <p>IPhone di Francesco perchè è straricco e possiede tutti gli aifon</p>
                        <h5>400 &#8364</h5>
                    </div>
            
                    <div class="card">
                        <img class="immagine-prodotto" src="img/img-xiaomi14.jpeg" alt="Iphone 12">
                        <h3>Iphone 12</h3>
                        <p>IPhone di Francesco perchè è straricco e possiede tutti gli aifon</p>
                        <h5>400 &#8364</h5>
                    </div>
            
                    <div class="card">
                        <img class="immagine-prodotto" src="img/img-xiaomi14.jpeg" alt="Iphone 12">
                        <h3>Iphone 12</h3>
                        <p>IPhone di Francesco perchè è straricco e possiede tutti gli aifon</p>
                        <h5>400 &#8364</h5>
                    </div>
        
                </div>
            </section>
            
    </div>
    
    <!-- 	<a href="/e-cycle/Logout">Esci</a>  -->
        
    </body>

</html>
