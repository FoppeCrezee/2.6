<%-- 
    Document   : Ingelogd
    Created on : 8-jun-2018, 12:11:24
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
                    <table align="center">


                        <tr>
                            <td>
                                <p>Naam:</p>
                            </td>
                            <td>
                                <input id="veld" name="vNaam" value="<%=naam%>" type="text"  readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Initialen:</p>
                            </td>
                            <td>
                                <input id="veld" name="ww" value="<%=ini%>" type="text"   readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>BSN:</p>
                            </td>
                            <td>
                                <input id="veld" name="vNaam" value="<%=bsn%>" type="text"  readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Geslacht:</p>
                            </td>
                            <td>
                                <input id="veld" name="ww" value="<%=sex%>" type="text"  readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Adres:</p>
                            </td>
                            <td>
                                <input id="veld" name="ww" value="<%=adres%>" type="text"   readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Huisnummer/ toevoeging:</p>
                            </td>
                            <td>
                                <input id=“Naam” type="text" class="nr2" name="nu" value="<%=huisNummer%>" readonly>
                                <input id=“Naam” type="text" class="tv2" name="toevoeging" value="<%=toev%>" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Postcode:</p>
                            </td>
                            <td>
                                <input id="veld" name="ww" value="<%=postcode%>" type="text" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Plaats:</p>
                            </td>
                            <td>
                                <input id="veld" name="ww" value="<%=plaats%>" type="text" readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Telefoonnummer:</p>
                            </td>
                            <td>
                                <input id="veld" name="vNaam" value="<%=tel%>" type="text"  readonly>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Mail:</p>
                            </td>
                            <td>
                                <input id="veld" name="vNaam" value="<%=mail%>" type="text"  readonly>
                            </td>
                        </tr>


                    </table>	

                    <div align="center" id="knop4">
                        <a href="Wijzig.jsp"><button class="buttonInlog">Wijzig gegevens</button></a>
                    </div>

                </div>
                <div id="patientPicto" class="pictogram">
                </div>

            </div>
        </div>
    </body>
</html>

