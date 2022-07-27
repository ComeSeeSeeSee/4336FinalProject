package com.example.web;

import com.example.JDBCMethods.MovieMethods;
import com.example.entities.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author leozh
 */
@WebServlet("/selectMovieByIdServlet")
public class selectMovieByIdServlet extends HttpServlet {

    private MovieMethods movieMethods = new MovieMethods();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Set<Movie> allMoviesByTheaterFk = movieMethods.findAllMoviesByTheaterFk(Integer.parseInt(id));
        request.setAttribute("allMoviesByTheaterFk",allMoviesByTheaterFk);

        request.getRequestDispatcher("/allmovies.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
