package io.pmu.race.entity;

import io.pmu.race.dto.RaceDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public record Race(Long id, long number, String name, LocalDateTime localDateTime,List<Participant> participantList) {
    public Race(Long number, String name, LocalDateTime localDateTime,List<Participant> participants) {
        this(null , number, name, localDateTime, participants);
    }
    public Race(Long number, String name, Timestamp timestamp, List<Participant> participants) {
        this(null , number, name, timestamp.toLocalDateTime(), participants);
    }

    public static Race from(RaceDTO raceDTO) {
        return new Race(raceDTO.number(), raceDTO.name(), raceDTO.localDateTime(), Participant.from(raceDTO.participantDTOList()));
    }

    public static Race from(RaceDTO raceDTO, long id) {
        return new Race(id, raceDTO.number(), raceDTO.name(), raceDTO.localDateTime(), Participant.from(raceDTO.participantDTOList()));
    }
}
