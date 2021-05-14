package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InfoAuthorServlet", value = "/InfoAuthorServlet")
public class InfoAuthorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Integer authorId = Integer.parseInt(request.getParameter("authorId"));
        AuthorService as= new AuthorService();
        AuthorPOJO a= as.getAuthorById(authorId);
        String json = new Gson().toJson(a);
        response.getWriter().println(json);
        response.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
