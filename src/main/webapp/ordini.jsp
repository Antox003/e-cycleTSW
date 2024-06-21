<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style-ordini.css">
        <meta charset="UTF-8">
        <title>E-Cycle | Ordini</title>
        <link rel="shortcut icon" href="img/logo_circle.png">
    </head>
    <body>
    <section class="header-container>">
     	<%@include file="navbar_unlogged.jsp" %>
    </section>
    
        <div class="container-ordini">
            <header>
                <h3 class="titolo">I miei Ordini <img src="img/img-ordini.svg" class="img-h3"></h3>
                <a class="n_ordini">2 ordini effettuati.</a>
            </header>
            <hr>    
            <!-- ORDINE 2 -->
            <div class="articoli-ordine">           
                <div class="riepilogo">
                    <h1 class="titolo-art"><img src="img/img-info.svg" class="img-h1"> Dettagli ordine #02</h1><br> 
                    <div class="dettagli">
                        <img href="#prodotto" class="immagine-prodotto" src="img/img-prodotto.png"/>
                        <a href="#prodotto" class="articolo"><b><u>Titolo articolo 2</u></b></a>          
                    </div> 
                    <table class="tabella-utente">
                        <tr>
                            <th>Stato</th>
                            <td>In Consegna</td>
                        </tr>
                        <tr>
                            <th>Data di consegna prevista</th>
                            <td>19/05/2024</td>
                        </tr>
                        <tr>
                            <th>Nome Prodotto</th>
                            <td>Titolo articolo 2</td>
                        </tr>
                        <tr>
                            <th>Data</th>
                            <td>18/05/2024</td>
                        </tr>
                        <tr>
                            <th>Inviato a</th>
                            <td>Gennaro Sinicario</td>
                        </tr>
                        <tr>
                            <th>Totale</th>
                            <td>499.00&#8364</td>
                        </tr>
                            <th>Pagato con carta n°</th>
                            <td>**** 1234</td>
                        <tr>
                            <th>Numero ordine</th>
                            <td>#02</td>
                        </tr>
                    </table>
                </div> 
            </div>
            <br>
            <hr>
            <br>
            <!-- ORDINE 1 -->
            <div class="articoli-ordine">           
                <div class="riepilogo">
                    <h1 class="titolo-art"><img src="img/img-info.svg" class="img-h1"> Dettagli ordine #01</h1><br> 
                    <div class="dettagli">
                        <img href="#prodotto" class="immagine-prodotto" src="img/img-prodotto.png"/>
                        <a href="#prodotto" class="articolo"><b><u>Titolo articolo 1</u></b></a>          
                    </div> 
                    <table class="tabella-utente">
                        <tr>
                            <th>Stato</th>
                            <td>In Consegna</td>
                        </tr>
                        <tr>
                            <th>Data di consegna prevista</th>
                            <td>19/05/2024</td>
                        </tr>
                        <tr>
                            <th>Nome Prodotto</th>
                            <td>Titolo articolo 1</td>
                        </tr>
                        <tr>
                            <th>Data</th>
                            <td>18/05/2024</td>
                        </tr>
                        <tr>
                            <th>Inviato a</th>
                            <td>Gennaro Sinicario</td>
                        </tr>
                        <tr>
                            <th>Totale</th>
                            <td>499.00&#8364</td>
                        </tr>
                            <th>Pagato con carta n°</th>
                            <td>**** 1234</td>
                        <tr>
                            <th>Numero ordine</th>
                            <td>#01</td>
                        </tr>
                    </table>
                </div> 
            </div>
            <br>
        </div>
    </body>
</html>