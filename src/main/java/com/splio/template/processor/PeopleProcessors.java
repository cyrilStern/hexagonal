/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template.processor;

import com.splio.people.PeopleAvro;
import com.splio.template.configuration.metrics.PrometheusMetrics;
import com.splio.template.people.repository.Repository;
import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.TracingMetadata;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Metadata;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

@ApplicationScoped
public class PeopleProcessors {

  private static final Logger LOGGER = Logger.getLogger(PeopleProcessors.class);
  private final Repository repository;
  private final PrometheusMetrics metrics;

  public PeopleProcessors(final Repository repository, final PrometheusMetrics metrics) {
    this.repository = repository;
    this.metrics = metrics;
  }

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
  public Uni<Message<PeopleAvro>> findPeople(Message<Long> peopleID) {
    LOGGER.infof("Trying to find the people : %d", peopleID);

    return repository
        .fetchByID(peopleID.getPayload())
        .onItem()
        .ifNotNull()
        .invoke(people -> metrics.incrementCountPersonFound())
        .map(
            people ->
                Message.of(
                        PeopleAvro.newBuilder()
                            .setName(people.Name())
                            .setId(people.ID())
                            .setBirthday(people.Birthday())
                            .build())
                    .addMetadata(Metadata.of(TracingMetadata.fromMessage(peopleID))));
  }
}
