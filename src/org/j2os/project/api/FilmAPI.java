package org.j2os.project.api;

import org.j2os.project.common.EXCEPTION;
import org.j2os.project.common.JSON;
import org.j2os.project.domain.Film;
import org.j2os.project.service.FilmService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/film")
public class FilmAPI {
    @Path("/save")
    @GET
    @Produces("application/json")
    public String save(@QueryParam("title") String title, @QueryParam("from") String from ,@QueryParam("to") String to ,@QueryParam("count") String count ) throws Exception {
        try {
            Film film = new Film().setTitle(title).setFrom(Integer.parseInt(from)).setTo(Integer.parseInt(to)).setCount(Integer.parseInt(count));
            FilmService.getInstance().save(film);
            return findOneById(String.valueOf(film.getId()));
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }
    }

    @Path("/findAll")
    @GET
    @Produces("application/json")
    public String findAll() throws Exception {
        try {
            return JSON.getString(FilmService.getInstance().findAll());
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }

    }
    @Path("/findOneById")
    @GET
    @Produces("application/json")
    public String findOneById(@QueryParam("id") String id) throws Exception {
        try {
            Film film = new Film().setId(Long.parseLong(id));
            return JSON.getString(FilmService.getInstance().findOneById(film.getId()));
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }

    }
    @Path("/findFromTo")
    @GET
    @Produces("application/json")
    public String findFromTo(@QueryParam("from") String from, @QueryParam("to") String to) throws Exception {
        try {
            Film film = new Film().setFrom(Integer.parseInt(from)).setTo(Integer.parseInt(to));
            return JSON.getString(FilmService.getInstance().findFromTo(film));
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }
    }
    @Path("/findTitle")
    @GET
    @Produces("application/json")
    public String findTitle(@QueryParam("title") String title) throws Exception {
        try {
            Film film = new Film().setTitle(title);
            return JSON.getString(FilmService.getInstance().findTitle(film));
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }
    }
}
