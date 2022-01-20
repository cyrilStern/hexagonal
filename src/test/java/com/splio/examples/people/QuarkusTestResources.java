package com.splio.examples.people;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import io.smallrye.reactive.messaging.providers.connectors.InMemoryConnector;

import java.util.HashMap;
import java.util.Map;

public class QuarkusTestResources implements QuarkusTestResourceLifecycleManager {

    @Override
    public Map<String, String> start() {
        /*
        You can declare InMemoryConnector to replace Kafka topics inside tests !
        https://quarkus.io/guides/getting-started-testing
         */
        Map<String, String> conf = new HashMap<>();
        // replace the loyalty-subscriptions channel, which is supposed to be a Kafka topic, by an InMemory structure
        Map<String, String> peopleTopic = InMemoryConnector.switchOutgoingChannelsToInMemory("people-channel");
        Map<String, String> idTopic = InMemoryConnector.switchIncomingChannelsToInMemory("id-channel");

        conf.putAll(idTopic);
        conf.putAll(peopleTopic);
        return conf;
    }

    @Override
    public void stop() {
        InMemoryConnector.clear();
    }
}