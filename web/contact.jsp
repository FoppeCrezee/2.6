<%-- 
    Document   : contact
    Created on : 8-jun-2018, 12:38:10
    Author     : foppe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Second opinion</title>
        <link rel="stylesheet" href="Styless.css"> 
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="script.js"></script>    
    </head>
    <body>
        <%
//allow access only if session exists
            String user = null;
            if (session.getAttribute("user") == null || session.getAttribute("beroep") != "patient") {
                response.sendRedirect("inlog.html");
            } else {
                user = (String) session.getAttribute("user");
            }
        %>

        <div id="main">
            <div id="header" class="hoofd">
                <img src="https://www.avl.nl/media/8869707/logo-NL-Antoni-van-Leeuwenhoek_jpeg_grootformaat.jpg" id="avl3">
                <h1 align="center">Second opinion portaal</h1>
                <div id="uitlog">
                    <form action="LogoutServlet" method="post">
                        <input type="submit" value="Uitloggen" class="uitloggen" >
                    </form>
                </div>
            </div>

            <div id="gegevens2">

                <div id="menu">
                    <a href="Ingelogd.jsp">
                        <div class="menuKnop" id="eerste">
                            <p class="boven">Mijn gegevens</p>
                        </div>
                    </a>
                    <a href="aanvraag.jsp">
                        <div class="menuKnop" id="tweede">
                            <p class="boven">Mijn aanvraag</p>
                        </div>
                    </a>
                    <a href="behandeling.jsp">
                        <div class="menuKnop" id="derde">
                            <p class="boven">Mijn second <br>opinion team</p>
                        </div>
                    </a>
                    <a href="contact.jsp">
                        <div class="menuKnopGekozen" id="vierde">
                            <p class="gekozen">Contact</p>
                            <div id="driehoek">
                            </div>
                        </div>
                    </a>			
                </div>
                <div id="content">
                    <p align="center" id="titel">Contact</p>

                    <b>Heeft u nog vragen?</b><br>
                    Neem dan telefonisch contact met ons op via 020 512 9111 of kijk hieronder bij veel gestelde vragen of u uw antwoord kan vinden.

                    <p id="vragen"><br><b>Veelgestelde vragen</b></p>

                    <button id="buton_id" class="kweeste" onclick="klik(this.id)">Waar wordt bij een second opinion precies naar gekeken?</button>
                    <div class="bar" id="vraag1">
                        <p id="vraagje">
                            De specialist of huisarts die u doorverwijst
                            zal in de verwijsbrief moeten formuleren waar
                            u een second opinion over wilt hebben. Met
                            andere woorden, welke vragen wilt u door de
                            specialist van het Antoni van Leeuwenhoek
                            beantwoord zien? Uiteraard is er ruimte voor
                            aanvullende vragen als die tijdens het
                            gesprek met de arts ontstaan. Maar houdt u
                            er rekening mee dat hoe duidelijker de vraag
                            voor een second opinion is gesteld, hoe
                            beter wij aan uw verwachtingen kunnen
                            voldoen.</p>
                    </div>

                    <button id="vraag2a" class="kweeste" onclick="klik2(this.id)">Wat gebeurt er bij een second opinion afspraak?</button>
                    <div class="bar" id="vraag2"><p id="vraagje">
                            De specialist zal aan de hand van uw
                            medische gegevens:<br>
                            1.  met u over uw aandoening praten<br>
                            2.  U (eventueel) lichamelijk onderzoeken<br>
                            3.  (eventueel) met uw behandelend artsen
                            overleggen<br><br>
                            In veel gevallen zal de specialist u aan het
                            einde van het eerste gesprek een advies
                            geven. Als blijkt dat aanvullende onderzoek
                            noodzakelijk is of er meer gegevens nodig
                            zijn, kan een aanvullende afspraak worden
                            gemaakt.</p>
                    </div>

                    <button id="vraag3a" class="kweeste" onclick="klik3(this.id)">Wordt een second opinion vergoed door uw zorgverzekeraar?</button>
                    <div class="bar" id="vraag3"><p id="vraagje">
                            Hiervoor kunt u het beste contact opnemen
                            met uw eigen zorgverzekeraar of uw
                            zorgpolis checken. De vergoeding is
                            afhankelijk van het soort zorgverzekering dat
                            u heeft afgesloten. Bij de meeste
                            zorgverzekeraars zit de vergoeding voor een
                            second opinion in het basispakket. Sommige
                            budgetpolissen vergoeden dit echter alleen
                            als u verwezen wordt door de specialist en
                            niet door de huisarts.</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
