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
                    <div class="menuKnopLeeg" id="derde">
                    </div>
                    </a>
                    <div class="menuKnopLeeg" id="vierde">
                    </div>
                    </a>		
                </div>

                <div id="content">
                    <p align="center" id="titel">Arts</p>

                    <div id="plaatje">
                        placeholder
                    </div>
                    <div id="Artsinfo">
                        <%=heeftArts%>
                        <table>
                            <tr>
                                <td>
                                    <b>Naam:</b><br>
                                </td>
                                <td>
                                    <%=artsNaam%>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <b>Initialen:</b>
                                </td>
                                <td>
                                    <%=artsIni%>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <b>Specialisme:</b>
                                </td>
                                <td>
                                    <%=artsSpec%>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <b>Email:</b>
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
                <div id="artsPicto" class="pictogram">
                </div>

            </div>


        </div>
    </div>
</body>
</html>