package com.example.web;


import com.example.JDBCMethods.MovieMethods;
import com.example.JDBCMethods.ZipcodeMethods;
import com.example.entities.Zipcode;
import com.example.repos.ZipcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To access the program
 * http://localhost:8080/MovieProject/zipcode.jsp
 *
 * http://localhost:8080/MovieProject/zipcodeServlet
 * @author leozh
 */
@WebServlet("/zipcodeServlet")
public class ZipcodeServlet extends HttpServlet {

    private ZipcodeMethods zipcodeMethods = new ZipcodeMethods();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num =0;

        Set<Zipcode> allZipcodes = zipcodeMethods.findAllZipcodes();



        request.setAttribute("zipcodeList",allZipcodes);
        System.out.println(allZipcodes.size());



        request.getRequestDispatcher("/allzipcodes.jsp").forward(request,response);
        return;

//        //2nd get user input zipcode
//        int zipcodeId = Integer.valueOf(request.getParameter("zipcodeId"));
//        //zipcode id
//        System.out.println(zipcodeId);
//        Zipcode zipcodeById = zipcodeMethods.findZipcodeById(zipcodeId);
//        request.setAttribute("zipcodeById",zipcodeById);
//


    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String zipcode = request.getParameter("keyword");

        String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(zipcode);
        if(!matcher.matches()){
            System.out.println("wrong");

            request.setAttribute("error_msg1","Zipcode format incorrect, zipcode has to be 5 digits");
            request.getRequestDispatcher("/zipcodeError.jsp").forward(request,response);
            return;
        }

        Zipcode zipcodeByZipcode = zipcodeMethods.findZipcodeByZipcode(zipcode);

        System.out.println(zipcodeByZipcode);
        if(zipcodeByZipcode.getZipcode()==null){
            System.out.println("null");
            request.setAttribute("error_msg2","Cannot find any theaters in this zipcode");
            request.getRequestDispatcher("/zipcodeError.jsp").forward(request,response);
            return;
        }

        Set<Zipcode> allZipcodes = new HashSet<>();
        allZipcodes.add(zipcodeByZipcode);
        request.setAttribute("zipcodeList",allZipcodes);
        request.getRequestDispatcher("/allzipcodes.jsp").forward(request,response);
        return;
    }





    @Override
    public String getServletInfo() {
        return "Short description";
    }


}


/*
        first, display all the zipcode with id in  a table
        2nd, the user is going to pick one of it, and we are going to get the user selections
        which is like  String zipcodeId = request.getParameter("zipcodeId");

        3rd, pass the zipcodeId to theater form to display all theaters with that zipcode

        List<Theater> theaterByZipCodeIdtry1 = theaterRepository.findTheaterByZipCodeIdtry1(1);
        System.out.println(theaterByZipCodeIdtry1.stream().map(Theater::getTheaterName).collect(Collectors.toList()));

        //OUTPUT: [Cinemark Central 75075 , AMC Firewheel 18 75075 , Alamo Drafthouse Cinema 75075] only display the name for simplicity


        4th. the user is going to pick one of it, and we are going to get the user selections
        which is like String theaterId = request.getParameter("theaterId")

        repeatedly!!!
        5th. pass the theaterId to movie form to display all movies with that theater

        List<Movie> moviesByTheaterFK = movieRepository.findMoviesByTheaterFK(8);
        System.out.println(moviesByTheaterFK.stream().map(Movie::getName).collect(Collectors.toList()));
        output: [Thor: Love And Thunder2, Minions: The Rise Of Gru, Top Gun: Maverick] only display the name for simplicity

        6th the user is going to choose one movie  and then wo proceed to the next step send request to frontend and display html and jsp

        write in jsp and html fully
        7th,  first display the ticket is $10, display some random seat numbers
        prompt notice if user want to purchase the ticket
            if yes -> redirect to payment center which is able to type in the credit card and security code blah blah blah...
            display all info with seat number to user

            if no  -> going back to the home page


*/




