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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author foppe
 */
@WebServlet(name = "PatientInfoServlet", urlPatterns = {"/PatientInfoServlet"})
public class PatientInfoServlet extends HttpServlet {

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

        String naam = request.getParameter("mail");
        RequestData data = new RequestData();
        Patient patient = data.getPatientData(naam);
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
                    + "\n"
                    + "            <div id=\"gegevens2\">\n"
                    + "\n"
                    + "\n"
                    + "                <div id=\"content\">\n"
                    + "                    <p align=\"center\" id=\"titel\">Gegevens</p>\n"
                    + "                        <table class=\"data\">\n"
                    + "\n"
                    + "                            <tr>\n"
                    + "                                <td>\n"
                    + "                                    <p>Achternaam:</p>\n"
                    + "                                </td>\n"
                    + "                                <td>\n"
                    + "                                    <input id=“Naam” name=\"vNaam\" value=\"" + patient.getNaam() + "\" type=\"text\"  readonly>\n"
                    + "                                </td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td>\n"
                    + "                                    <p>Mail:</p>\n"
                    + "                                </td>\n"
                    + "                                <td>\n"
                    + "                                    <input id=“Naam” name=\"vNaam\" value=\"" + patient.getMail() + "\" type=\"text\"  readonly>\n"
                    + "                                </td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td>\n"
                    + "                                    <p>Initialen:</p>\n"
                    + "                                </td>\n"
                    + "                                <td>\n"
                    + "                                    <input id=“Naam” name=\"ww\" value=\"" + patient.getIni() + "\" type=\"text\"   readonly>\n"
                    + "                                </td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td>\n"
                    + "                                    <p>Geslacht:</p>\n"
                    + "                                </td>\n"
                    + "                                <td>\n"
                    + "                                    <input id=“Naam” name=\"ww\" value=\"" + patient.getSex() + "\" type=\"text\"  readonly>\n"
                    + "                                </td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td>\n"
                    + "                                    <p>BSN:</p>\n"
                    + "                                </td>\n"
                    + "                                <td>\n"
                    + "                                    <input id=“Naam” name=\"vNaam\" value=\"" + patient.getBSN() + "\" type=\"text\"  readonly>\n"
                    + "                                </td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td>\n"
                    + "                                    <p>GeboorteDatum:</p>\n"
                    + "                                </td>\n"
                    + "                                <td>\n"
                    + "                                    <input id=“Naam” name=\"vNaam\" value=\"" + patient.getDatum() + "\" type=\"date\"  readonly>\n"
                    + "                                </td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td>\n"
                    + "                                    <p>Telefoonnummer:</p>\n"
                    + "                                </td>\n"
                    + "                                <td>\n"
                    + "                                    <input id=“Naam” name=\"vNaam\" value=\"" + patient.getTelNummer() + "\" type=\"text\"  readonly>\n"
                    + "                                </td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td>\n"
                    + "                                    <p>Adres:</p>\n"
                    + "                                </td>\n"
                    + "                                <td>\n"
                    + "                                    <input id=“Naam” name=\"ww\" value=\"" + patient.getAdres() + "\" type=\"text\"   readonly>\n"
                    + "                                </td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                            <td>\n"
                    + "                                <p>Huisnummer/ toevoeging:</p>\n"
                    + "                            </td>\n"
                    + "                            <td>\n"
                    + "                                <input id=“Naam” type=\"text\" class=\"nr\" name=\"nu\" value=\"" + patient.getHuisNummer() + "\" readonly>\n"
                    + "                                <input id=“Naam” type=\"text\" class=\"tv\" name=\"toevoeging\" value=\"" + patient.getToevoeging() + "\" readonly>\n"
                    + "                            </td>\n"
                    + "                        </tr>"
                    + "                            <tr>\n"
                    + "                                <td>\n"
                    + "                                    <p>Postcode:</p>\n"
                    + "                                </td>\n"
                    + "                                <td>\n"
                    + "                                    <input id=“Naam” name=\"ww\" value=\"" + patient.getPostcode() + "\" type=\"text\" readonly>\n"
                    + "                                </td>\n"
                    + "                            </tr>\n"
                    + "                            <tr>\n"
                    + "                                <td>\n"
                    + "                                    <p>Plaats:</p>\n"
                    + "                                </td>\n"
                    + "                                <td>\n"
                    + "                                    <input id=“Naam” name=\"ww\" value=\"" + patient.getPlaats() + "\" type=\"text\" readonly>\n"
                    + "                                </td>\n"
                    + "                            </tr>\n"
                    + "\n"
                    + "\n"
                    + "                        </table>	\n"
                    + "\n"
                    + "                </div>\n"
                    + "\n"
                    + "\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>");
        }
    }

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
    }// </editor-fold>

}