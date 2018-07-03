<%-- 
    Document   : behandeling
    Created on : 8-jun-2018, 12:40:39
    Author     : foppe
--%>

<%@page import="Connectie.BehandelTeam"%>
<%@page import="Connectie.Arts"%>
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
//            Arts arts = data.getArtsData(patient.getArts());
//            String artsNaam = "";
//            String artsBio = "";
//            String artsSpec = "";
//            String artsIni = "";
//            String heeftArts = "U heeft nog geen behandelend arts";
//            if (arts.getNaam() != null) {
//                artsNaam = arts.getNaam();
//                artsBio = arts.getBio();
//                artsSpec = arts.getSpec();
//                artsIni = arts.getIni();
//                heeftArts = "";
//            }
            BehandelTeam team = new BehandelTeam(patient.getBehandelTeam());

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
                        <div class="menuKnopGekozen" id="derde">
                            <p class="gekozen">Mijn second <br>opinion team</p>
                            <div id="driehoek">
                            </div>
                        </div>
                    </a>
                    <a href="contact.jsp">
                        <div class="menuKnop" id="vierde">
                            <p class="boven">Contact</p>
                        </div>
                    </a>			
                </div>
                <div id="content">
                    <p align="center" id="titel">Second opnion team</p>

                    <table id="tableGegevens">
                        <tr>
                            <td>
                                <div id="plaatje">
                                    placeholder
                                </div>
                                <div id="Artsinfo">
                                    <%--<%=heeftArts%>--%>
                                    <table>
                                        <tr>
                                            <td>
                                                <b>Naam:</b><br>
                                            </td>
                                            <td>
                                                <%=team.getArts1().getNaam()%>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <b>Initialen:</b>
                                            </td>
                                            <td>
                                                <%=team.getArts1().getIni() %>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <b>Specialisme:</b>
                                            </td>
                                            <td>
                                                <%=team.getArts1().getSpec() %>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div id="biografie">
                                    <textarea id="bio" rows="4" cols="50" readonly><%=team.getArts1().getBio() %></textarea>
                                </div>
                            </td>
                            <td>
                                <div id="plaatje">
                                    placeholder
                                </div>
                                <div id="Artsinfo">
                                    <%--<%=heeftArts%>--%>
                                    <table>
                                        <tr>
                                            <td>
                                                <b>Naam:</b><br>
                                            </td>
                                            <td>
                                                <%=team.getArts2().getNaam()%>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <b>Initialen:</b>
                                            </td>
                                            <td>
                                                <%=team.getArts2().getIni() %>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <b>Specialisme:</b>
                                            </td>
                                            <td>
                                                <%=team.getArts2().getSpec() %>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div id="biografie">
                                    <textarea id="bio" rows="4" cols="50" readonly><%=team.getArts2().getBio() %></textarea>
                                </div>
                            </td>
                            <td>
                                <div id="plaatje">
                                    placeholder
                                </div>
                                <div id="Artsinfo">
                                    <%--<%= //heeftArts%>--%>
                                    <table>
                                        <tr>
                                            <td>
                                                <b>Naam:</b><br>
                                            </td>
                                            <td>
                                                <%=team.getArts3().getNaam()%>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <b>Initialen:</b>
                                            </td>
                                            <td>
                                                <%=team.getArts3().getIni() %>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <b>Specialisme:</b>
                                            </td>
                                            <td>
                                                <%=team.getArts3().getSpec() %>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div id="biografie">
                                    <textarea id="bio" rows="4" cols="50" readonly><%=team.getArts3().getBio() %></textarea>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
                <div id="artsPicto" class="pictogram">
                </div>
            </div>
        </div>
    </body>
</html>
