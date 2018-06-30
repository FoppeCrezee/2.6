/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import Data.RequestData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
                + "            <div id=\"gegevens2\">\n"
                + "                <div id=\"menu\">\n"
                + "                    <a href=\"Patienten\">\n"
                + "                        <div class=\"menuKnopGekozen\" id=\"tweede\">\n"
                + "                            <p class=\"gekozen\">Patient aanvragen</p>\n"
                + "                            <div id=\"driehoek\">\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </a>\n"
                + "                    <a href=\"artsGegevens.jsp\">\n"
                + "                        <div class=\"menuKnop\" id=\"eerste\">\n"
                + "                            <p class=\"boven\">Mijn gegevens</p>\n"
                + "                            \n"
                + "                        </div>\n"
                + "                    </a>\n"
                + "                        <div class=\"menuKnopLeeg\" id=\"derde\">\n"
                + "                        </div>\n"
                + "                        <div class=\"menuKnopLeeg\" id=\"vierde\">\n"
                + "                        </div>\n"
                + "                </div>\n"
                + "\n"
                + "                <div id=\"content\">\n"
                + "                    <p align=\"center\" id=\"titel\">Gegevens</p>\n"
                + "                        <table class=\"data\" id=\"tableGegevens\">\n"
                + "                         <tr>"
                + "                             <th>"
                + "Naam:"
                + "                             </th>"
                + "                             <th>"
                + "Initialen: "
                + "                             </th>"
                + "                             <th>"
                + "Geb datum:"
                + "                             </th>"
                + "                             <th>"
                + "Stadium:"
                + "                             </th>"
                + "                             <th>"
                + "Tijd laatste stadium: "
                + "                             </th>"
                + "                             <th>"
                + "Tijd tot 72 uur voorbij is: "
                + "                             </th>"
                + "                             <th>"
                + "                             </th>"
                + "                         </tr>"
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
        ArrayList<Patient> lijst;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        lijst = data.getPatienten();
        for (Patient patient : lijst) {
            allemaal = allemaal
                    + "<form action=\"PatientInfoServlet\" method=\"post\">\n"
                    + "								<tr>\n"
                    + "										<input id=\"veld\" type=\"hidden\" value=\"" + patient.getMail() + "\" name=\"mail\" readonly>\n"
                    + "									<td>\n"
                    + "                                                                         " + aanRoep(patient) + patient.getNaam()
                    + "									</td>\n"
                    + "                                                                 <td>\n"
                    + "                                                                         " + patient.getIni()
                    + "									</td>\n"
                    + "									<td>\n"
                    + "                                                                         " + patient.getDatum()
                    + "									</td>\n"
                    + "									<td>\n"
                    + "                                                                         " + (patient.getStadium()+1)
                    + "									</td>\n"
                    + "									<td>\n"
                    + "                                                                         " + dateFormat.format(patient.getTijdLaatsteStadium())
                    + "									</td>\n"
                    + "									<td>\n"
                    + "                                                                         " + getTijdPlus(patient.getTijd2(), patient.getStadium())               
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

    private String aanRoep(Patient patient) {
        String man = "Dhr ";
        String vrouw = "Mvr ";
        if (patient.getSex().equals("man")) {
            return man;
        } else {
            return vrouw;
        }
    }

    /**
     * Geeft een string die weergeeft hoe lang het nog duurt voordat de 72 uur is omgegaan vanaf het 3e stadium
     * @param date is de datum dat het 3e stadium is ingegaan
     * @param stadium is het huidige stadium
     * @return String met de tijd, of een String die aangeeft dat het 3e stadium nog niet is berijkt
     */
    private String getTijdPlus(Date date, int stadium) {

        if(stadium == 4)
            return "Aanvraag is afgerond";
        else if (stadium > 1) {
            Date date2;
            Calendar cal2 = Calendar.getInstance(); // creates calendar
            cal2.add(Calendar.HOUR_OF_DAY, -2); // adds one hour
            date2 = cal2.getTime(); // returns new date object, one hour in the future

            Calendar cal = Calendar.getInstance(); // creates calendar
            cal.setTimeInMillis(date.getTime()); // sets calendar time/date
            cal.add(Calendar.HOUR_OF_DAY, 70); // adds one hour
            date = cal.getTime(); // returns new date object, one hour in the future

            long diff = date.getTime() - date2.getTime();
            int verschil = (int) diff / (1000 * 60 * 60);
            double minuten = (double) diff / (1000 * 60 * 60) - verschil;
            
            minuten = minuten * 60;
            
            //tijd is voorbij
            if(verschil < 0 || minuten < 0)
                return "00:00";
            //minuten kleiner dan 10 toch weergeven in twee cijfers
            else if (minuten < 10) {
                return (verschil + ":0" + (int) minuten);
            //minuten en uren weergeven
            } else {
                return (verschil + ":" + (int) minuten);
            }
        }
        else
            return "Dossier is nog niet binnen";
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