package org.test;

import org.j2os.project.api.CinemaAPI;
import org.junit.Test;

public class CinemaTest {
    @Test
    public void saveTest() throws Exception {
        CinemaAPI cinemaAPI = new CinemaAPI();
        cinemaAPI.buy("100" ,"100");
    }
    @Test
    public void findAllTest() throws Exception {
        CinemaAPI cinemaAPI = new CinemaAPI();
        cinemaAPI.findAll();
    }
    @Test
    public void findOneByIdTest() throws Exception {
        CinemaAPI cinemaAPI = new CinemaAPI();
        cinemaAPI.findOneById("100");
    }
    @Test
    public void reservedFromToTest() throws Exception {
        CinemaAPI cinemaAPI = new CinemaAPI();
        cinemaAPI.reservedFromTo("10","12");
    }
}
