package com.example.JDBCMethods;

import com.example.entities.Movie;
import com.example.entities.Theater;
import com.example.utils.InitializeJdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieMethods {

    private InitializeJdbcUtils initializeJdbcUtils = new InitializeJdbcUtils();
    private Connection connection = initializeJdbcUtils.getConnection();

    private PreparedStatement getAllTheatersByZipcodeStatement;

    private List<Movie> moviesList = new ArrayList<>();


    public List<Movie> findAllMoviesByTheaterFk(int idFk)throws SQLException{

        getAllTheatersByZipcodeStatement = connection.prepareStatement("select * from movie where theater_id_fk = ?");
        getAllTheatersByZipcodeStatement.setInt(1,idFk);

        ResultSet resultSet = getAllTheatersByZipcodeStatement.executeQuery();

        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            String timePeriod = resultSet.getString(4);

            moviesList.add(new Movie(id,name,description,timePeriod));
        }

        return moviesList;
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
        movieMethods.findAllMoviesByTheaterFk(1).forEach(System.out::println);

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(movieMethods.findOneMovieById(2));
    }



}
