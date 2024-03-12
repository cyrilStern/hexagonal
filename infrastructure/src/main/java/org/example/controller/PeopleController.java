package org.example.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.example.people.entity.People;
import org.example.people.service.PeopleService;

@Path("/")
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(final PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Path("hello")
    @GET
    public People test() {
        return peopleService.retrieve(12);
    }

}
