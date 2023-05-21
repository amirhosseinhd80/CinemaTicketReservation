package org.j2os.project.repository;

import org.j2os.project.common.JDBC;
import org.j2os.project.domain.Cinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.j2os.project.common.JDBC.ORACLE_19C;

public class CinemaDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CinemaDA() throws Exception {
        connection = JDBC.getConnection(ORACLE_19C);
    }

    public void close () throws Exception {
        preparedStatement.close();
        connection.close();
    }
    public void commit() throws Exception {
        connection.commit();
    }

    public long insert (long personId , long filmId) throws Exception {
        Cinema cinema = new Cinema();

        preparedStatement = connection.prepareStatement("select DB_SEQUE.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        cinema.setId(resultSet.getLong("id"));
//***************************************************************************************************************
        preparedStatement = connection.prepareStatement("select name , family from person where id=?");
        preparedStatement.setLong(1,personId);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        cinema.setName(resultSet.getString("name")).setFamily(resultSet.getString("family"));
        //********************************************************************************************************
        preparedStatement = connection.prepareStatement("select ftitle , ffrom  , fto from film where id=?");
        preparedStatement.setLong(1,filmId);
        resultSet = preparedStatement.executeQuery();
        resultSet.next();
        cinema.setTitle(resultSet.getString("ftitle")).setFrom(resultSet.getInt("ffrom")).setTo(resultSet.getInt("fto"));
        //********************************************************************************************************
        preparedStatement = connection.prepareStatement("INSERT INTO cinema (id,ftitle , ffrom , fto ,name , family) VALUES (?,?,?,?,?,?)");
        preparedStatement.setLong(1,cinema.getId());
        preparedStatement.setString(2,cinema.getTitle());
        preparedStatement.setInt(3,cinema.getFrom());
        preparedStatement.setInt(4,cinema.getTo());
        preparedStatement.setString(5,cinema.getName());
        preparedStatement.setString(6,cinema.getFamily());

        preparedStatement.executeUpdate();
        return cinema.getId();
    }

    public List<Cinema> reservedFromTo (int from , int to) throws Exception {
        preparedStatement = connection.prepareStatement("select id,ftitle , ffrom , fto ,name , family from cinema where ffrom=? AND fto=? ");
        preparedStatement.setInt(1,from);
        preparedStatement.setInt(2,to);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Cinema> cinemaList = new ArrayList<>();
        while ( resultSet.next() ) {
            Cinema cinema = new Cinema().setName(resultSet.getString("name")).setFamily(resultSet.getString("family")).setId(resultSet.getLong("id")).setTo(resultSet.getInt("fto")).setFrom(resultSet.getInt("ffrom")).setTitle(resultSet.getString("ftitle"));
            cinemaList.add(cinema);
        }
        return cinemaList;

    }
    public List<Cinema> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select id,ftitle , ffrom , fto ,name , family from cinema ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Cinema> cinemaList = new ArrayList<>();
        while ( resultSet.next() ) {
            Cinema cinema = new Cinema().setName(resultSet.getString("name")).setFamily(resultSet.getString("family")).setId(resultSet.getLong("id")).setTo(resultSet.getInt("fto")).setFrom(resultSet.getInt("ffrom")).setTitle(resultSet.getString("ftitle"));
            cinemaList.add(cinema);
        }
        return cinemaList;

    }
    public Cinema selectOneById(Cinema cinema) throws Exception {
        preparedStatement = connection.prepareStatement("select id,ftitle , ffrom , fto ,name , family from cinema WHERE id=?");
        preparedStatement.setLong(1,cinema.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        Cinema cinema1 = new Cinema();
        if ( resultSet.next() ) {
            cinema1.setName(resultSet.getString("name")).setFamily(resultSet.getString("family")).setId(resultSet.getLong("id")).setTo(resultSet.getInt("fto")).setFrom(resultSet.getInt("ffrom")).setTitle(resultSet.getString("ftitle"));
        }
        return cinema1;

    }
}
