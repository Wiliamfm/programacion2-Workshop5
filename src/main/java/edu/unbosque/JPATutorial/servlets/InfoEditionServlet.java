package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;

import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InfoEditionServlet", value = "/InfoEditionServlet")
public class InfoEditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Integer id = Integer.parseInt(request.getParameter("id"));
        EditionService es = new EditionService();
        String json = new Gson().toJson(es.getEdition(id));
        response.getWriter().println(json);
        response.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
