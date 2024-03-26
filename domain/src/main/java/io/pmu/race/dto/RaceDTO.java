package io.pmu.race.dto;

import io.pmu.race.exception.ParticipantNumberException;
import io.pmu.race.exception.RaceException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public record RaceDTO(LocalDateTime localDateTime, String name, Long number, List<ParticipantDTO> participantDTOList) {
    public RaceDTO {
        try {
            Objects.requireNonNull(localDateTime);
            Objects.requireNonNull(name);
            Objects.requireNonNull(number);
            Objects.requireNonNull(participantDTOList);
        } catch (NullPointerException exception){
            throw new RaceException();
        }
        if(participantDTOList.size() < 3) throw new ParticipantNumberException(); // should always have participants > 2
    }
}
