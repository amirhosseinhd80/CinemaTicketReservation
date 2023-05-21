package org.j2os.project.api;

import org.j2os.project.common.EXCEPTION;
import org.j2os.project.common.JSON;
import org.j2os.project.domain.Cinema;
import org.j2os.project.service.CinemaService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/cinema")
public class CinemaAPI {
    @Path("/buy")
    @GET
    @Produces("application/json")
    public String buy(@QueryParam("personId") String personId, @QueryParam("filmId") String filmId ) throws Exception {
        try {
          long id =  CinemaService.getInstance().buy(Long.parseLong(personId) ,Long.parseLong(filmId));
          return findOneById(String.valueOf(id));
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }
    }
    @Path("/findAll")
    @GET
    @Produces("application/json")
    public String findAll() throws Exception {
        try {
            return JSON.getString(CinemaService.getInstance().findAll());
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }

    }
    @Path("/findOneById")
    @GET
    @Produces("application/json")
    public String findOneById(@QueryParam("id") String id) throws Exception {
        try {
            Cinema cinema = new Cinema().setId(Long.parseLong(id));
            return JSON.getString(CinemaService.getInstance().findOneById(cinema));
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }

    }
    @Path("/reservedFromTo")
    @GET
    @Produces("application/json")
    public String reservedFromTo(@QueryParam("from") String from ,@QueryParam("to") String to ) throws Exception {
        try {
            return JSON.getString(CinemaService.getInstance().reservedFromTo(Integer.parseInt(from),Integer.parseInt(to)));
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }

    }
}
