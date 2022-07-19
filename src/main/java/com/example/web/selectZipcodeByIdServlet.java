package com.example.web;

import com.example.JDBCMethods.TheaterMethods;
import com.example.JDBCMethods.ZipcodeMethods;
import com.example.entities.Theater;
import com.example.entities.Zipcode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
/**
 * http://localhost:8080/MovieProject/zipcodeServlet
 * @author leozh
 */
@WebServlet("/selectZipcodeByIdServlet")
public class selectZipcodeByIdServlet extends HttpServlet {

    private final ZipcodeMethods zipcodeMethods = new ZipcodeMethods();

    private final TheaterMethods theaterMethods = new TheaterMethods();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<Theater> allTheatersByZipcodeFk = theaterMethods.findAllTheatersByZipcodeFk(Integer.parseInt(id));
        request.setAttribute("allTheatersByZipcodeFk",allTheatersByZipcodeFk);

//        Zipcode zipcodeById = zipcodeMethods.findZipcodeById(Integer.parseInt(id));
//        request.setAttribute("zipcodeById",zipcodeById);



        request.getRequestDispatcher("/alltheaters.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
