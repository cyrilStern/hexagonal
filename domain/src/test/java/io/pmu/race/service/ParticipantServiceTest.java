/**
 * Copyright (c) 2024 Splio.com All rights reserved.
 */
package io.pmu.race.service;

import io.pmu.race.dto.ParticipantDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantServiceTest {


    @Test
    void controlParticipantNumberWithZeroParticipant() {
        List<ParticipantDTO> participants = List.of();
        assertDoesNotThrow(() -> ParticipantService.controlParticipantNumber(participants));
    }

    @Test
    void controlParticipantNumberWithOneParticipant() {
        List<ParticipantDTO> participants = List.of(new ParticipantDTO(1, "name_1"));
        assertDoesNotThrow(() -> ParticipantService.controlParticipantNumber(participants));
    }

    @Test
    void controlParticipantNumberWithTwoParticipant() {
        List<ParticipantDTO> participants = List.of(new ParticipantDTO(1, "name_1"), new ParticipantDTO(2, "name_2"));
        assertDoesNotThrow(() -> ParticipantService.controlParticipantNumber(participants));

    }

    @Test
    void controlParticipantNumberWithThreeParticipant() {
        List<ParticipantDTO> participants = List.of(new ParticipantDTO(1, "name_1"), new ParticipantDTO(2, "name_2"), new ParticipantDTO(3, "name_2"));
        assertDoesNotThrow(() -> ParticipantService.controlParticipantNumber(participants));
    }

    @Test
    void controlParticipantNumberWithThreeParticipantCheckOrder() {
        List<ParticipantDTO> participants = List.of(new ParticipantDTO(2, "name_1"), new ParticipantDTO(1, "name_2"), new ParticipantDTO(3, "name_2"));
        assertDoesNotThrow(() -> ParticipantService.controlParticipantNumber(participants));
    }

    @Test
    void controlParticipantNumberWithThreeParticipantWithUnfollowNumber() {
        List<ParticipantDTO> participants = List.of(new ParticipantDTO(1, "name_1"), new ParticipantDTO(2, "name_2"), new ParticipantDTO(5, "name_2"));
        assertThrows(ParticapantExeption.class, () -> ParticipantService.controlParticipantNumber(participants));
    }
}
