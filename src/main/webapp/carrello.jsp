<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.CartBean, model.ProductBean, java.text.DecimalFormat, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style-carrello.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="icon" href="img/logo_circle.png" type="image/png">
    <title>E-Cycle | Carrello</title>
</head>
<body>

<section class="header-container">
    <jsp:include page="fragment/header.jsp"/>
</section>

<section id="cart-container">
    <div class="container-carrello" style="margin-bottom: 300px; margin-top: 110px">
        <div class="titoli">
            <h3 class="titolo">Carrello <img src="img/img-carrello.svg" class="img-h3"></h3>
            <h5 class="cancella-articoli"><a href="CartControl?action=svuotare">Svuota Carrello</a> <img src="img/img-cestino.png" class="img-h5"></h5>
        </div>
        <hr> 
        <div class="articoli-carrello">
            <table>
                <%
                    Collection<ProductBean> carrello = null;
                    double somma = 0;
                    DecimalFormat df = new DecimalFormat("0.00");

                    if (session.getAttribute("carrello") != null) {
                        CartBean cart = (CartBean) session.getAttribute("carrello");
                        carrello = cart.getCarrello();
                    }

                    if (carrello != null && !carrello.isEmpty()) {
                        for (ProductBean bean : carrello) {
                            Double price = bean.getPrezzo();
                            String prezzo = df.format(price);

                            Double tot = bean.getPrezzo() * bean.getQuantity();
                            String prezzoTot = df.format(tot);
                            somma += tot;
                %>
                <tr>
                    <td>
                        <div class="cart-info">
                            <img src="img/<%=bean.getNome()%>.png" style="width: 160px; height: 160px">
                        </div>
                    </td>
                    <td><%=bean.getNome()%></td>
                    <td><%=prezzo%> &euro;</td>
                    <td>
                        <a href="CartControl?action=diminuisci&codice=<%=bean.getCode()%>"><i class="fa-solid fa-minus"></i></a>
                        <input type="number" value="<%=bean.getQuantity()%>" min="1" max="99" readonly>
                        <a href="CartControl?action=aumenta&codice=<%=bean.getCode()%>"><i class="fa-solid fa-plus"></i></a>
                    </td>
                    <td><a href="CartControl?action=rimuovere&codice=<%=bean.getCode()%>"><i class="fas fa-trash-alt"></i></a></td>
                    <td><%=prezzoTot%> &euro;</td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </div>
  
        <%  String totale = df.format(somma);
            if (carrello != null && !carrello.isEmpty()) {
        %>
        <div class="total-price">
            <table>
                <tr>
                    <td>Totale</td>
                    <td><%=totale%> &euro;</td>
                </tr>
            </table>
        </div>
   
        <% if (session.getAttribute("registeredUser") != null) { %>
        <div class="button-buy-container">
            <a href="OrderControl"><button class="buy-button">PROCEDI ALL'ACQUISTO</button></a>
        </div>
        <% } else { %>
        <div class="button-buy-container">
            <a href="loginPage.jsp"><button class="buy-button">REGISTRATI PER ACQUISTARE</button></a>
        </div>
        <% } %>
        <% } else { %>
        <div class="total-price" style="margin-top: 20px; margin-bottom: 500px">
            <table>
                <tr>
                    <td>Carrello vuoto! Inserisci un prodotto per continuare</td>
                </tr>
            </table>
        </div>
        <% } %>
    </div>
</section>

<section class="footer-container">
    <jsp:include page="fragment/footer.jsp"/>
</section>

</body>
</html>
