package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModifyEditionServlet", value = "/ModifyEditionServlet")
public class ModifyEditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        Integer editionId = Integer.parseInt(request.getParameter("editionId"));
        String description = request.getParameter("description");

        EditionService editionService= new EditionService();
        if(editionService.modifyEdition(editionId, description)){
            response.sendRedirect("./info-book.jsp?bookId="+String.valueOf(bookId));
        }else{
            response.sendRedirect("./index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
