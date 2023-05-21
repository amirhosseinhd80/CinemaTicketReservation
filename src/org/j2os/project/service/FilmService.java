package org.j2os.project.service;

import org.j2os.project.domain.Film;
import org.j2os.project.repository.FilmDA;
import java.util.List;

public class FilmService {
    private FilmService(){

    }
    private static final FilmService FILM_SERVICE = new FilmService();

    public static FilmService getInstance() {
        return FILM_SERVICE;
    }
    //*******************************************************
    public void save (Film film) throws Exception {
        FilmDA filmDA = new FilmDA();
        try (filmDA) {
            filmDA.insert(film);
            filmDA.commit();
        }
    }
    public void update (long filmId) throws Exception {
        FilmDA filmDA = new FilmDA();
        try (filmDA) {
            filmDA.update(filmId);
            filmDA.commit();
        }
    }
    public List<Film> findAll () throws Exception {
        FilmDA filmDA = new FilmDA();
        try (filmDA) {
           return filmDA.selectAll();
        }
    }
    public Film findOneById (long filmId) throws Exception {
        FilmDA filmDA = new FilmDA();
        try (filmDA) {
            return filmDA.selectOneById(filmId);
        }
    }
    public List<Film> findFromTo (Film film) throws Exception {
        FilmDA filmDA = new FilmDA();
        try (filmDA) {
            return filmDA.selectByFromTo(film);
        }
    }
    public List<Film> findTitle (Film film) throws Exception {
        FilmDA filmDA = new FilmDA();
        try (filmDA) {
            return filmDA.selectByTitle(film);
        }

    }
}
