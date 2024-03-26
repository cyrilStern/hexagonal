/** Copyright (c) 2024 Splio.com All rights reserved. */
package io.pmu.race.port.repository;

import io.pmu.race.entity.Race;

import java.time.LocalDateTime;
import java.util.Optional;

/** port registry people */
public interface RaceRegistryPort {
  Optional<Race> retrieve(long number, LocalDateTime localDateTime);
  void save(Race race);
}
