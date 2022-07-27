package com.example.web;

import com.example.utils.InitializeJdbcUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/paymentServlet")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        writer.println("Payment finished");

        //and redirect to the receipt page
//        request.getRequestDispatcher("receipt.jsp").forward(request,response);


        InitializeJdbcUtils initializeJdbcUtils = new InitializeJdbcUtils();
        try {
            //close  seesion after the finished purchase
            initializeJdbcUtils.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
