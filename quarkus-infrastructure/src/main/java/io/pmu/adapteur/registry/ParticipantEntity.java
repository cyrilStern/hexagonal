package io.pmu.adapteur.registry;

import io.pmu.race.entity.Participant;
import io.pmu.race.entity.Race;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@ApplicationScoped
@Entity
@Table(name = "participant")

public class ParticipantEntity {
    @Id
    @GeneratedValue
    Long id;
    String name;
    int number;

    @ManyToOne
    @JoinColumn(name = "race_id")
    RaceEntity race;

    public static ParticipantEntity from(Participant p) {
        final ParticipantEntity participantEntity = new ParticipantEntity();
        participantEntity.name = p.name();
        participantEntity.number = p.number();
        return participantEntity;
    }

}
