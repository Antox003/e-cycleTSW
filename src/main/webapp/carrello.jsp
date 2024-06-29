<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style-carrello.css">
        <meta charset="UTF-8">
        <title>E-Cycle | Carrello</title>
    </head>
    <body>
    
 
    
        <div class="container-carrello">
            <div class="titoli">
                <h3 class="titolo">Carrello <img src="img/img-carrello.svg" class="img-h3"></h3>
                <h5 class="cancella-articoli">Svuota Carrello <img src="img/img-cestino.png" class="img-h5"></h5>
            </div>
            <hr> 
            <!-- ARTICOLO 1 -->
            <div class="articoli-carrello">
                <!-- SPUNTA -->
                <input type="checkbox" checked="checked" name="prodotto_1">
                <!-- IMMAGINE -->
                <div class="box-immagine">
                    <img class="immagine-prodotto" src="img/img-prodotto.png"/>
                </div>
                <!-- INFO -->
                <div class="info-prodotto">
                    <h1 class="titolo-prodotto">Titolo Prodotto</h1>
                    <h3 class="dettagli">Dettagli e caratteristiche del prodotto</h3>
                </div>
                <div class="quantita">
                    <div class="btn">-</div>
                    <div class="contatore">1</div>
                    <div class="btn">+</div>
                </div>
                <div class="prezzo">
                    <div class="ammontare">499.00&#8364</div>
                    <div class="rimuovi"><u>Rimuovi</u></div>
                </div>
            </div>
            <br>
            <hr> 
            <!-- ARTICOLO 2 -->
            <div class="articoli-carrello">
                <!-- SPUNTA -->
                <input type="checkbox" checked="checked" name="prodotto_2">
                <!-- IMMAGINE -->
                <div class="box-immagine">
                    <img class="immagine-prodotto" src="img/img-prodotto.png"/>
                </div>
                <!-- INFO -->
                <div class="info-prodotto">
                    <h1 class="titolo-prodotto">Titolo Prodotto</h1>
                    <h3 class="dettagli">Dettagli e caratteristiche del prodotto</h3>
                </div>
                <div class="quantita">
                    <div class="btn">-</div>
                    <div class="contatore">1</div>
                    <div class="btn">+</div>
                </div>
                <div class="prezzo">
                    <div class="ammontare">499.00&#8364</div>
                    <div class="rimuovi"><u>Rimuovi</u></div>
                </div>
            </div>
            <br>
            <hr> 
            <br>
            <div class="checkout">
                <div class="spedizione">Costi di spedizione: Gratis<br>Totale articoli: 2</div>
                <div class="totale">
                    <div>
                        <div class="subtotale">Totale</div>
                    </div>
                    <div class="costo-totale">998.00&#8364</div>
                </div>
                <button class="pulsante">Paga ora</button>
                <br>
            </div>
        </div>
        <br>
        <br>
        <section class="footer-container>">
     	<%@include file="fragment/footer.jsp" %>
    </section>
    </body>
</html>