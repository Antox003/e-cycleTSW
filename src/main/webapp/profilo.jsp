<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.UserBean, java.util.List, model.SpedizioneBean, model.SpedizioneDAODataSource"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/style-profilo.css">
        <meta charset="UTF-8">
        <title>E-Cycle | Profilo</title>
        <link rel="icon" href="img/logo_circle.png" type="image/png">
    </head>
    <body>
    <section class="header-container>">
     	<%@include file="fragment/header.jsp" %>
    </section>
    
    <section class="max">
    
        <div class="container-profilo">
        <br>
            <div class="profilo">
                <h3 class="titolo">Il mio Profilo</h3>
            </div>
           
             <br>
            <h1 class="titolo-info"><img src="img/img-utente.svg" class="img-riepilogo"> Informazioni Personali</h1>    
            <div class="riepilogo">
                <table class="tabella-utente">
                    <tr>
                        <th>Nome</th>
                        <td><%= user.getNome() %></td>
                    </tr>
                    <tr>
                        <th>Cognome</th>
                        <td><%= user.getCognome() %></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><%= user.getEmail() %></td>
                    </tr>
                    <tr>
                        <th>Numero di Telefono</th>
                        <td><%= user.getTelefono() %></td>
                    </tr>
                    <tr>
                        <th>Data di Nascita</th>
                        <td><%= user.getData_nascita() %></td>
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
                        <td>Attivo<%= String.valueOf(user.getCode()) %></td>
                    </tr>
                </table>
                <a class="modifica"><img src="img/img-matita.svg" class="img-cont"><b><u>Modifica Informazioni</u></b></a> 
            </div>
            <br>
            <hr>
            <br>


            
            <h1 class="titolo-info"><img src="img/img-casa.svg" class="img-riepilogo"> Indirizzo di spedizione</h1>
            <div class="riepilogo">
            
               <%
        SpedizioneBean spedizione = (SpedizioneBean) request.getAttribute("spedizione");
        if (spedizione != null) {
        %>
                <table class="tabella-utente">
                    <tr>
                <th>Nome completo</th>
                <td><%= user.getNome() %> <%= user.getCognome() %></td>
            </tr>
            <tr>
                <th>Stato</th>
                <td><%= spedizione.getStato() %></td>
            </tr>
            <tr>
                <th>Provincia</th>
                <td><%= spedizione.getProvincia() %></td>
            </tr>
            <tr>
                <th>Citt�</th>
                <td><%= spedizione.getCitta() %></td>
            </tr>
            <tr>
                <th>CAP</th>
                <td><%= spedizione.getCap() %></td>
            </tr>
            <tr>
                <th>Indirizzo</th>
                <td><%= spedizione.getIndirizzo() %></td>
            </tr>
            <tr>
                <th>Numero Civico</th>
                <td><%= spedizione.getCivico() %></td>
            </tr>
             <% } else { %>
        <p>Nessun indirizzo di spedizione trovato per questo account.</p>
        <% } %>
        </table>
                <a class="modifica"><img src="img/img-matita.svg" class="img-cont"><b><u>Modifica Indirizzo</u></b></a>
            </div>
            <br>
            <hr>

            <br>
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
                        <td>S�</td>
                    </tr>
                </table> 
                <a class="modifica"><img src="img/img-matita.svg" class="img-cont"><b><u>Modifica Pagamento</u></b></a>
            </div>
            <br>          
        </div>
        
        </section>
        
        <section class="footer-container>">
     	<%@include file="fragment/footer.jsp" %>
    </section>
    
    </body>
</html>

