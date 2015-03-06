/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ContactsModel;
import models.MainPageModel;

/**
 *
 * @author aibek
 */
public class ContactsController extends HttpServlet {

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
         ContactsModel model = new ContactsModel();
       RequestDispatcher requestDispatcher;
        requestDispatcher = request.getRequestDispatcher("template.jsp");
        request.setAttribute("page", "contacts");
             
        
        String str = "<!DOCTYPE html>"+
        "<html>"+
            "<head>"+
         "<link rel=\"stylesheet\" type=\"text/css\" href=\" main.css\" />"+
         "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"+
        "<title>JSP Page</title>"+
    "</head>"+
                "<body>"+
                "<div class=\"content\">"+
            "<div class=\"text\">"+
                "<h3 id = \"title\">Contacts</h3>"+
                "<ul>"+
                     "<li id = \"text\">Mobile: "+model.phone_number1+"</li>"+
                     "<li id = \"text\">Office: "+model.phone_number2+"</li>"+
                     "<li id = \"text\">Address: "+model.address+"</li>"+
                "</ul>"+
            "</div>"+
        "</div>"+
        "</body>"+
                "</html>";    
        request.setAttribute("htmlcode", str);

        requestDispatcher.forward(request, response);

   
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
