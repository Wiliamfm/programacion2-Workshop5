package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ModifyBookServlet", value = "/ModifyBookServlet")
public class ModifyBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Integer authorId = Integer.parseInt(request.getParameter("authorId"));
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String genre= request.getParameter("genre");

        BookService bookService = new BookService();
        if(bookService.modifyBook(bookId, title, isbn, genre)){
            response.sendRedirect("./info-author.jsp?authorId="+String.valueOf(authorId));
        }else{
            response.sendRedirect("./index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
