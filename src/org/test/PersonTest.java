package org.test;

import org.j2os.project.api.PersonAPI;
import org.junit.Test;

public class PersonTest {
    @Test
    public void saveTest() throws Exception {
        PersonAPI personAPI = new PersonAPI();
        personAPI.save("Ali" ,"Akbari");
    }
    @Test
    public void findTest1() throws Exception {
        PersonAPI personAPI = new PersonAPI();
        personAPI.find("Ali" );
    }
    @Test
    public void findTest() throws Exception {
        PersonAPI personAPI = new PersonAPI();
        personAPI.find("1" );
    }
    @Test
    public void findAllTest() throws Exception {
        PersonAPI personAPI = new PersonAPI();
        personAPI.findAll();
    }
    @Test
    public void findOneByIdTest() throws Exception {
        PersonAPI personAPI = new PersonAPI();
        personAPI.findOneById("100");
    }
}
