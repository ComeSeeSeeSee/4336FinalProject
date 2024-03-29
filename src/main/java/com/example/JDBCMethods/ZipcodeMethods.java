package com.example.JDBCMethods;

import com.example.entities.Zipcode;
import com.example.utils.InitializeJdbcUtils;

import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author leozh
 */
public class ZipcodeMethods {


    private PreparedStatement getAllZipCodeStatement;


    private InitializeJdbcUtils initializeJdbcUtils = new InitializeJdbcUtils();
    private Connection connection = initializeJdbcUtils.getConnection();




    public Set<Zipcode> findAllZipcodes() {
        Set<Zipcode> set = new LinkedHashSet<>();
        try {
            getAllZipCodeStatement = connection.prepareStatement("select * from zipcode");
            ResultSet allZipCodeSet = getAllZipCodeStatement.executeQuery();


            while (allZipCodeSet.next()){
                Integer id =allZipCodeSet.getInt(1);
                String zipcodes = allZipCodeSet.getString(2);

                Zipcode zipcode = new Zipcode();
                zipcode.setId(id);
                zipcode.setZipcode(zipcodes);

                set.add(zipcode);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }




    private PreparedStatement getZipCodeByIdStatement;


    public Zipcode findZipcodeById(int id) {

        Zipcode zipcode = new Zipcode();
        try {
            getZipCodeByZipcode = connection.prepareStatement("select * from zipcode  where id = ?");
            getZipCodeByZipcode.setInt(1,id);
            ResultSet resultSet1 = getZipCodeByZipcode.executeQuery();

            if(resultSet1.next()){
                Integer ids =resultSet1.getInt(1);
                String zipcodes = resultSet1.getString(2);
                zipcode.setId(ids);
                zipcode.setZipcode(zipcodes);
                return zipcode;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return zipcode;
    }


    private PreparedStatement getZipCodeByZipcode;


    public Zipcode findZipcodeByZipcode(String zip) {
        Zipcode zipcode = new Zipcode();
        try {
            getZipCodeByZipcode = connection.prepareStatement("select * from zipcode  where zipcode = ?");
            getZipCodeByZipcode.setString(1,zip);
            ResultSet resultSet1 = getZipCodeByZipcode.executeQuery();

            if(resultSet1.next()){
                Integer ids =resultSet1.getInt(1);
                String zipcodes = resultSet1.getString(2);
                zipcode.setId(ids);
                zipcode.setZipcode(zipcodes);
                return zipcode;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return zipcode;
    }





    //testing
    public static void main(String[] args) throws SQLException {

        ZipcodeMethods zipcodeMethods = new ZipcodeMethods();
        zipcodeMethods.findAllZipcodes().forEach(System.out::println);

        System.out.println("*********************");

        Zipcode zipcodeById = zipcodeMethods.findZipcodeByZipcode("75075");
        System.out.println(zipcodeById);


//        String zipcode="12354";
//        String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
//
//        Pattern pattern = Pattern.compile(regex);
//
//        Matcher matcher = pattern.matcher(zipcode);
//        System.out.println(matcher.matches());


        String creditCard = "1234567890123456";
        String regex = "^\\d{16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(creditCard);
        System.out.println(matcher.matches());


    }





}


//            getZipCodeById =conn.prepareStatement("select * from zipcode  where id = ?");
//            pstmt = conn.prepareStatement("select Title, Page, Authors from bookeverything where ISBN = ? ");
//            getAllZipCode = conn.prepareStatement("select * from zipcode");
//
//            findByZipcode=conn.prepareStatement("select * from zipcode where zipcode= ?");
