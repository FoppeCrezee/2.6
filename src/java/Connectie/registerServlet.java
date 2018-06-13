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
        
        if(avl_geweest.equals("on")){
            geweest = 1;
        }
        
        
        AddData add = new AddData();
        int done = add.addPatient(naam, ini, geslacht, datum, adres, num, toevoeging, postcode, plaats, tel, mail, bSN, geweest, ww);
        
        if(done == 1){
            gelukt(request, response);
        }else if (done == 2){
        }else if (done == 3){
        }
        
        //processRequest(request, response);
    }
    
    private void gelukt(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("");
        
    }
    
    private void fout(){}

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
