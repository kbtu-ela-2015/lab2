package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.HomeModel;
import models.HubsModel;

public class HubController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    HubsModel model = new HubsModel();
    RequestDispatcher requestDispatcher;
    requestDispatcher = request.getRequestDispatcher("template.jsp");
    String str = request.getParameter("id");
    Integer integer = Integer.parseInt(str);
            request.setAttribute("page", "hub");

    request.setAttribute("title", model.title.get(integer-1));
    request.setAttribute("text", model.text.get(integer-1));

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
