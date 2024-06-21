<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style-profilo.css">
        <meta charset="UTF-8">
        <title>E-Cycle | Profilo</title>
        <link rel="shortcut icon" href="img/logo_circle.png">
    </head>
    <body>
    <section class="header-container>">
     	<%@include file="navbar_unlogged.jsp" %>
    </section>
    
        <div class="container-profilo">
            <header>
                <h3 class="titolo">Il mio Profilo <img src="img/img-utente.svg" class="img-h3"></h3>
                <h5 class="logout">Esci <img src="img/img-logout.svg" class="img-h5"></h5>
            </header>
            <!-- Informazioni Personali -->
            <h1 class="titolo-info"><img src="img/img-utente2.svg" class="img-riepilogo"> Informazioni Personali</h1>    
            <div class="riepilogo">
                <table class="tabella-utente">
                    <tr>
                        <th>Nome</th>
                        <td>Mario</td>
                    </tr>
                    <tr>
                        <th>Cognome</th>
                        <td>Rossi</td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td>mario@rossi.it</td>
                    </tr>
                    <tr>
                        <th>Numero di Telefono</th>
                        <td>1234567890</td>
                    </tr>
                    <tr>
                        <th>Data di Registrazione</th>
                        <td>01/01/2020</td>
                    </tr>
                    <tr>
                        <th>Numero Ordini</th>
                        <td>5</td>
                    </tr>
                    <tr>
                        <th>Data Ultimo Ordine</th>
                        <td>15/03/2024</td>
                    </tr>
                    <tr>
                        <th>Stato Account</th>
                        <td>Attivo</td>
                    </tr>
                </table>
                <a class="modifica"><img src="img/img-matita.svg" class="img-cont"><b><u>Modifica Informazioni</u></b></a> 
            </div>
            <br>
            <hr>

            <!-- Indirizzo di spedizione -->
            <h1 class="titolo-info"><img src="img/img-casa.svg" class="img-riepilogo"> Indirizzo di spedizione</h1>
            <div class="riepilogo">
                <table class="tabella-utente">
                    <tr>
                        <th>Nome completo</th>
                        <td>Gennaro Sinicario</td>
                    </tr>
                    <tr>
                        <th>Paese</th>
                        <td>Italia</td>
                    </tr>
                    <tr>
                        <th>Provincia</th>
                        <td>AV</td>
                    </tr>
                    <tr>
                        <th>Città</th>
                        <td>Pratola Serra</td>
                    </tr>
                    <tr>
                        <th>CAP</th>
                        <td>83039</td>
                    </tr>
                    <tr>
                        <th>Indirizzo</th>
                        <td>Piazza Dei Petruzziello</td>
                    </tr>
                    <tr>
                        <th>Numero Civico</th>
                        <td>6</td>
                    </tr>
                    <tr>
                        <th>Numero di Telefono</th>
                        <td>1234567890</td>
                    </tr>
                </table>
                <a class="modifica"><img src="img/img-matita.svg" class="img-cont"><b><u>Modifica Indirizzo</u></b></a>
            </div>
            <br>
            <hr>

                <!-- Metodo di pagamento  -->
            <h1 class="titolo-info"><img src="img/img-carta.svg" class="img-riepilogo"> Metodo di pagamento</h1>
            <div class="riepilogo">
                <table class="tabella-utente">
                    <tr>
                        <th>Nome del Titolare</th>
                        <td>Mario Rossi</td>
                    </tr>
                    <tr>
                        <th>Tipo di Carta</th>
                        <td>Visa</td>
                    </tr>
                    <tr>
                        <th>Numero di Carta</th>
                        <td>**** **** **** 1234</td>
                    </tr>
                    <tr>
                        <th>Data di Scadenza</th>
                        <td>12/2025</td>
                    </tr>
                    <tr>
                        <th>Indirizzo di Fatturazione</th>
                        <td>Via Roma 1, Milano, 20100</td>
                    </tr>
                    <tr>
                        <th>Metodo di Pagamento Preferito</th>
                        <td>Sì</td>
                    </tr>
                </table> 
                <a class="modifica"><img src="img/img-matita.svg" class="img-cont"><b><u>Modifica Pagamento</u></b></a>
            </div>
            <br>          
        </div>
    </body>
</html>