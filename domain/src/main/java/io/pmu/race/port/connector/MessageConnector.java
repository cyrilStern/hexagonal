package io.pmu.race.port.connector;

public interface MessageConnector<T> {
     void sendMessage(T message);
}
