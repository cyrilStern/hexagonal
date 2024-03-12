package org.example.people.dto;

import org.example.people.entity.Address;
import org.example.people.entity.People;

import static java.lang.StringTemplate.STR;

public record PeopleRest(String name, String address) {
    public static PeopleRest from(People people, Address address){
        return new PeopleRest(people.name(), STR."country: \{address.country()} + address: \{address.street()}");
    }
}
