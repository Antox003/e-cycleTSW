<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prodotto</title>
    <link rel="stylesheet" href="css/style-prodotto.css">
    <link rel="icon" href="img/logo_circle.png" type="image/png">
</head>
<body>

<section class="header-container>">
     	<%@include file="fragment/header.jsp" %>
    </section>

    <section id="riquadro">
        <div class="container-max">
            <div class="container-prodotto">
                <div class="container-img">
                    <div class="big">
                        <img src="img/iphone12(BIG).png" alt="">
                    </div>
                    <div class="small">
                        <img src="img/iphone12(BIG).png" alt="">
                        <img src="img/iphone12(BIG).png" alt="">
                        <img src="img/iphone12(BIG).png" alt="">
                        <img src="img/iphone12(BIG).png" alt="">

                    </div>
                </div>
                <div class="descrizione">
                    <h5>Apple</h5>
                    <h1>Iphone12</h1>
                    <p>
                        Acquista l'iPhone 12 rigenerato e risparmia senza compromettere la qualità.
                        Con display Super Retina XDR, chip A14 Bionic e doppia fotocamera da 12 MP, offre prestazioni eccellenti
                        a un prezzo accessibile Ogni unità è accuratamente testata e garantita per funzionare come nuova.
                        Scegli sostenibilità e valore con l'iPhone 12 rigenerato!
                    </p>            
                    <h3>300&#8364</h3>

                    <div class="container-button">
                        <button class="buy">
                            <a href="#acquista">Acquista</a>
                        </button>
    
                        <button class="cart">
                            <a href="cart">
                                <img src="img/cart-add.svg" alt="">Aggiungi al carrello
                            </a>
                        </button>
                    </div>
                </div>
            </div>

            <section class="info-spedizione">
                <div class="info">
                    <img src="img/truck.svg" alt="">
                    <br>
                    <br>
                    <h4>Spedizione rapida</h4>
                    <br>
                    <p>Riceverai il tuo dispositivo entro 1-3 giorni lavorativi</p>
                </div>
                <br>
                <div class="info">
                    <img src="img/safe-lock.svg" alt="">
                    <br>
                    <br>
                    <h4>Pagamenti sicuri</h4>
                    <br>
                    <p>Utilizziamo solamente i più affidabili servizi di pagamento</p>
                </div>
                <br>
                <div class="info">
                    <img src="img/tick.svg" alt="">
                    <br>
                    <br>
                    <h4>Garanzia e reso</h4>
                    <br>
                    <p>12 mesi di Garanzia Swappie e reso gratuito entro 14 giorni</p>
                </div>
                
            </section>
            <br>
            <br>
            <hr>
            <br>
            <br>
            <section class="table">

                <div class="gray">
                    <div class="specifiche">
                        <h4>Display</h4>
                    </div>
                    <div class="specifiche">
                        <p>Display OLED Super Retina da 6.1” con HDR e True Tone</p>
                    </div>
                </div>
                <div class="white" >
                    <div class="specifiche">
                        <h4>Fotocamera</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">Doppia fotocamera da 12 MP con stabilizzazione ottica dell'immagine, modalità ritratto e illuminazione, video 4K a 1080p</p>
                    </div>
                </div>
                <div class="gray">
                    <div class="specifiche">
                        <h4>Spazio archiviazione</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">128gb</p>
                    </div>
                </div>
                <div class="white" >
                    <div class="specifiche">
                        <h4>Fotocamera</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">Doppia fotocamera da 12 MP con stabilizzazione ottica dell'immagine, modalità ritratto e illuminazione, video 4K a 1080p</p>
                    </div>
                </div>
                <div class="gray">
                    <div class="specifiche">
                        <h4>Autenticazione sicura</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">Proteggi la tua privacy con il riconoscimento facciale</p>
                    </div>   
                </div>
                <div class="white" >
                    <div class="specifiche">
                        <h4>Chip</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">Chip A14 Bionic, estremamente potente e intelligente</p>
                    </div>
                </div>
                <div class="gray">
                    <div class="specifiche">
                        <h4>Scheda SIM</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">Chip A14 Bionic, estremamente potente e intelligente</p>
                    </div>
                </div>
                <div class="white" >
                    <div class="specifiche">
                        <h4>Bluetooth</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">5.0</p>
                    </div>
                </div>
                <div class="gray">
                    <div class="specifiche">
                        <h4>Connettori</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">Connettore Lightning</p>
                    </div>
                </div>
                <div class="white" >
                    <div class="specifiche">
                        <h4>Rete</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">5G / LTE, Wi-Fi</p>
                    </div>
                </div>
                <div class="gray">
                    <div class="specifiche">
                        <h4>Batteria</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">Li-ion 2815 mAh, ricarica senza fili, compatibile con caricabatterie Qi</p>
                    </div> 
                </div>
                <div class="white" >
                    <div class="specifiche">
                        <h4>Dimensioni e peso</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">146.7 x 71.5 x 7.4 mm / 164 g</p>
                    </div>
                </div>
                <div class="gray">
                    <div class="specifiche">
                        <h4>Sistema operativo</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">Goditi iOS 17, il miglior sistema operativo mai sviluppato da Apple</p>
                    </div>
                </div>
                <div class="white" >
                    <div class="specifiche">
                        <h4>Resistenza all'acqua</h4>
                    </div>
                    <div class="specifiche">
                        <p class="paragrafo">A causa del processo di ricondizionamento non possiamo garantire che la certificazione IP68 rimanga valida.</p>
                    </div>
                </div>

            </section>

        </div>
    </section>
    <br>
    <br>
    <br>
    <br>

<section class="footer-container>">
     	<%@include file="fragment/footer.jsp" %>
    </section>

</body>
</html>