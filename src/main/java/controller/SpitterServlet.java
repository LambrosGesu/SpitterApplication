package controller;

import domain.Spitter;
import service.SpitterService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SpitterServlet", value = "/SpitterServlet")
public class SpitterServlet extends HttpServlet {

    private final SpitterService spitterService = new SpitterService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            listSpitters(request,response);
        }catch (Exception e){
            throw new ServletException(e);
        }
    }

    private void listSpitters(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Spitter> spitters = spitterService.getSpitters();
        request.setAttribute("list", spitters);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-spitters.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
