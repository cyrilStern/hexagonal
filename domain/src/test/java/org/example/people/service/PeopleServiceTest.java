/** Copyright (c) 2023 Splio.com All rights reserved. */
package org.example.people.service;

import static org.mockito.Mockito.*;

import java.util.List;
import org.example.people.entity.People;
import org.example.people.port.repository.PeopleRegistryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PeopleServiceTest {
  private static class TestRepository implements PeopleRegistryPort {
    @Override
    public People retrieve(int id) {
      return new People(12, "", List.of());
    }
  }

  @Test
  void retrieve() {
    PeopleRegistryPort peopleRegistryPort = mock(TestRepository.class);
    Mockito.when(peopleRegistryPort.retrieve(anyInt())).thenReturn(new People(12, "", List.of()));
    final PeopleService peopleService = new PeopleService(peopleRegistryPort);
    Assertions.assertEquals(new People(12, "", List.of()).age(), peopleService.retrieve(1).age());
  }
}
