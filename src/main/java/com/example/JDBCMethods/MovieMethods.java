package com.example.JDBCMethods;

import com.example.entities.Movie;
import com.example.entities.Theater;
import com.example.utils.InitializeJdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MovieMethods {

    private InitializeJdbcUtils initializeJdbcUtils = new InitializeJdbcUtils();
    private Connection connection = initializeJdbcUtils.getConnection();

    private PreparedStatement getAllTheatersByZipcodeStatement;



    public Set<Movie> findAllMoviesByTheaterFk(int idFk){

        Set<Movie> set = new LinkedHashSet<>();

        try {
            getAllTheatersByZipcodeStatement = connection.prepareStatement("select * from movie where theater_id_fk = ?");
            getAllTheatersByZipcodeStatement.setInt(1,idFk);

            ResultSet resultSet = getAllTheatersByZipcodeStatement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                String timePeriod = resultSet.getString(4);

                set.add(new Movie(id,name,description,timePeriod));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return set;
    }


    private PreparedStatement findAMoiveById;

    public Movie findOneMovieById(int id) throws SQLException {
        findAMoiveById = connection.prepareStatement("select * from movie where id = ?");
        findAMoiveById.setInt(1,id);
        ResultSet resultSet = findAMoiveById.executeQuery();
        while(resultSet.next()){
            int id1 = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            String timePeriod = resultSet.getString(4);
            return new Movie(id1,name,description,timePeriod);

        }

        return null;
    }



    //testing
    public static void main(String[] args) throws SQLException {
        MovieMethods  movieMethods = new MovieMethods();
//        movieMethods.findAllMoviesByTheaterFk(1).forEach(System.out::println);

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(movieMethods.findOneMovieById(2));
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
