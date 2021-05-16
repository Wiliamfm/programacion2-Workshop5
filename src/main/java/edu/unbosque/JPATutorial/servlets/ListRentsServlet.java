package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;

import edu.unbosque.JPATutorial.services.RentService;
import edu.unbosque.JPATutorial.servlets.pojos.RentPOJO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ListRentsServlet", value = "/ListRentsServlet")
public class ListRentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        try {
            String email = request.getParameter("customerId");
            String date = request.getParameter("date");
            RentService rentService = new RentService();
            List<RentPOJO> rents = rentService.listRents(email, date);

            String json = new Gson().toJson(rents);
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        }catch (Exception e){
            PrintWriter out = response.getWriter();
            out.print("{error: \"error\"}");
            out.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
