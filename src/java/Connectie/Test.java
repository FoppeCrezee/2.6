/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.sendRedirect("inlog.html");
        /*response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Nieuwe gebruiker";
        String docType
                = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";

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
                + "				<img src=\"https://www.avl.nl/media/8869707/logo-NL-Antoni-van-Leeuwenhoek_jpeg_grootformaat.jpg\" id=\"avl3\">\n"
                + "            <h1 align=\"center\">Second opinion portaal</h1>\n"
                + "				<div id=\"uitlog\">\n"
                + "					<a href=\"Home.html\"><button class=\"uitloggen\">Uitloggen</button></a>\n"
                + "				</div>\n"
                + "            </div>\n"
                + "          \n"
                + "            <div id=\"gegevens2\">\n"
                + "           \n"
                + "				<div id=\"menu\">\n"
                + "					<a href=\"gegevens.html\">\n"
                + "						<div class=\"menuKnopGekozen\" id=\"eerste\">\n"
                + "							<p class=\"gekozen\">Mijn gegevens</p>\n"
                + "							<div id=\"driehoek\">\n"
                + "							</div>\n"
                + "						</div>\n"
                + "					</a>\n"
                + "					<a href=\"aanvraag.html\">\n"
                + "						<div class=\"menuKnop\" id=\"tweede\">\n"
                + "							<p class=\"boven\">Mijn aanvraag</p>\n"
                + "						</div>\n"
                + "					</a>\n"
                + "					<a href=\"behandeling.html\">\n"
                + "						<div class=\"menuKnop\" id=\"derde\">\n"
                + "							<p class=\"boven\">Mijn arts</p>\n"
                + "						</div>\n"
                + "					</a>\n"
                + "					<a href=\"contact.html\">\n"
                + "						<div class=\"menuKnop\" id=\"vierde\">\n"
                + "							<p class=\"boven\">Contact</p>\n"
                + "						</div>\n"
                + "					</a>			\n"
                + "				</div>\n"
                + "				<div id=\"content\">\n"
                + "					<p align=\"center\" id=\"titel\">Gegevens</p>\n"
                + "                                       <p>Naam:" + request.getParameter("voorNaam") + "</p>         \n"
                + "                                       <p>Naam:" + request.getParameter("wachtWoord") + "</p>         \n"
                + "				</div>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "     </body>\n"
                + "</html>\n"
        );*/
    }

    // Method to handle POST method request.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vNaam = request.getParameter("voorNaam");
        String ww = request.getParameter("wachtWoord");

        /* String query = "INSERT into ding (een, twee)" + " values (?,?);";
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "Foppe");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            con = DriverManager.getConnection(url, info);
            PreparedStatement pst = null;
        } catch (Exception ex) {
            System.out.println("geen connectie: ");
        }*/
        //Insert add = new Insert("String", "strinf");
        AccountCheck check = new AccountCheck(vNaam, ww);
        if (check.con() == 1) {

            HttpSession session = request.getSession();
            session.setAttribute("user", "Pankaj");
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30 * 60);
            Cookie userName = new Cookie("user", vNaam);
            userName.setMaxAge(30 * 60);
            response.addCookie(userName);
            response.sendRedirect("Ingelogd.jsp");

            //doGet(request, response);
        } else if (check.con() == 2) {
            wrong(request, response, WRONG_PSSWRD);
        } else if (check.con() == 3) {
            wrong(request, response, WRONG_NAME);
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
                + "            <form id=\"Inloggen\">\n"
                + "				<table class=\"inlog\">\n"
                + "				\n"
                + "					<tr>\n"
                + "						<td>\n"
                + "							<p>Naam:</p>\n"
                + "							<input id=“Naam” type=\"text\" class=\"Name\" onfocus=\"vrij(this, default_value_nummer) \"onfocusout=\"nummer(this)\">\n"
                + "						</td>\n"
                + "						<td>\n"
                + "							<p>Wachtwoord:</p>\n"
                + "							<input id=“Naam” type=\"password\" class=\"Name\" onfocus=\"vrij(this, default_value_nummer) \"onfocusout=\"nummer(this)\">\n"
                + "						</td>\n"
                + "					</tr>\n"
                + "					<tr>\n"
                + "						<td colspan=\"2\">\n"
                + "							<p id=\"verkeerd\">" + message + "</p>\n"
                + "						</td>\n"
                + "					</tr>\n"
                + "					\n"
                + "				</table>\n"
                + "				\n"
                + "				<div id=\"knop4\">\n"
                + "					<input type=\"submit\" class=\"buttonInlog\">\n"
                + "				</div>\n"
                + "			</form>\n"
                + "				<a href=\"gegevens.html\">inlog</a>\n"
                + "                <img src=\"https://www.avl.nl/media/8869707/logo-NL-Antoni-van-Leeuwenhoek_jpeg_grootformaat.jpg\" id=\"avl\">\n"
                + "            </div>\n"
                + "        </div>\n"
                + "           \n"
                + "        \n"
                + "    </body>\n"
                + "\n"
                + "</html>");
    }

}
