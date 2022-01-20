package com.splio.examples.people.kafka;

import com.splio.examples.people.metrics.PrometheusMetrics;
import com.splio.examples.people.mysql.Repository;
import com.splio.people.PeopleAvro;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class KafkaTransport {

    private static final Logger LOGGER = Logger.getLogger(KafkaTransport.class);

    @Inject
    Repository repository;

    @Inject
    PrometheusMetrics metrics;

    /*
    Example of a Kafka processing pipeline, that will consume a topic & then produce into another one if
    the person is found ! With logs & metrics
    @Incoming are used for producers & @Outgoing for consumers
    You can use smallrye Mutiny reactive Uni & Multi, but it's not mandatory
    https://quarkus.io/guides/kafka
    https://smallrye.io/smallrye-reactive-messaging/smallrye-reactive-messaging/3.4/index.html
     */

    @Incoming("id-channel")
    @Outgoing("people-channel")
    public Uni<PeopleAvro> findPeople(Long PeopleID) {
        LOGGER.infof("Trying to find the people : %d", PeopleID);

        return repository.fetchByID(PeopleID)
                .onItem()
                .ifNotNull()
                .invoke(people -> metrics.incrementCountPersonFound())
                .map(people -> PeopleAvro.newBuilder()
                        .setName(people.Name())
                        .setId(people.ID())
                        .setBirthday(people.Birthday())
                        .build());
    }
}
