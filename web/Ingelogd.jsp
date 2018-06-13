<%-- 
    Document   : Ingelogd
    Created on : 8-jun-2018, 12:11:24
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

            String userName = null;
            String sessionID = null;
            String ini = null;
            String sex = null;
            String postcode = null;
            String plaats = null;
            String adres = null;
            
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                    if (cookie.getName().equals("init")) {
                        ini = cookie.getValue();
                    }
                    if (cookie.getName().equals("sex")) {
                        sex = cookie.getValue();
                    }
                    if (cookie.getName().equals("adres")) {
                        adres = cookie.getValue();
                    }
                    if (cookie.getName().equals("postcode")) {
                        postcode = cookie.getValue();
                    }
                    if (cookie.getName().equals("plaats")) {
                        plaats = cookie.getValue();
                    }
                }
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
                            <p class="boven">Mijn arts</p>
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
                        <table class="data">

                            <tr>
                                <td>
                                    <p>Mail:</p>
                                </td>
                                <td>
                                    <input id=“Naam” name="vNaam" value="<%=userName%>" type="text"  readonly>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Initialen:</p>
                                </td>
                                <td>
                                    <input id=“Naam” name="ww" value="<%=ini%>" type="text"   readonly>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Geslacht:</p>
                                </td>
                                <td>
                                    <input id=“Naam” name="ww" value="<%=sex%>" type="text"  readonly>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Adres:</p>
                                </td>
                                <td>
                                    <input id=“Naam” name="ww" value="<%=adres%>" type="text"   readonly>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Postcode:</p>
                                </td>
                                <td>
                                    <input id=“Naam” name="ww" value="<%=postcode%>" type="text" readonly>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Plaats:</p>
                                </td>
                                <td>
                                    <input id=“Naam” name="ww" value="<%=plaats%>" type="text" readonly>
                                </td>
                            </tr>


                        </table>	

                        <!--<div id="knop4">
                            <input type="submit" class="buttonInlog" value="Wijzigen">
                        </div>
                    </form>-->
                        
                        <div id="knop4">
                    <a href="Wijzig.jsp"><button class="buttonInlog">Wijzig gegevens</button></a>
                </div>

                </div>


            </div>
        </div>
    </body>
</html>

