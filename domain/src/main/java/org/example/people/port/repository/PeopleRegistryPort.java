package org.example.people.port.repository;

import org.example.people.entity.People;

/**
 * port registry people
 */
public interface PeopleRegistryPort {
    People retrieve(int id);
}
