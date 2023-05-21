package org.j2os.project.service;

import org.j2os.project.domain.Cinema;
import org.j2os.project.exception.OverFlowReservetionException;
import org.j2os.project.repository.CinemaDA;
import org.j2os.project.repository.FilmDA;
import java.util.List;

public class CinemaService {
    private CinemaService () {

    }
    private static final CinemaService CINEMA_SERVICE = new CinemaService();

    public static CinemaService getInstance() {
        return CINEMA_SERVICE;
    }
    //******************************************************
    public boolean existFilm (long filmId) throws Exception {
        FilmDA filmDA = new FilmDA();
        if (filmDA.selectOneById(filmId).getCount()== 0) {
            return false;
        } else return true;
    }
    public long buy (long personId , long filmId) throws Exception {
        long id =0;

        if (existFilm(filmId)) {
            FilmDA filmDA = new FilmDA();
            CinemaDA cinemaDA = new CinemaDA();
            try (filmDA ;cinemaDA) {
                filmDA.update(filmId);
                id = cinemaDA.insert(personId , filmId);
                filmDA.commit();
                cinemaDA.commit();
                return id;
           }
        } else {

            throw new OverFlowReservetionException();
        }
    }

    public List<Cinema> reservedFromTo (int from , int to) throws Exception {
        CinemaDA cinemaDA = new CinemaDA();
        try (cinemaDA) {
            return cinemaDA.reservedFromTo(from , to);
        }
    }
    public List<Cinema> findAll() throws Exception {
        CinemaDA cinemaDA = new CinemaDA();
        try (cinemaDA) {
            return cinemaDA.selectAll();
        }
    }
    public Cinema findOneById(Cinema cinema) throws Exception {
        CinemaDA cinemaDA = new CinemaDA();
        try (cinemaDA) {
            return cinemaDA.selectOneById(cinema);
        }
    }
}
