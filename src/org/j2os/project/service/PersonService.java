package org.j2os.project.service;

import org.j2os.project.domain.Person;
import org.j2os.project.repository.PersonDA;
import java.util.List;

public class PersonService {
    private PersonService(){

    }
    private static final PersonService PERSON_SERVICE = new PersonService();

    public static PersonService getInstance() {
        return PERSON_SERVICE;
    }
//*********************************************************************************
    public void save (Person person)throws Exception {
        PersonDA personDA = new PersonDA();
        try (personDA) {
            personDA.insert(person);
            personDA.commit();
        }

    }
    public Person findOneById (Person person)throws Exception {
        PersonDA personDA = new PersonDA();
        try (personDA) {
          return   personDA.selectOneById(person);

        }
    }

    public List<Person> findAll () throws Exception {
        PersonDA personDA = new PersonDA();
        try (personDA) {
            return   personDA.selectAll();

        }

    }
    public List<Person> find (String search ) throws Exception {
        PersonDA personDA = new PersonDA();
        try (personDA) {
            return   personDA.selectByIdOrName(search);
        }

    }
}
