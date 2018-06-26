/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import Data.RequestData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Patienten", urlPatterns = {"/Patienten"})
public class Patienten extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        allPatients(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    protected void allPatients(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        //allow access only if session exists
        String user = null;
        if (session.getAttribute("user") == null || session.getAttribute("beroep") != "arts") {
            response.sendRedirect("inlog.html");
        } else {
            user = (String) session.getAttribute("user");
        }

        String naam = null;
        String mail = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("naam")) {
                    naam = cookie.getValue();
                }
                if (cookie.getName().equals("mail")) {
                    mail = cookie.getValue();
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
                "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "        <title>Second opinion</title>\n"
                + "        <link rel=\"stylesheet\" href=\"Styless.css\"> \n"
                + "        <script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n"
                + "        <script src=\"script.js\"></script>    \n"
                + "    </head>\n"
                + "    <body>\n"
                + "        <div id=\"main\">\n"
                + "            <div id=\"header\" class=\"hoofd\">\n"
                + "                <img src=\"https://www.avl.nl/media/8869707/logo-NL-Antoni-van-Leeuwenhoek_jpeg_grootformaat.jpg\" id=\"avl3\">\n"
                + "                <h1 align=\"center\">Second opinion portaal</h1>\n"
                + "                <div id=\"uitlog\">\n"
                + "                    <form action=\"LogoutServlet\" method=\"post\">\n"
                + "                        <input type=\"submit\" value=\"Uitloggen\" class=\"uitloggen\" >\n"
                + "                    </form>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "\n"
                + "            <div id=\"gegevens2\">\n"
                + "\n"
                + "                <div id=\"menu\">\n"
                + "                    <a href=\"artsGegevens.jsp\">\n"
                + "                        <div class=\"menuKnop\" id=\"eerste\">\n"
                + "                            <p class=\"boven\">Mijn gegevens</p>\n"
                + "                            \n"
                + "                        </div>\n"
                + "                    </a>\n"
                + "                    <a href=\"Patienten\">\n"
                + "                        <div class=\"menuKnopGekozen\" id=\"tweede\">\n"
                + "                            <p class=\"gekozen\">Patient aanvragen</p>\n"
                + "                            <div id=\"driehoek\">\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </a>\n"
               // + "                   <a href=\"behandeling.jsp\">\n"
                + "                        <div class=\"menuKnopLeeg\" id=\"derde\">\n"
                //+ "                            <p class=\"boven\">Mijn arts</p>\n"
                + "                        </div>\n"
                //+ "                    </a>\n"
                //+ "                    <a href=\"contact.jsp\">\n"
                + "                        <div class=\"menuKnopLeeg\" id=\"vierde\">\n"
                //+ "                            <p class=\"boven\">Contact</p>\n"
                + "                        </div>\n"
               // + "                    </a>			\n"
                + "                </div>\n"
                + "\n"
                + "                <div id=\"content\">\n"
                + "                    <p align=\"center\" id=\"titel\">Gegevens</p>\n"
                + "                        <table class=\"data\">\n"
                + "\n"
                + getPatienten()
                + "\n"
                + "                        </table>	\n"
                + "\n"
                + "                        <!--<div id=\"knop4\">\n"
                + "                            <input type=\"submit\" class=\"buttonInlog\" value=\"Wijzigen\">\n"
                + "                        </div>\n"
                + "                    </form>-->\n"
                + "                        \n"
                + "                        <!--<div id=\"knop4\">\n"
                + "                    <a href=\"Wijzig.jsp\"><button class=\"buttonInlog\">Wijzig gegevens</button></a>\n"
                + "                </div>-->\n"
                + "\n"
                + "                </div>\n"
                + "\n"
                + "\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </body>\n"
                + "</html>");
    }

    private String getPatienten() {

        String allemaal = "";

        RequestData data = new RequestData();
        ArrayList<Patient> lijst = new ArrayList<Patient>();
        lijst = data.getPatienten();
        for (Patient patient : lijst) {
            allemaal = allemaal
                    + /*+ "<tr>\n"
                    + "						<td>\n"
                    + "							<a href=\"PatientInfoServlet\">" + patient.getMail() + "</a>\n"
                    + "						</td>\n"
                    + "					</tr>";*/ "<form action=\"PatientInfoServlet\" method=\"post\">\n"
                    + "								<tr>\n"
                    + "									<td>\n"
                    + "										<input id=\"veld\" type=\"text\" value=\"" + patient.getMail() + "\" name=\"mail\" readonly>\n"
                    + "									</td>\n"
                    + "									<td>\n"
                    + "										<input id=\"rij\" type=\"submit\" class=\"buttonInlog\" value=\"Meer gegevens\">\n"
                    + "									</td>\n"
                    + "								</tr>\n"
                    + "							</form>";

        }
        if (allemaal.equals("")) {
            return "Geen patienten gevonden";
        } else {
            return allemaal;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
