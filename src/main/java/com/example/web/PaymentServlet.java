package com.example.web;

import com.example.JDBCMethods.MovieMethods;
import com.example.entities.Movie;
import com.example.utils.InitializeJdbcUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/paymentServlet")
public class PaymentServlet extends HttpServlet {

    private MovieMethods movieMethods = new MovieMethods();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        try {
//            Movie oneMovieById = movieMethods.findOneMovieById(Integer.parseInt(id));
//
//            String name = oneMovieById.getName();
//            request.setAttribute("movie",name);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        String creditCard = request.getParameter("keyword");

        //1234567890123456
        String regex = "^\\d{15}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(creditCard);
        if(matcher.matches()){
            request.setAttribute("error_msg1","Credit card number is not correct");
            request.getRequestDispatcher("/payment.jsp").forward(request,response);
            return;
        }else {
            request.setAttribute("success_msg1","Pay successfully!");
            request.getRequestDispatcher("/result.jsp").forward(request,response);
            return;
        }



    }
}
