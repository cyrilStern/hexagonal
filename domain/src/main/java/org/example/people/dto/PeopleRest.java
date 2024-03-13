/** Copyright (c) 2024 Splio.com All rights reserved. */
package org.example.people.dto;

import static java.lang.StringTemplate.STR;

import org.example.people.entity.Address;
import org.example.people.entity.People;

public record PeopleRest(String name, String address) {
  public static PeopleRest from(People people, Address address) {
    return new PeopleRest(
        people.name(), STR."country: \{address.country()} + address: \{address.street()}");
  }
}
