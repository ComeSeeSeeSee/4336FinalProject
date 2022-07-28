package com.example.web;

import com.example.JDBCMethods.MovieMethods;
import com.example.JDBCMethods.TheaterMethods;
import com.example.JDBCMethods.ZipcodeMethods;
import com.example.entities.Movie;
import com.example.entities.Theater;
import com.example.entities.Zipcode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * @author leozh
 */
@WebServlet("/selectMovieByIdServlet")
public class selectMovieByIdServlet extends HttpServlet {

    private MovieMethods movieMethods = new MovieMethods();

    private TheaterMethods theaterMethods = new TheaterMethods();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");


        try {

            Theater aTheaterById = theaterMethods.findATheaterById(Integer.parseInt(id));
            String theaterName = aTheaterById.getTheaterName();
            System.out.println(theaterName);
            request.setAttribute("theater1", theaterName);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        Set<Movie> allMoviesByTheaterFk = movieMethods.findAllMoviesByTheaterFk(Integer.parseInt(id));
        request.setAttribute("allMoviesByTheaterFk",allMoviesByTheaterFk);

        request.getRequestDispatcher("/allmovies.jsp").forward(request,response);

        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
