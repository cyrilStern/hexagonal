/** Copyright (c) 2024 Splio.com All rights reserved. */
package org.example.controller;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.example.people.entity.People;
import org.example.people.service.PeopleService;
@RunOnVirtualThread
@Path("/")
public class PeopleController {
  private final PeopleService peopleService;

  public PeopleController(final PeopleService peopleService) {
    this.peopleService = peopleService;
  }

  @Path("people/{id}")
  @GET
  public People test(int id) {
    return peopleService.retrieve(id);
  }
}
