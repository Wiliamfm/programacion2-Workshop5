package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;

import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InfoBookServlet", value = "/InfoBookServlet")
public class InfoBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        BookService bs = new BookService();
        String json = new Gson().toJson(bs.getBook(bookId));
        response.getWriter().println(json);
        response.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
