package org.j2os.project.repository;

import org.j2os.project.common.JDBC;
import org.j2os.project.domain.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.j2os.project.common.JDBC.ORACLE_19C;

public class FilmDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public FilmDA() throws Exception {
        connection = JDBC.getConnection(ORACLE_19C);
    }

    public void close () throws Exception {
        preparedStatement.close();
        connection.close();
    }
    public void commit() throws Exception {
        connection.commit();
    }
    //****************************************************************
    public void insert (Film film) throws Exception {
        preparedStatement = connection.prepareStatement("select DB_SEQUE.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        film.setId(resultSet.getLong("id"));
        preparedStatement = connection.prepareStatement("INSERT INTO film (id,ftitle ,ffrom , fto , count) VALUES (?,?,?,?,?)");
        preparedStatement.setLong(1,film.getId());
        preparedStatement.setString(2,film.getTitle());
        preparedStatement.setInt(3,film.getFrom());
        preparedStatement.setInt(4,film.getTo());
        preparedStatement.setInt(5,film.getCount());
        preparedStatement.executeUpdate();

    }
    public void update (long filmId) throws Exception {
        preparedStatement = connection.prepareStatement("UPDATE film set count = count -1 where id=?");
        preparedStatement.setLong(1,filmId);
        preparedStatement.executeUpdate();
    }
    public List<Film> selectAll () throws Exception {
        preparedStatement = connection.prepareStatement("select id,ftitle ,ffrom , fto , count from film ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Film> filmList = new ArrayList<>();
        while ( resultSet.next() ) {
            Film film = new Film().setTitle(resultSet.getString("ftitle")).setFrom(resultSet.getInt("ffrom")).setId(resultSet.getLong("id")).setTo(resultSet.getInt("fto")).setCount(resultSet.getInt("count"));
            filmList.add(film);
        }
        return filmList;

    }
    public Film selectOneById (long filmId) throws Exception {
        preparedStatement = connection.prepareStatement("select id,ftitle ,ffrom , fto , count from film where id=?");
        preparedStatement.setLong(1,filmId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Film film1 = new Film();
        if ( resultSet.next() ) {
            film1.setTitle(resultSet.getString("ftitle")).setFrom(resultSet.getInt("ffrom")).setId(resultSet.getLong("id")).setTo(resultSet.getInt("fto")).setCount(resultSet.getInt("count"));
        }
        return film1;

    }
    public List<Film> selectByFromTo (Film film) throws Exception {
        preparedStatement = connection.prepareStatement("select id,ftitle ,ffrom , fto , count from film where ffrom=? AND fto=?");
        preparedStatement.setInt(1,film.getFrom());
        preparedStatement.setInt(2,film.getTo());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Film> filmList = new ArrayList<>();
        while ( resultSet.next() ) {
            Film film1 = new Film().setTitle(resultSet.getString("ftitle")).setFrom(resultSet.getInt("ffrom")).setId(resultSet.getLong("id")).setTo(resultSet.getInt("fto")).setCount(resultSet.getInt("count"));
            filmList.add(film1);
        }
        return filmList;
    }
    public List<Film> selectByTitle (Film film) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT id,ftitle ,ffrom , fto , count FROM film WHERE ftitle=?");
        preparedStatement.setString(1,film.getTitle());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Film> filmList = new ArrayList<>();
        while ( resultSet.next() ) {
            Film film1 = new Film().setTitle(resultSet.getString("ftitle")).setFrom(resultSet.getInt("ffrom")).setId(resultSet.getLong("id")).setTo(resultSet.getInt("fto")).setCount(resultSet.getInt("count"));
            filmList.add(film1);
        }
        return filmList;

    }

}
