/** Copyright (c) 2024 Splio.com All rights reserved. */
package org.example.adapteur.registry;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.example.people.entity.People;
import org.example.people.port.repository.PeopleRegistryPort;

@ApplicationScoped
public class PeopleRegistryAdapter implements PeopleRegistryPort {
  @Override
  public People retrieve(int id) {
    return new People(12, "Alfounet", List.of());
  }
}
