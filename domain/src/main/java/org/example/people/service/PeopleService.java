package org.example.people.service;

import org.example.people.entity.People;
import org.example.people.port.repository.PeopleRegistryPort;

public class PeopleService {
    private final PeopleRegistryPort peopleRegistryPort;

    public PeopleService(PeopleRegistryPort peopleRegistryPort) {
        this.peopleRegistryPort = peopleRegistryPort;
    }

    public People retrieve(int id){
        return peopleRegistryPort.retrieve(id);
    }
}
