<%-- 
    Document   : aanvraag
    Created on : 8-jun-2018, 12:42:57
    Author     : foppe
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Connectie.Toelichting"%>
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
            String userName = null;
            String sessionID = null;
            Patient patient;
            int stadium;
            String toelichting = null;
            
            
            RequestData data = new RequestData();
            
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            patient = data.getPatientData(userName);
            
            String tijd0 = dateFormat.format(patient.getTijd0());
            
            String tijd1 = "";
            if(patient.getTijd1() != null){
                tijd1 = dateFormat.format(patient.getTijd1());
            }
            String tijd2 = "";
            if(patient.getTijd2() != null){
                tijd2 = dateFormat.format(patient.getTijd2());
            }
            String tijd3 = "";
            if(patient.getTijd3() != null){
                tijd3 = dateFormat.format(patient.getTijd3());
            }
            String tijd4 = "";
            if(patient.getTijd4() != null){
                tijd4 = dateFormat.format(patient.getTijd4());
            }
  
            stadium = patient.getStadium();
            Toelichting deToelichting = new Toelichting(stadium);
            toelichting = deToelichting.getToelichting();
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
                        <div class="menuKnopGekozen" id="tweede">
                            <p class="gekozen">Mijn aanvraag</p>
                            <div id="driehoek">
                            </div>
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
                    <p align="center" id="titel">Aanvraag</p>
                    <img src="pictures/stadium<%=stadium%>.png" class="stadium" >
                    <div class="tijd">
                        <%=tijd0%>
                    </div>
                    <div class="tijd" id="tijd1">
                        <%=tijd1%>
                    </div>
                    <div class="tijd" id="tijd2">
                        <%=tijd2%>
                    </div>
                    <div class="tijd" id="tijd3">
                        <%=tijd3%>
                    </div>
                    <div class="tijd" id="tijd4">
                        <%=tijd4%>
                    </div>
                    <div id="toelichting">
                        <br>
                        <b>Toelichting:</b><br><br>
                        <%=toelichting%>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
