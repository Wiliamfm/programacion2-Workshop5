package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddLibraryServlet", value = "/AddLibraryServlet")
public class AddLibraryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String c= request.getParameter("case");
        Integer editionId= Integer.parseInt(request.getParameter("editionId"));
        Integer libraryId= Integer.parseInt(request.getParameter("libraryId"));

        EditionService editionService= new EditionService();
        if(c.equals("link")){
            editionService.linkLibrary(libraryId, editionId);
            response.sendRedirect("./info-libraries.jsp?editionId=" +editionId);
        }else if(c.equals("unlink")){
            editionService.unLinkLibrary(libraryId, editionId);
            response.sendRedirect("./info-libraries.jsp?editionId=" +editionId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
