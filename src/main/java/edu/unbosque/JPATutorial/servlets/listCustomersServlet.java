package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;

import edu.unbosque.JPATutorial.services.CustomerService;
import edu.unbosque.JPATutorial.servlets.pojos.CustomerPOJO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listCustomersServlet", value = "/listCustomersServlet")
public class listCustomersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        CustomerService customerService= new CustomerService();
        List<CustomerPOJO> customers = customerService.listCustomers();

        String authorsJsonString = new Gson().toJson(customers);

        PrintWriter out = response.getWriter();
        out.print(authorsJsonString);
        out.flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
