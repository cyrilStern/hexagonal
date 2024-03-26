package io.pmu.race.entity;

import io.pmu.race.dto.ParticipantDTO;

import java.util.List;

public record Participant(Long id, String name, int number) {
    public Participant(String name, int number) {
        this(null, name, number);
    }

    public static List<Participant> from(List<ParticipantDTO> participantDTOS) {
        return participantDTOS.stream().map(dto -> new Participant(dto.name(), dto.number())).toList();
    }
}
