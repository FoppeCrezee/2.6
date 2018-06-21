<%-- 
    Document   : artsGegevens
    Created on : 13-jun-2018, 0:18:03
    Author     : foppe
--%>

<%@page import="Connectie.Arts"%>
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
            if (session.getAttribute("user") == null || session.getAttribute("beroep") != "arts") {
                response.sendRedirect("inlog.html");
            } else {
                user = (String) session.getAttribute("user");
            }
            RequestData data = new RequestData();
            Arts arts = data.getArtsData(user);
            String artsNaam = "";
            String artsMail = "";
            String artsBio = "";
            String artsSpec = "";
            String artsIni = "";
            String heeftArts = "U heeft nog geen behandelend arts";
            if (arts.getNaam() != null) {
                artsNaam = arts.getNaam();
                artsMail = arts.getMail();
                artsBio = arts.getBio();
                artsSpec = arts.getSpec();
                artsIni = arts.getIni();
                heeftArts = "";
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
                    <a href="artsGegevens.jsp">
                        <div class="menuKnopGekozen" id="eerste">
                            <p class="gekozen">Mijn gegevens</p>
                            <div id="driehoek">
                            </div>
                        </div>
                    </a>
                    <a href="Patienten">
                        <div class="menuKnop" id="tweede">
                            <p class="boven">Patient aanvragen</p>
                        </div>
                    </a>
                    <!-- <a href="behandeling.jsp">
                         <div class="menuKnop" id="derde">
                             <p class="boven">Mijn arts</p>
                         </div>
                     </a>
                     <a href="contact.jsp">
                         <div class="menuKnop" id="vierde">
                             <p class="boven">Contact</p>
                         </div>
                     </a>-->			
                </div>

                <div id="content">
                    <p align="center" id="titel">Arts</p>

                    <div id="plaatje">
                        plaatje
                    </div>
                    <div id="Artsinfo">
                        <%=heeftArts%>
                        <table>
                            <tr>
                                <td>
                                    Naam:
                                </td>
                                <td>
                                    <%=artsNaam%>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Initialen:
                                </td>
                                <td>
                                    <%=artsIni%>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Specialisme:
                                </td>
                                <td>
                                    <%=artsSpec%>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Email:
                                </td>
                                <td>
                                    <%=artsMail%>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="biografie">
                        <textarea id="bio" rows="4" cols="50" readonly><%=artsBio%></textarea>

                    </div>
                </div>	

                    <!--<div id="knop4">
                        <input type="submit" class="buttonInlog" value="Wijzigen">
                    </div>
                </form>-->

                    <!--<div id="knop4">
                <a href="Wijzig.jsp"><button class="buttonInlog">Wijzig gegevens</button></a>
            </div>-->

                </div>


            </div>
        </div>
    </body>
</html>