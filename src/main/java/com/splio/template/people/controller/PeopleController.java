/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template.people.controller;

import com.splio.template.people.model.People;
import com.splio.template.people.repository.Repository;
import io.smallrye.mutiny.Uni;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("")
public class PeopleController {
  private final Repository repository;

  public PeopleController(final Repository repository) {
    this.repository = repository;
  }

  /*
  You can use the REST quarkus that supports both reactive & non-reactive endpoints to create Restful API !
  It supports exception mapping, dynamic path variables...
  https://quarkus.io/guides/resteasy-reactive
   */

  @Path("/people/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Uni<People> findById(String id) {
    return repository
        .fetchByID(Long.valueOf(id))
        .onItem()
        .ifNull()
        .failWith(NotFoundException::new);
  }
}
