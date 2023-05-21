package org.test;

import org.j2os.project.api.FilmAPI;
import org.j2os.project.api.PersonAPI;
import org.junit.Test;

public class FilmTest {
    @Test
    public void saveTest() throws Exception {
        FilmAPI filmAPI = new FilmAPI();
        filmAPI.save("Sokote Bareha","10","12","100");
    }
    @Test
    public void findAllTest() throws Exception {
        FilmAPI filmAPI = new FilmAPI();
        filmAPI.findAll();
    }
    @Test
    public void findOneByIdTest() throws Exception {
        FilmAPI filmAPI = new FilmAPI();
        filmAPI.findOneById("100");
    }
    @Test
    public void findFromToTest() throws Exception {
        FilmAPI filmAPI = new FilmAPI();
        filmAPI.findFromTo("10","12");
    }
    @Test
    public void findTitleTest() throws Exception {
        FilmAPI filmAPI = new FilmAPI();
        filmAPI.findTitle("Sokote Bareha");
    }
}
