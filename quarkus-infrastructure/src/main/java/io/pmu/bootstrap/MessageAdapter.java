package io.pmu.bootstrap;

import io.pmu.race.dto.RaceDTO;
import io.pmu.race.port.connector.MessageConnector;
import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Message;
@ApplicationScoped
public class MessageAdapter implements MessageConnector<RaceDTO> {

    final MutinyEmitter<RaceDTO> raceDTOMutinyEmitter;

    public MessageAdapter(@Channel("race") MutinyEmitter<RaceDTO> raceDTOMutinyEmitter) {
        this.raceDTOMutinyEmitter = raceDTOMutinyEmitter;
    }
    @Override
    public void sendMessage(RaceDTO message) {
        raceDTOMutinyEmitter.sendMessage(Message.of(message))
                .onFailure()
                .retry()
                .atMost(3)
                .await()
                .indefinitely();

    }
}
