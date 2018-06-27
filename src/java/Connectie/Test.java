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
public class Test extends HttpServlet {

    private static final String WRONG_NAME = "Username bestaat niet";
    private static final String WRONG_PSSWRD = "Verkeerd wachtwoord";
    private String vNaam;
    private Patient patient;
    private Arts arts;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.sendRedirect("inlog.html");
    }

    // Method to handle POST method request.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        vNaam = request.getParameter("voorNaam");
        String ww = request.getParameter("wachtWoord");
        //Patient patient;
        
        HttpSession session = request.getSession();

        AccountCheck check = new AccountCheck(vNaam, ww);
        if (check.con() == 1) {
            //setPatient(request, response);
           // HttpSession session = request.getSession();
            session.setAttribute("user", vNaam);
            session.setAttribute("beroep", "patient");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30 * 60);
            setPatient(request, response);

            //RequestData data = new RequestData(vNaam);
            //patient = data.getPatientData();
            //setup Cookies
            /*Cookie userName = new Cookie("user", patient.getMail());
            Cookie init = new Cookie("init", patient.getIni());
            Cookie sex = new Cookie("sex", patient.getSex());
            Cookie adres = new Cookie("adres", patient.getAdres());
            Cookie postcode = new Cookie("postcode", patient.getPostcode());
            Cookie plaats = new Cookie("plaats", patient.getPlaats());
            //Cookie wachtwoord = new Cookie("wachtwoord", patient.getWachtwoord());
            //Cookie patientje = new Cookie("patient", patient);
            
            //Geef ze een tijd
            userName.setMaxAge(30 * 60);
            init.setMaxAge(30 * 60);
            sex.setMaxAge(30 * 60);
            adres.setMaxAge(30 * 60);
            postcode.setMaxAge(30 * 60);
            plaats.setMaxAge(30 * 60);
            //wachtwoord.setMaxAge(30 * 60);
            
            //voeg de cookies toe
            response.addCookie(userName);
            response.addCookie(init);
            response.addCookie(sex);
            response.addCookie(adres);
            response.addCookie(postcode);
            response.addCookie(plaats);
            //response.addCookie(wachtwoord);
                       
            //redirect
            response.sendRedirect("Ingelogd.jsp");*/
            //doGet(request, response);
        } else if (check.con() == 2) {
            setArts(request, response);
            //setPatient(request, response);
            
            session.setAttribute("user", vNaam);
            session.setAttribute("beroep", "arts");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30 * 60);

            // RequestData data = new RequestData(vNaam);
            //arts = data.getArtsData(vNaam);
           
        } else if (check.con() == 3) {
            wrong(request, response, WRONG_PSSWRD);
        } else if (check.con() == 4) {
            wrong(request, response, WRONG_NAME);
        }
    }

    private void setPatient(HttpServletRequest request, HttpServletResponse response) {
        RequestData data = new RequestData();
        patient = data.getPatientData(vNaam);

        //setup Cookies
        //Cookie beroep = new Cookie("beroep", "patient");
        Cookie userName = new Cookie("user", patient.getMail());
        Cookie init = new Cookie("init", patient.getIni());
        Cookie sex = new Cookie("sex", patient.getSex());
        Cookie adres = new Cookie("adres", patient.getAdres());
        Cookie postcode = new Cookie("postcode", patient.getPostcode());
        Cookie plaats = new Cookie("plaats", patient.getPlaats());
        //Cookie wachtwoord = new Cookie("wachtwoord", patient.getWachtwoord());
        //Cookie patientje = new Cookie("patient", patient);

        //Geef ze een tijd
        // beroep.setMaxAge(30*60);
        userName.setMaxAge(30 * 60);
        init.setMaxAge(30 * 60);
        sex.setMaxAge(30 * 60);
        adres.setMaxAge(30 * 60);
        postcode.setMaxAge(30 * 60);
        plaats.setMaxAge(30 * 60);
        //wachtwoord.setMaxAge(30 * 60);

        //voeg de cookies toe
        //response.addCookie(beroep);
        response.addCookie(userName);
        response.addCookie(init);
        response.addCookie(sex);
        response.addCookie(adres);
        response.addCookie(postcode);
        response.addCookie(plaats);
        //response.addCookie(wachtwoord);
        try {
            //redirect
            response.sendRedirect("Ingelogd.jsp");
        } catch (IOException ex) {
        }
    }

    private void setArts(HttpServletRequest request, HttpServletResponse response) {
        RequestData data = new RequestData();
        arts = data.getArtsData(vNaam);
        
        Cookie mail = new Cookie("mail", arts.getMail());
        Cookie naam = new Cookie("naam", arts.getNaam());
        
        mail.setMaxAge(30 * 60);
        naam.setMaxAge(30 * 60);
        
        response.addCookie(mail);
        response.addCookie(naam);
        
        try {
            response.sendRedirect("Patienten");
        } catch (IOException ex) {
        }
    }

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
