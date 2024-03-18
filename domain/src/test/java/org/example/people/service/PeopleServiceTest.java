/** Copyright (c) 2024 Splio.com All rights reserved. */
package org.example.people.service;

import static org.mockito.Mockito.*;

import java.util.List;

import org.example.people.entity.HumanType;
import org.example.people.entity.People;
import org.example.people.port.repository.PeopleRegistryPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PeopleServiceTest {
  static final PeopleRegistryPort peopleRegistryPort = mock(TestRepository.class);
  PeopleService peopleService;
  @BeforeAll
  static void setUp() {
    Mockito.when(peopleRegistryPort.retrieve(anyInt())).thenReturn(new People(12, "",List.of()));
  }
  @BeforeEach
  void before(){
    peopleService = new PeopleService(peopleRegistryPort);

  }
  private static class TestRepository implements PeopleRegistryPort {
    @Override
    public People retrieve(int id) {
      return new People(12, "", List.of());
    }
  }

  @Test
  void retrieve() {
    Assertions.assertEquals(new People(12, "", List.of()).age(), peopleService.retrieve(1).age());
  }

  @Test
  void isAdult() {
    final People retrieve = peopleService.retrieve(22);
    Assertions.assertEquals(HumanType.CHILD, peopleService.kindOfPeople(retrieve));
  }
}
