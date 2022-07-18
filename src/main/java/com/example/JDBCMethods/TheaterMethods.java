package com.example.JDBCMethods;

import com.example.entities.Theater;
import com.example.entities.Zipcode;
import com.example.utils.InitializeJdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TheaterMethods {

    private InitializeJdbcUtils initializeJdbcUtils = new InitializeJdbcUtils();
    private Connection connection = initializeJdbcUtils.getConnection();

    private PreparedStatement getAllTheatersByZipcodeStatement;

    private List<Theater> theaterList = new ArrayList<>();

    public List<Theater> findAllTheatersByZipcodeFk( int idFk) throws SQLException {
        getAllTheatersByZipcodeStatement = connection.prepareStatement("select * from theater where zipcode_id_fk = ?");

        getAllTheatersByZipcodeStatement.setInt(1,idFk);
        ResultSet resultSet = getAllTheatersByZipcodeStatement.executeQuery();

        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String theaters = resultSet.getString(2);

            theaterList.add(new Theater(id,theaters));

        }
        return theaterList;
    }

    private PreparedStatement findATheaterById;


    public Theater findATheaterById(int id) throws SQLException {
        findATheaterById=connection.prepareStatement("select * from theater where id = ?");
        findATheaterById.setInt(1,id);
        ResultSet resultSet = findATheaterById.executeQuery();

        while(resultSet.next()){
            int id1 = resultSet.getInt(1);
            String theater1 = resultSet.getString(2);

            return  new Theater(id1,theater1);
        }

        return null;
    }




    public static void main(String[] args) throws SQLException {
        TheaterMethods theaterMethods = new TheaterMethods();
        theaterMethods.findAllTheatersByZipcodeFk(3).forEach(System.out::println);
        System.out.println("******************");

        Theater aTheaterById = theaterMethods.findATheaterById(7);
        System.out.println(aTheaterById);

    }
}
