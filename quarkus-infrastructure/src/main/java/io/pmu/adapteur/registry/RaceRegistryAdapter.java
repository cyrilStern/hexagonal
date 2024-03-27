package io.pmu.adapteur.registry;

import io.pmu.race.entity.Participant;
import io.pmu.race.entity.Race;
import io.pmu.race.port.repository.RaceRegistryPort;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@ApplicationScoped
public class RaceRegistryAdapter  implements RaceRegistryPort, PanacheRepository<RaceEntity> {

    @Override
    public Optional<Race> retrieve(long number, LocalDateTime localDateTime) {
        var date = new Timestamp(localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli());
        return find("number = ?1 and date = ?2", number, date)
                .firstResultOptional()
                .map(entity -> new Race(entity.id, entity.number, entity.name, entity.date.toLocalDateTime(), entity.participantList.stream().map(participantEntity -> new Participant(participantEntity.id, participantEntity.name, participantEntity.number)).toList()));
    }

    @Override
    @Transactional
    public void save(Race race) {
        var raceAdapter = new RaceEntity();
        raceAdapter.date = new Timestamp(race.localDateTime().toInstant(ZoneOffset.UTC).toEpochMilli());
        raceAdapter.name = race.name();
        raceAdapter.number = race.number();
        raceAdapter.participantList = race.participantList().stream().map(ParticipantEntity::from).toList();
        persist(raceAdapter);
        flush();
    }
}
