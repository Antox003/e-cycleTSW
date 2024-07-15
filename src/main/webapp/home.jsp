<%@ page language="java" import="java.util.List, model.ProductBean" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Cycle | Home</title>
    <link rel="stylesheet" href="css/style-home.css">
    <link rel="icon" href="img/logo_circle.png" type="image/png">
</head>
<body>

    <section class="header-container">
        <%@include file="fragment/header.jsp" %>
    </section>

    <section id="prova">
    
    </section>

    <div id="riquadro">
        <br>
        <section id="barra_ricerca">
            <div class="container_strumenti">
                <input type="search" placeholder=" Cerca nel catalogo" id="search">
                <button class="search-button">
                    <img src="img/search.svg" alt="" id="search">
                </button>
            </div>
        </section>

        <section id="tendenza">
            <h2>I nostri prodotti ></h2>

            <div class="container_card">
                <% List<ProductBean> productList = (List<ProductBean>) request.getAttribute("productList"); %>
                <% if (productList != null) { %>
                    <% for (ProductBean product : productList) { %>
                        <div class="card">
                            <img class="immagine-prodotto" src="img/<%= product.getNome() %>.png" alt="Immagine prodotto">
                            <h3><%= product.getNome() %></h3>
                            <p><%= product.getDescrizione() %></p>
                            <br>
                            <div class="bottone-prodotto">
                                <button class="visualizza-prodotto"><a href="ProductDetail?ID_PRODOTTO=<%= product.getCode() %>">Vedi prodotto</a></button>
                                <h5><%= product.getPrezzo() %> &#8364;</h5>
                            </div>
                        </div>
                    <% } %>
                <% } else { %>
                    <p>Nessun prodotto disponibile</p>
                <% } %>
            </div>
        </section>
    </div>
    
     <section class="footer-container>">
     	<%@include file="fragment/footer.jsp" %>
    </section>
    
</body>
</html>
