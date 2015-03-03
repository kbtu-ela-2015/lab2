package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import models.ContactsModel;
import models.HomeModel;

public class ContactsController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    ContactsModel model = new ContactsModel();
    RequestDispatcher requestDispatcher;
    requestDispatcher = request.getRequestDispatcher("template.jsp");
    request.setAttribute("page", "contacts");
        
    request.setAttribute("username", model.username);
    request.setAttribute("surname", model.surname);
    request.setAttribute("phone", model.phone);
    request.setAttribute("home_phone", model.home_phone);
    request.setAttribute("address", model.address);
    requestDispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}