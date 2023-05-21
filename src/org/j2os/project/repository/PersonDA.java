package org.j2os.project.repository;

import org.j2os.project.common.CommonClass;
import org.j2os.project.common.JDBC;
import org.j2os.project.domain.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.j2os.project.common.JDBC.ORACLE_19C;

public class PersonDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDA() throws Exception {
        connection = JDBC.getConnection(ORACLE_19C);
    }

    public void close () throws Exception {
        preparedStatement.close();
        connection.close();
    }
    public void commit() throws Exception {
        connection.commit();
    }

    public void insert (Person person)throws Exception {
        preparedStatement = connection.prepareStatement("select DB_SEQUE.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getLong("id"));
        preparedStatement = connection.prepareStatement("INSERT INTO person (id,name , family) VALUES (?,?,?)");
        preparedStatement.setLong(1,person.getId());
        preparedStatement.setString(2,person.getName());
        preparedStatement.setString(3,person.getFamily());
        preparedStatement.executeUpdate();
    }
    public Person selectOneById (Person person)throws Exception {
        preparedStatement = connection.prepareStatement("SELECT id , name , family FROM person WHERE id=?");
        preparedStatement.setLong(1,person.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        Person person1 = new Person();
       if( resultSet.next() ) {
          person1.setName(resultSet.getString("name")).setFamily(resultSet.getString("family")).setId(resultSet.getLong("id"));
       }
       return person1;
    }
    public List<Person> selectAll ()throws Exception {
        preparedStatement = connection.prepareStatement("select id , name , family from person ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while ( resultSet.next() ) {
            Person person1 = new Person().setName(resultSet.getString("name")).setFamily(resultSet.getString("family")).setId(resultSet.getLong("id"));
            personList.add(person1);
        }
        return personList;
    }
    public List<Person> selectByIdOrName (String search ) throws Exception {
        if (CommonClass.getInstance().isNumeric(search)) {
            preparedStatement = connection.prepareStatement("SELECT id , name , family FROM person WHERE  id=?");
            preparedStatement.setLong(1,Long.parseLong(search));
        } else {
            preparedStatement = connection.prepareStatement("SELECT id , name , family FROM person WHERE  name=? ");
            preparedStatement.setString(1, search);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while ( resultSet.next() ) {
            Person person1 = new Person().setName(resultSet.getString("name")).setFamily(resultSet.getString("family")).setId(resultSet.getLong("id"));
            personList.add(person1);
        }
        return personList;
    }
}
