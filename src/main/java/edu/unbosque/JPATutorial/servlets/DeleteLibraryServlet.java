package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.jpa.entities.Library;
import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.LibraryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteLibraryServlet", value = "/DeleteLibraryServlet")
public class DeleteLibraryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        Integer libraryId = Integer.parseInt(request.getParameter("libraryId"));

        LibraryService libraryService= new LibraryService();
        if(libraryService.delete(libraryId)){
            response.sendRedirect("./index.jsp");
        }else{
            response.sendRedirect("./notFound");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
