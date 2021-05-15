package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteEditionServlet", value = "/DeleteEditionServlet")
public class DeleteEditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        Integer editionId = Integer.parseInt(request.getParameter("editionId"));

        EditionService es = new EditionService();
        if(es.delete(bookId, editionId)){
            response.sendRedirect("./info-book.jsp?bookId="+String.valueOf(bookId));
        }else{
            response.sendRedirect("./index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
