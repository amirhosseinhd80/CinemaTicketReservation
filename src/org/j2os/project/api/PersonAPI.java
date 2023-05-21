package org.j2os.project.api;

import org.j2os.project.common.EXCEPTION;
import org.j2os.project.common.JSON;
import org.j2os.project.domain.Person;
import org.j2os.project.service.PersonService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/person")
public class PersonAPI {
    @Path("/save")
    @GET
    @Produces("application/json")
    public String save(@QueryParam("name") String name, @QueryParam("family") String family) throws Exception {
        try {
            Person person = new Person().setFamily(family).setName(name);
            PersonService.getInstance().save(person);
            return findOneById(String.valueOf(person.getId()));
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }
    }
    @Path("/find")
    @GET
    @Produces("application/json")
    public String find(@QueryParam("search") String search) throws Exception {
        try {
            return JSON.getString(PersonService.getInstance().find(search));
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }
    }

    @Path("/findAll")
    @GET
    @Produces("application/json")
    public String findAll() throws Exception {
        try {
            return JSON.getString(PersonService.getInstance().findAll());
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }

    }
    @Path("/findOneById")
    @GET
    @Produces("application/json")
    public String findOneById(@QueryParam("id") String id) throws Exception {
        try {
            Person person = new Person().setId(Long.parseLong(id));
            return JSON.getString(PersonService.getInstance().findOneById(person));
        } catch (Exception e) {
            return JSON.getString(EXCEPTION.getError(e));
        }

    }
}
