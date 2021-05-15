package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.RentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RentEditionServlet", value = "/RentEditionServlet")
public class RentEditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String email= request.getParameter("email");
        Integer editionId= Integer.parseInt(request.getParameter("editionId"));
        RentService rentService= new RentService();
        if(rentService.rent(email, editionId)){
            response.sendRedirect("./index.jsp");
        }else{
            response.sendRedirect("./notFound");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
