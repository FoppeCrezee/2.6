/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author foppe
 */
public class WijzigServlet extends HttpServlet {
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
        
        String mail = request.getParameter("vNaam");
        String ini = request.getParameter("ini");
        String adres = request.getParameter("adres");
        String sex = request.getParameter("sex");
        String postcode = request.getParameter("postcode");
        String plaats = request.getParameter("plaats");

        ChangeData change = new ChangeData(mail, ini, sex, adres, postcode, plaats, request, response);

        response.sendRedirect("Ingelogd.jsp");
        
        
    }


}
