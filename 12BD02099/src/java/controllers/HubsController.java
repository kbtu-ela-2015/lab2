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
import models.HomeModel;
import models.HubsModel;

public class HubsController extends HttpServlet {
    private Object request;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    HubsModel model = new HubsModel();
    RequestDispatcher requestDispatcher;
    requestDispatcher = request.getRequestDispatcher("template.jsp");
    request.setAttribute("page", "hubs");
        
    request.setAttribute("title", model.title);

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
