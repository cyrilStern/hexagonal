package io.pmu.race.dto;


import io.pmu.race.exception.RaceException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

 class RaceDTOTest {


    // Creating a new RaceDTO object with valid parameters should not throw any exceptions.
    @Test
     void test_valid_parameters() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String name = "Race";
        Long number = 1L;
        List<ParticipantDTO> participantDTOList = List.of(new ParticipantDTO(1, name));

        RaceDTO raceDTO = new RaceDTO(localDateTime, name, number, participantDTOList);

        assertEquals(localDateTime, raceDTO.localDateTime());
        assertEquals(name, raceDTO.name());
        assertEquals(number, raceDTO.number());
        assertEquals(participantDTOList, raceDTO.participantDTOList());
    }

    // The localDateTime, name, number, and participantDTOList parameters should be correctly assigned to the new RaceDTO object.
    @Test
     void test_parameter_assignment() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String name = "Race";
        Long number = 1L;
        List<ParticipantDTO> participantDTOList = List.of(new ParticipantDTO(1, name));

        RaceDTO raceDTO = new RaceDTO(localDateTime, name, number, participantDTOList);

        assertEquals(localDateTime, raceDTO.localDateTime());
        assertEquals(name, raceDTO.name());
        assertEquals(number, raceDTO.number());
        assertEquals(participantDTOList, raceDTO.participantDTOList());
    }

    // Creating a new RaceDTO object with a null localDateTime parameter should throw a NullPointerException.
    @Test
     void test_null_localDateTime() {
        String name = "Race";
        Long number = 1L;
        List<ParticipantDTO> participantDTOList = List.of(new ParticipantDTO(1, "race"));

        assertThrows(RaceException.class, () -> new RaceDTO(null, name, number, participantDTOList));
    }

    // Creating a new RaceDTO object with a null name parameter should throw a NullPointerException.
    @Test
     void test_null_name() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Long number = 1L;
        List<ParticipantDTO> participantDTOList = List.of(new ParticipantDTO(1, "race"));

        assertThrows(RaceException.class, () -> new RaceDTO(localDateTime, null, number, participantDTOList));
    }

    // Creating a new RaceDTO object with a null number parameter should throw a NullPointerException.
    @Test
     void test_null_number() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String name = "Race";
        List<ParticipantDTO> participantDTOList = List.of(new ParticipantDTO(1, "race"));

        assertThrows(RaceException.class, () -> new RaceDTO(localDateTime, name, null, participantDTOList));
    }

}
