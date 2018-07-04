<%-- 
    Document   : Wijzig
    Created on : 12-jun-2018, 15:34:01
    Author     : foppe
--%>

<%@page import="Connectie.Patient"%>
<%@page import="Data.RequestData"%>
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
            RequestData data = new RequestData();
            Patient patient = data.getPatientData(user);

            String userName = patient.getMail();

            String mail = patient.getMail();
            String naam = patient.getNaam();
            String ini = patient.getIni();
            String sex = patient.getSex();
            String postcode = patient.getPostcode();
            String plaats = patient.getPlaats();
            String adres = patient.getAdres();
            int huisNummer = patient.getHuisNummer();
            long tel = patient.getTelNummer();
            String toev = patient.getToevoeging();
            int bsn = patient.getBSN();
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
                        <div class="menuKnopGekozen" id="eerste">
                            <p class="gekozen">Mijn gegevens</p>
                            <div id="driehoek">
                            </div>
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
                        <div class="menuKnop" id="vierde">
                            <p class="boven">Contact</p>
                        </div>
                    </a>			
                </div>

                <div id="content">
                    <p align="center" id="titel">Gegevens</p>
                    <form id="Wijzigen gegevens"  action="WijzigServlet" method="post">
                        <table align="center">

                            <tr>
                                <td>
                                    <p>Naam:</p>
                                </td>
                                <td>
                                    <input id="veld" name="vNaam" value="<%=naam%>" type="text"  onfocusout= "naam(this, mailReg)">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Initialen:</p>
                                </td>
                                <td>
                                    <input id="veld" name="ini" value="<%=ini%>" type="text"  onfocusout= "naam(this, initReg)">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>BSN:</p>
                                </td>
                                <td>
                                    <input id="veld" name="bsn" value="<%=bsn%>" type="text"  onfocusout= "naam(this, bsnReg)">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Geslacht:</p>
                                </td>
                                <td>
                                    <select name="sex" value>
                                        <option selected>man</option>
                                        <option>vrouw</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Adres:</p>
                                </td>
                                <td>
                                    <input id="veld" name="adres" value="<%=adres%>" type="text" onfocusout= "naam(this, initReg)">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Huisnummer/ toevoeging:</p>
                                </td>
                                <td>
                                    <input id="Naam"  type="text" class="nr2" name="nummer" value="<%=huisNummer%>" onfocusout= "naam(this, numReg)">
                                    <input id="Naam" type="text" class="tv2" name="toevoeging" value="<%=toev%>">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Postcode:</p>
                                </td>
                                <td>
                                    <input id="veld" name="postcode" value="<%=postcode%>" type="text" onfocusout= "naam(this, postReg)">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Plaats:</p>
                                </td>
                                <td>
                                    <input id="veld" name="plaats" value="<%=plaats%>" type="text" onfocusout= "naam(this, naamReg)">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Telefoonnummer:</p>
                                </td>
                                <td>
                                    <input id="veld" name="tel" value="<%=tel%>" type="text" onfocusout= "naam(this, telReg)">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Mail:</p>
                                </td>
                                <td>
                                    <input id="veld" name="mail" value="<%=mail%>" type="text" readonly>
                                </td>
                            </tr>
                            <div id="knop7">
                                <input type="submit" class="buttonInlog" value="Wijzigen">
                            </div>
                            <div align="center" id="knop5">
                                <a href="Ingelogd.jsp"><button class="buttonInlog">Annuleren</button></a>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>


