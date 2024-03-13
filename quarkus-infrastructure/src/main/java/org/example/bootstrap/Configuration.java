/** Copyright (c) 2024 Splio.com All rights reserved. */
package org.example.bootstrap;

import jakarta.enterprise.inject.Default;
import org.example.people.port.repository.PeopleRegistryPort;
import org.example.people.service.PeopleService;

public class Configuration {
  @Default
  public PeopleService peopleService(PeopleRegistryPort peopleRegistryPort) {
    return new PeopleService(peopleRegistryPort);
  }
}
