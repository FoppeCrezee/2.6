/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import Data.AddData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author foppe
 */
@WebServlet(name = "registerservlet", urlPatterns = {"/registerservlet"})
public class registerServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
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
        int geweest = 0;
        String naam = request.getParameter("na");
        String ini = request.getParameter("ini");
        String geslacht = request.getParameter("sex");
        String datum = request.getParameter("datum");
        String adres = request.getParameter("adres");
        String huis_num = request.getParameter("nu");
        int num = Integer.parseInt(huis_num);
        String toevoeging = request.getParameter("toevoeging");
        String postcode = request.getParameter("postCode");
        String plaats = request.getParameter("plaats");
        String tel_nummer = request.getParameter("teli");
        int tel = Integer.parseInt(tel_nummer);
        String mail = request.getParameter("madres");
        String bsn = request.getParameter("bsNummer");
        int bSN = Integer.parseInt(bsn);
        String avl_geweest = request.getParameter("geweest");
        String ww = request.getParameter("ww");
        //String toestemming = request.getParameter("toestemming");
        String hZiekenhuis = request.getParameter("hZiekenhuis");
        String hBehandelaar = request.getParameter("hBehandelaar");
        String verdenkking = request.getParameter("verdenking");

        if (avl_geweest.equals("on")) {
            geweest = 1;
        }
        int done = 0;

        AddData add = new AddData();
        done = add.addPatient(naam, ini, geslacht, datum, adres, num, toevoeging, postcode, plaats, tel, mail, bSN, geweest, ww);

        if (done == 1) {
            gelukt(request, response);
        } else if (done == 2) {
        } else if (done == 3) {
        }

        //processRequest(request, response);
    }

    private void gelukt(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n"
                + "    <head>\n"
                + "        <title>Second opinion</title>\n"
                + "        <link rel=\"stylesheet\" href=\"Styless.css\"> \n"
                + "        <script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n"
                + "        <script src=\"script.js\"></script>    \n"
                + "    </head>\n"
                + "    <body>\n"
                + "\n"
                + "        <div id=\"main\">\n"
                + "            <div id=\"header\" class=\"hoofd\">\n"
                + "                <h1 align=\"center\"><b>SECOND OPINION PORTAAL</b></h1>\n"
                + "                <p id=\"ondertitel\" align=\"center\"><i>Uw aanvraag is in behandeling genomen</i></p>\n"
                + "\n"
                + "                <a href=\"inlog.html\"><button class=\"inlogKnop\"><h3 id=\"login\">Inloggen</h3></button></a>\n"
                + "            </div>\n"
                + "\n"
                + "            <div id=\"gegevens\">\n"
                + "\n"
                + "                <div id=\"knop1\">\n"
                + "                    <a href=\"patientAanvraag.html\"><button class=\"button\">Ik ben een pati&euml;nt</button></a>\n"
                + "                </div>\n"
                + "                <div id=\"knop2\">\n"
                + "                    <a href= \"https://formulieren.avl.nl/verwijzers.aspx \"><button class=\"button\">Ik ben een arts</button></a>\n"
                + "                </div>\n"
                + "                <img src=\"https://www.avl.nl/media/8869707/logo-NL-Antoni-van-Leeuwenhoek_jpeg_grootformaat.jpg\" id=\"avl\" >\n"
                + "\n"
                + "            </div>\n"
                + "        </div>\n"
                + "\n"
                + "\n"
                + "    </body>\n"
                + "\n"
                + "</html>");

    }

    private void fout() {
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
