package org.example.adapteur.registry;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.people.entity.People;
import org.example.people.port.repository.PeopleRegistryPort;

import java.util.List;
@ApplicationScoped
public class PeopleRegistryPortAdapter implements PeopleRegistryPort {
    @Override
    public People retrieve(int id) {
        return new People(12, "Alfounet", List.of());
    }
}
