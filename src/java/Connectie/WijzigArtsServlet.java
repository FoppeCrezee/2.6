/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import Data.ChangeData;
import Data.RequestData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author foppe
 */
@WebServlet(name = "WijzigArtsServlet", urlPatterns = {"/WijzigArtsServlet"})
public class WijzigArtsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        //allow access only if session exists
        String user = null;
        if (session.getAttribute("user") == null || session.getAttribute("beroep") != "arts") {
            response.sendRedirect("inlog.html");
        } else {
            user = (String) session.getAttribute("user");
        }

        RequestData data = new RequestData();
        Arts arts = data.getArtsData(user);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>\n"
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
                    + "            <div id=\"gegevens2\">\n"
                    + "                <div id=\"menu\">\n"
                    + "                    <a href=\"Patienten\">\n"
                    + "                        <div class=\"menuKnop\" id=\"tweede\">\n"
                    + "                            <p class=\"boven\">Patient aanvragen</p>\n"
                    + "                        </div>\n"
                    + "                    </a>\n"
                    + "                    <a href=\"artsGegevens.jsp\">\n"
                    + "                        <div class=\"menuKnop\" id=\"eerste\">\n"
                    + "                            <p class=\"boven\">Mijn gegevens</p>\n"
                    + "                            \n"
                    + "                        </div>\n"
                    + "                    </a>\n"
                    + "                     <a href=\"WijzigArtsServlet\">\n"
                    + "                        <div class=\"menuKnopGekozen\" id=\"derde\">\n"
                    + "                            <p class=\"gekozen\">Wijzig mijn gegevens</p>\n"
                    + "                            <div id=\"driehoek\">\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                    </a>"
                    + "                        <div class=\"menuKnopLeeg\" id=\"vierde\">\n"
                    + "                        </div>\n"
                    + "                </div>\n"
                    + "                <div id=\"content\">\n"
                    + "                    <p align=\"center\" id=\"titel\">Wijzig gegevens</p>\n"
                    + "                                <div id=\"plaatjeWijzig\">\n"
                    + "                                    placeholder\n"
                    + "                                </div>\n"
                    + "                                 <form action=\"WijzigArtsServlet\" method=\"GET\">\n"
                    + "                                <div id=\"ArtsinfoWijzig\">\n"
                    + "                                    <table>\n"
                    + "                                        <tr>\n"
                    + "                                            <td>\n"
                    + "                                                <b>Naam:</b><br>\n"
                    + "                                            </td>\n"
                    + "                                            <td>\n"
                    + "                                             <input type=\"text\" class=\"input\" name=\"artsNaam\" value=\"" + arts.getNaam() + "\">"
                    + "                                            </td>\n"
                    + "                                        </tr>\n"
                    + "                                        <tr>\n"
                    + "                                            <td>\n"
                    + "                                                <b>Initialen:</b>\n"
                    + "                                            </td>\n"
                    + "                                            <td>\n"
                    + "                                             <input type=\"text\" class=\"input\" name=\"artsIni\" value=\"" + arts.getIni() + "\">"
                    + "                                            </td>\n"
                    + "                                        </tr>\n"
                    + "                                        <tr>\n"
                    + "                                            <td>\n"
                    + "                                                <b>Specialisme:</b>\n"
                    + "                                            </td>\n"
                    + "                                            <td>\n"
                    + "                                             <input type=\"text\" class=\"input\" name=\"artsSpec\" value=\"" + arts.getSpec() + "\">"
                    + "                                            </td>\n"
                    + "                                        </tr>\n"
                    + "                                    </table>\n"
                    + "                                </div>\n"
                    + "                                <div id=\"biografieWijzig\">\n"
                    + "                                    <textarea id=\"bio\" rows=\"4\" name=\"artsBio\" cols=\"50\">" + arts.getBio() + "</textarea>\n"
                    + "                                </div>"
                    + "                                             <div id=\"knop8\">"
                    + "  						<input type=\"submit\" class=\"button\" value=\"Bevestigen\">\n"
                    + "                                             </div"
                    + "						</form>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>");
        }
    }

    /**
     * Vraagt de gegevens op van de arts als ze gewijzigd zijn
     * En wijzigt deze in de database
     * 
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
        HttpSession session = request.getSession();
        String mail = (String) session.getAttribute("user");
        String naam = request.getParameter("artsNaam");
        String ini = request.getParameter("artsIni");
        String spec = request.getParameter("artsSpec");
        String bio = request.getParameter("artsBio");
        ChangeData data = new ChangeData();
        data.changeArts(mail, naam, ini, spec, bio);
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
