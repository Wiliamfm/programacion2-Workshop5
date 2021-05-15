package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCustomerServlet", value = "/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String email= request.getParameter("id");
        CustomerService customerService= new CustomerService();
        if(customerService.delete(email)){
            response.sendRedirect("./index.jsp");
        }else{
            response.sendRedirect("./notFound");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
