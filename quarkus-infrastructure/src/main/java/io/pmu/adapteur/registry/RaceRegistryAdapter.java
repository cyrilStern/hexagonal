package io.pmu.adapteur.registry;

import io.pmu.race.entity.Participant;
import io.pmu.race.entity.Race;
import io.pmu.race.port.repository.RaceRegistryPort;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.inject.Default;
import jakarta.persistence.Entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
@Default
@Entity
public class RaceRegistryAdapter extends PanacheEntity implements RaceRegistryPort {
    Long id;
    long number;
    String name;
    Timestamp date;
    List<Participant> participantList;

    @Override
    public Optional<Race> retrieve(long number, LocalDateTime localDateTime) {
        return find("number = ?1 and date = ?2", number, localDateTime).project(Race.class).firstResultOptional();
    }

    @Override
    public void save(Race race) {
         var raceAdapter = new RaceRegistryAdapter();
        raceAdapter.date = new Timestamp(race.localDateTime().toInstant(ZoneOffset.UTC).toEpochMilli());
        raceAdapter.name = race.name();
        raceAdapter.participantList = race.participantList();
        raceAdapter.persist();
    }
}
