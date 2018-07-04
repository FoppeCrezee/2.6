/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import Data.RequestData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author foppe
 */
@WebServlet(name = "Test", urlPatterns = {"/Test"})
public class Main extends HttpServlet {

    private static final String WRONG_NAME = "Username of wachtwoord is verkeerd";
    private static final String WRONG_PSSWRD = "Username of wachtwoord is verkeerd";
    private String vNaam;
    private Patient patient;
    private Arts arts;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.sendRedirect("inlog.html");
    }

    //Handeld de user inlog aanvraag
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        vNaam = request.getParameter("voorNaam");
        String ww = request.getParameter("wachtWoord");
        
        HttpSession session = request.getSession();

        AccountCheck check = new AccountCheck(vNaam, ww);
        if (check.con() == AccountCheck.GELUKT_PATIENT) {
            session.setAttribute("user", vNaam);
            session.setAttribute("beroep", "patient");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval((Patienten.MINUTEN/2) * Patienten.SECONDEN);
            setPatient(request, response);
        } else if (check.con() == AccountCheck.GELUKT_ARTS) {
            setArts(request, response);
            
            session.setAttribute("user", vNaam);
            session.setAttribute("beroep", "arts");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval((Patienten.MINUTEN/2) * Patienten.SECONDEN);
           
        } else if (check.con() == AccountCheck.VERKEERD_WW) {
            wrong(request, response, WRONG_PSSWRD);
        } else if (check.con() == AccountCheck.VERKEERD_NAAM) {
            wrong(request, response, WRONG_NAME);
        }
    }

    /**
     * Maakt de sessie van de patient aan
     */
    private void setPatient(HttpServletRequest request, HttpServletResponse response) {
        RequestData data = new RequestData();
        patient = data.getPatientData(vNaam);

        //setup Cookies
        Cookie userName = new Cookie("user", patient.getMail());
        Cookie init = new Cookie("init", patient.getIni());
        Cookie sex = new Cookie("sex", patient.getSex());
        Cookie adres = new Cookie("adres", patient.getAdres());
        Cookie postcode = new Cookie("postcode", patient.getPostcode());
        Cookie plaats = new Cookie("plaats", patient.getPlaats());

        //Geef ze een tijd
        userName.setMaxAge((Patienten.SECONDEN/2) * Patienten.MINUTEN);
        init.setMaxAge((Patienten.SECONDEN/2) * Patienten.MINUTEN);
        sex.setMaxAge((Patienten.SECONDEN/2) * Patienten.MINUTEN);
        adres.setMaxAge((Patienten.SECONDEN/2) * Patienten.MINUTEN);
        postcode.setMaxAge((Patienten.SECONDEN/2) * Patienten.MINUTEN);
        plaats.setMaxAge((Patienten.SECONDEN/2) * Patienten.MINUTEN);

        //voeg de cookies toe
        response.addCookie(userName);
        response.addCookie(init);
        response.addCookie(sex);
        response.addCookie(adres);
        response.addCookie(postcode);
        response.addCookie(plaats);
        try {
            //redirect
            response.sendRedirect("Ingelogd.jsp");
        } catch (IOException ex) {
        }
    }

    /**
     * Maakt de sessie van de arts aan
     */
    private void setArts(HttpServletRequest request, HttpServletResponse response) {
        RequestData data = new RequestData();
        arts = data.getArtsData(vNaam);
        
        Cookie mail = new Cookie("mail", arts.getMail());
        Cookie naam = new Cookie("naam", arts.getNaam());
        
        mail.setMaxAge((Patienten.SECONDEN /2) * Patienten.MINUTEN);
        naam.setMaxAge((Patienten.SECONDEN /2) * Patienten.MINUTEN);
        
        response.addCookie(mail);
        response.addCookie(naam);
        
        try {
            response.sendRedirect("Patienten");
        } catch (IOException ex) {
        }
    }

    /**
     * Laat de pagina zien of het inloggen is gelukt.
     * @param request is de request
     * @param response is de response die de gebruiker te zien krijgt
     * @param message is het bericht wat er niet gelukt is
     * @throws ServletException
     * @throws IOException
     */
    public void wrong(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
                "<html>\n"
                + "    <head>\n"
                + "        <title>Second opinion</title>\n"
                + "        <link rel=\"stylesheet\" href=\"Styless.css\"> \n"
                + "        <script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n"
                + "        <script src=\"script.js\"></script>    \n"
                + "    </head>\n"
                + "    <body>\n"
                + "        \n"
                + "        <div id=\"main\">\n"
                + "            <div id=\"header\" class=\"hoofd\">\n"
                + "            <h1>Secondopinion.nl</h1>\n"
                + "				<h2>Inloggen</h2>\n"
                + "		\n"
                + "            </div>\n"
                + "          \n"
                + "            <div id=\"gegevens\">\n"
                + "                <form id=\"Inloggen\" action=\"Test\" method=\"POST\">\n"
                + "				<table class=\"inlog\">\n"
                + "				\n"
                + "					<tr>\n"
                + "						<td style=\"width: 380px;\">\n"
                + "							<p>Naam:</p>\n"
                + "							<input id=“voorNaam” type=\"text\" name=\"voorNaam\" class=\"Name\">\n"
                + "						</td>\n"
                + "						<td>\n"
                + "							<p>Wachtwoord:</p>\n"
                + "							<input id=“wachtWoord” type=\"password\" name=\"wachtWoord\" class=\"Name\">\n"
                + "						</td>\n"
                + "					</tr>\n"
                + "                                     <tr>\n"
                + "						<td colspan=\"2\">\n"
                + "							<p id=\"verkeerd\">" + message + "</p>\n"
                + "						</td>\n"
                + "					</tr>\n"
                + "				</table>\n"
                + "				\n"
                + "				<div id=\"knop6\">\n"
                + "					<input type=\"submit\" value=\"Inloggen\" class=\"buttonInlog\">\n"
                + "				</div>\n"
                + "		</form>\n"
                + "                <img src=\"https://www.avl.nl/media/8869707/logo-NL-Antoni-van-Leeuwenhoek_jpeg_grootformaat.jpg\" id=\"avl\">\n"
                + "            </div>\n"
                + "        </div>\n"
                + "           \n"
                + "        \n"
                + "    </body>\n"
                + "\n"
                + "</html>"
        );
    }

}
