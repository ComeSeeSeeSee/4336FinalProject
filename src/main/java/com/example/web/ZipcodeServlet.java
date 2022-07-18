package com.example.web;


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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ZipcodeServlet")
public class ZipcodeServlet extends HttpServlet {

    private static final String CONTENT_TYPE = "text/html";
    private PreparedStatement getZipCodeById;
    private PreparedStatement getAllZipCode;
//
//    private PreparedStatement findByZipcode;

    private List<String> zipList = new ArrayList<>();

    private ZipcodeMethods zipcodeMethods;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        out.println("hello");


        //1st display all zipcodes and send to front end
        List<Zipcode> allZipcodes = zipcodeMethods.findAllZipcodes();
        request.setAttribute("zipcodeList",allZipcodes);

        //2nd get user input zipcode
        int zipcodeId = Integer.valueOf(request.getParameter("zipcodeId"));
        //zipcode id
        System.out.println(zipcodeId);
        Zipcode zipcodeById = zipcodeMethods.findZipcodeById(zipcodeId);
        request.setAttribute("zipcodeById",zipcodeById);

        request.getRequestDispatcher("\\");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }





    @Override
    public String getServletInfo() {
        return "Short description";
    }


}


