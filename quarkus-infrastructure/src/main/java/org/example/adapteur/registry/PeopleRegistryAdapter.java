/** Copyright (c) 2024 Splio.com All rights reserved. */
package org.example.adapteur.registry;

import io.vertx.mutiny.mysqlclient.MySQLPool;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import org.example.people.entity.People;
import org.example.people.port.repository.PeopleRegistryPort;

import java.util.List;
@Default
@ApplicationScoped
public class PeopleRegistryAdapter implements PeopleRegistryPort {
  @Override
  public People retrieve(int id) {
    return new People(12, "Alfounet", List.of());
  }
}
