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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.List;

@ApplicationScoped
@Entity
@Table(name = "race")
public class RaceEntity {
    @Id
    @GeneratedValue
    Long id;
    long number;
    String name;
    Timestamp date;
    @OneToMany(mappedBy = "race")
    List<ParticipantEntity> participantList;
}
