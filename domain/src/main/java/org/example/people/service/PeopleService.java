/** Copyright (c) 2024 Splio.com All rights reserved. */
package org.example.people.service;

import org.example.people.entity.HumanType;
import org.example.people.entity.People;
import org.example.people.port.repository.PeopleRegistryPort;

public class PeopleService {
  private final PeopleRegistryPort peopleRegistryPort;

  public PeopleService(PeopleRegistryPort peopleRegistryPort) {
    this.peopleRegistryPort = peopleRegistryPort;
  }

  public People retrieve(int id) {
    return peopleRegistryPort.retrieve(id);
  }

  public HumanType kindOfPeople(People people){
    return switch (people){
      case People(Integer age,_,_) when age <= 5 -> HumanType.BABY;
      case People(Integer age,_,_) when age < 18 -> HumanType.CHILD;
      default  -> HumanType.ADULT;
    };
  }
}
