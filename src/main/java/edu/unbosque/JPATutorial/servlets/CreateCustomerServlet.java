package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateCustomerServlet", value = "/CreateCustomerServlet")
public class CreateCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String email= request.getParameter("email");
        String fName= request.getParameter("fName");
        String lName= request.getParameter("lName");
        String gender= request.getParameter("gender");
        int age= Integer.parseInt(request.getParameter("age"));

        CustomerService customerService= new CustomerService();
        if(customerService.create(email, fName, lName, gender, age)){
            response.sendRedirect("./index.jsp");
        }else{
            response.sendRedirect("./notFound");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
