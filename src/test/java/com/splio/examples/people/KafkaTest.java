package com.splio.examples.people;

import com.splio.examples.people.MySQL.Repository;
import com.splio.people.PeopleAvro;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.providers.connectors.InMemoryConnector;
import io.smallrye.reactive.messaging.providers.connectors.InMemorySink;
import io.smallrye.reactive.messaging.providers.connectors.InMemorySource;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.time.LocalDate;

import static org.awaitility.Awaitility.await;

@QuarkusTest
@QuarkusTestResource(QuarkusTestResources.class)
public class KafkaTest {

    @Inject
    @Any
    InMemoryConnector connector;

    @InjectMock
    Repository mockRepository;

    @BeforeEach
    public void setUp() {
        /* You can easily mock some services/classes by using @InjectMock */
        Mockito.when(mockRepository.fetchByID(1L))
                .thenReturn(Uni.createFrom().item(
                        new People("test", 1L, LocalDate.now())
                ));
    }

    @Test
    public void testKafkaPipeline() {
        /* Mock the Kafka topics by inMemory channels thanks to @QuarkusTestResource*/
        InMemorySink<PeopleAvro> peopleChannel = connector.sink("people-channel");
        InMemorySource<Long> idChannel = connector.source("id-channel");

        // GIVEN
        idChannel.send(1L);

        // WHEN
        await().until(peopleChannel::received, t -> t.size() > 0);

        // THEN
        Assertions.assertEquals(1, peopleChannel.received().size());
        PeopleAvro result = peopleChannel.received().get(0).getPayload();
        Assertions.assertEquals(1L, result.getId());
        Assertions.assertEquals("test", result.getName());
        Assertions.assertEquals(LocalDate.now(), result.getBirthday());
    }
}