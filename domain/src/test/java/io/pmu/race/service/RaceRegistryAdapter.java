package io.pmu.race.service;

import io.pmu.race.entity.Race;
import io.pmu.race.port.repository.RaceRegistryPort;

import java.time.LocalDateTime;
import java.util.Optional;

public class RaceRegistryAdapter implements RaceRegistryPort {
    @Override
    public Optional<Race> retrieve(long number, LocalDateTime localDateTime) {
        return Optional.empty();
    }

    @Override
    public void save(Race race) {
    }
}
