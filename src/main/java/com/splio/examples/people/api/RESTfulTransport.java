package com.splio.examples.people.API;

import com.splio.examples.people.MySQL.Repository;
import com.splio.examples.people.People;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("")
public class RESTfulTransport {

    @Inject
    Repository repository;

    /*
    You can use the REST quarkus that supports both reactive & non-reactive endpoints to create RESTful API !
    It supports exception mapping, dynamic path variables...
    https://quarkus.io/guides/resteasy-reactive
     */

    @Path("/people/{id}")
    @GET
    public Uni<People> findById(String id) {
        return repository
                .fetchByID(Long.valueOf(id))
                .onItem()
                .ifNull()
                .failWith(NotFoundException::new);
    }

}
