package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.LibraryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModifyLibraryServlet", value = "/ModifyLibraryServlet")
public class ModifyLibraryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Integer libraryId = Integer.parseInt(request.getParameter("libraryId"));
        String name = request.getParameter("name");

        LibraryService libraryService = new LibraryService();
        if(libraryService.modify(libraryId, name)){
            response.sendRedirect("./index.jsp");
        }else{
            response.sendRedirect("./notFound");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
