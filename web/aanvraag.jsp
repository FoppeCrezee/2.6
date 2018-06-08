<%-- 
    Document   : aanvraag
    Created on : 8-jun-2018, 12:42:57
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
        
        <div id="main">
            <div id="header" class="hoofd">
				<img src="https://www.avl.nl/media/8869707/logo-NL-Antoni-van-Leeuwenhoek_jpeg_grootformaat.jpg" id="avl3">
            <h1 align="center">Second opinion portaal</h1>
				<div id="uitlog">
					<a href="Home.html"><button class="uitloggen">Uitloggen</button></a>
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
				</div>
            </div>
        </div>
     </body>
</html>
