package io.pmu.race.dto;

import java.util.Objects;

public record ParticipantDTO(int number, String name) {
    public ParticipantDTO {
        // number could not be null => 0
        Objects.requireNonNull(name);
    }
}
