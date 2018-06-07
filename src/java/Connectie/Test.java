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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author foppe
 */
@WebServlet(name = "Test", urlPatterns = {"/Test"})
public class Test extends HttpServlet {

    Exception e;
    
    /*public static void main(String[] args) {

        String vNaa = "TEstje";
        Connection con = null;
        PreparedStatement pst = null;

        try {
            String url = "jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "Foppe");

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            con = DriverManager.getConnection(url, info);
            System.out.println("gelukt");
            Statement statement = con.createStatement();
            System.out.println(statement.executeQuery("SELECT * FROM ding"));
            
            
            //statement.executeUpdate("INSERT into ding values(" + vNaa + "," + vNaa + ")");
        } catch (SQLException e) {
            System.out.println("geen connectie: " + e);

        }

    }*/

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        


        /*String vNaa = "TEstje";
        Connection con = null;
        PreparedStatement pst = null;

        try {
            String url = "jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&verifyServerCertificate=false&useSSL=true";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "Foppe");

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
            con = DriverManager.getConnection(url, info);
            System.out.println("gelukt");
            Statement statement = con.createStatement();
            statement.executeQuery("INSERT into ding values('Foppje', 'test')");
            
            
            //statement.executeUpdate("INSERT into ding values(" + vNaa + "," + vNaa + ")");
        } catch (SQLException ex) {
            System.out.println("geen connectie: " + e);
            e = ex;

        }*/

    
        
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Nieuwe gebruiker";
        String docType
                = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";

//        out.println(docType
//                + "<html>\n"
//                + "<head><title>" + title + "</title></head>\n"
//                + "<body bgcolor = \"#f0f0f0\">\n"
//                + "<h1 align = \"center\">" + title + "</h1>\n"
//                + "<ul>\n"
//                + "  <li><b>First Name</b>: "
//                + request.getParameter("voorNaam") + "\n"
//                + "  <li><b>Last Name</b>: "
//                + request.getParameter("wachtWoord") + "\n"
//                + "  <li><b>Last Name</b>: "
//                + e + "\n"
//                + "</ul>\n"
//                + "</body>"
//                + "</html>"
                
        out.println(
                "<html>\n" +
"    <head>\n" +
"        <title>Second opinion</title>\n" +
"        <link rel=\"stylesheet\" href=\"Styles.css\"> \n" +
"        <script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n" +
"        <script src=\"script.js\"></script>    \n" +
"    </head>\n" +
"    <body>\n" +
"        \n" +
"        <div id=\"main\">\n" +
"            <div id=\"header\" class=\"hoofd\">\n" +
"				<img src=\"https://www.avl.nl/media/8869707/logo-NL-Antoni-van-Leeuwenhoek_jpeg_grootformaat.jpg\" id=\"avl3\">\n" +
"            <h1 align=\"center\">Second opinion portaal</h1>\n" +
"				<div id=\"uitlog\">\n" +
"					<a href=\"Home.html\"><button class=\"uitloggen\">Uitloggen</button></a>\n" +
"				</div>\n" +
"            </div>\n" +
"          \n" +
"            <div id=\"gegevens2\">\n" +
"           \n" +
"				<div id=\"menu\">\n" +
"					<a href=\"gegevens.html\">\n" +
"						<div class=\"menuKnopGekozen\" id=\"eerste\">\n" +
"							<p class=\"gekozen\">Mijn gegevens</p>\n" +
"							<div id=\"driehoek\">\n" +
"							</div>\n" +
"						</div>\n" +
"					</a>\n" +
"					<a href=\"aanvraag.html\">\n" +
"						<div class=\"menuKnop\" id=\"tweede\">\n" +
"							<p class=\"boven\">Mijn aanvraag</p>\n" +
"						</div>\n" +
"					</a>\n" +
"					<a href=\"behandeling.html\">\n" +
"						<div class=\"menuKnop\" id=\"derde\">\n" +
"							<p class=\"boven\">Mijn arts</p>\n" +
"						</div>\n" +
"					</a>\n" +
"					<a href=\"contact.html\">\n" +
"						<div class=\"menuKnop\" id=\"vierde\">\n" +
"							<p class=\"boven\">Contact</p>\n" +
"						</div>\n" +
"					</a>			\n" +
"				</div>\n" +
"				<div id=\"content\">\n" +
"					<p align=\"center\" id=\"titel\">Gegevens</p>\n" +
"                                       <p>Naam:" + request.getParameter("voorNaam") +"</p>         \n"+   
"                                       <p>Naam:" + request.getParameter("wachtWoord") +"</p>         \n"+ 
"				</div>\n" +
"            </div>\n" +
"        </div>\n" +
"     </body>\n" +
"</html>\n" 
        );
    }

    // Method to handle POST method request.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*String vNaam = request.getParameter("voorNaam");
        String ww = request.getParameter("wachtWoord");
        
        Login1 ja = new Login1(); 
        ja.main(vNaam, ww);*/
        
        
        String query = "INSERT into ding (een, twee)" + " values (?,?);";
        Connection con = null;
        String vNaam = request.getParameter("voorNaam");
        String ww = request.getParameter("wachtWoord");

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
            //System.out.println("gelukt");
            PreparedStatement pst = null;
//            pst = con.prepareStatement(query);
//            pst.setString(1, vNaam);
//            pst.setString(2, ww);
//            pst.execute();
        } catch (Exception ex) {
            System.out.println("geen connectie: " + e);
            e = ex;
        }
        //Insert add = new Insert("String", "strinf");
        
        doGet(request, response);
    }

}
