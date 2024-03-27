package io.pmu.race.service;

import io.pmu.race.dto.ParticipantDTO;
import io.pmu.race.dto.RaceDTO;
import io.pmu.race.entity.Participant;
import io.pmu.race.entity.Race;
import io.pmu.race.exception.DuplicationException;
import io.pmu.race.exception.ParticipantNumberException;
import io.pmu.race.port.connector.MessageConnector;
import io.pmu.race.port.repository.RaceRegistryPort;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RaceServiceTest {


    // saves a new race to the database and sends a message to the broker
    @Test
    void testSaveNewRaceAndSendMessage() {
        // Arrange
        RaceDTO raceDTO = new RaceDTO(LocalDateTime.now(), "Race 1", 1L, Arrays.asList(
                new ParticipantDTO(1, "Participant 1"),
                new ParticipantDTO(2, "Participant 2"),
                new ParticipantDTO(3, "Participant 3")
        ));

        RaceRegistryPort raceRegistryPort = mock(RaceRegistryAdapter.class);
        MessageConnectorFakeAdapter messageConnector = mock(MessageConnectorFakeAdapter.class);

        RaceService raceService = new RaceService(raceRegistryPort, messageConnector);
        when(raceRegistryPort.retrieve(3L, raceDTO.localDateTime())).thenReturn(Optional.empty());
        // Act
        var race  = raceService.saveAndSendMessage(raceDTO);

        // Assert
        verify(raceRegistryPort, times(1)).save(any());
        verify(messageConnector, times(1)).sendMessage(any());
        assertEquals(raceDTO, race);
    }

    // saves a race with multiple participants to the database and sends a message to the broker
    @Test
    void testSaveRaceWithMultipleParticipantsAndSendMessage() {
        // Arrange
        RaceDTO raceDTO = new RaceDTO(LocalDateTime.now(), "Race 2", 2L, Arrays.asList(
                new ParticipantDTO(1, "Participant 1"),
                new ParticipantDTO(2, "Participant 2"),
                new ParticipantDTO(3, "Participant 3"),
                new ParticipantDTO(4, "Participant 4")
        ));

        RaceRegistryPort raceRegistryPort = mock(RaceRegistryPort.class);
        MessageConnector messageConnector = mock(MessageConnector.class);

        RaceService raceService = new RaceService(raceRegistryPort, messageConnector);

        // Act
        var race = raceService.saveAndSendMessage(raceDTO);

        // Assert
        verify(raceRegistryPort, times(1)).save(any(Race.class));
        verify(messageConnector, times(1)).sendMessage(any());
        assertEquals(raceDTO, race);
    }

    // throws a DuplicationException if a race with the same number and date and time already exists in the database
    @Test
    void testThrowDuplicationException() {
        List<ParticipantDTO> participants = Arrays.asList(
                new ParticipantDTO(1, "Participant 1"),
                new ParticipantDTO(2, "Participant 2"),
                new ParticipantDTO(3, "Participant 3")
        );
        // Arrange
        RaceDTO raceDTO = new RaceDTO(LocalDateTime.now(), "Race 3", 3L, participants);

        RaceRegistryPort raceRegistryPort = mock(RaceRegistryPort.class);
        MessageConnector messageConnector = mock(MessageConnector.class);

        RaceService raceService = new RaceService(raceRegistryPort, messageConnector);

        when(raceRegistryPort.retrieve(3L, raceDTO.localDateTime())).thenReturn(Optional.of(new Race(3L, "duplicated", LocalDateTime.now(), Participant.from(participants))));

        // Act & Assert
        assertThrows(DuplicationException.class, () -> raceService.saveAndSendMessage(raceDTO));
    }

    // throws a ParticipantNumberException if a race is saved with less than three participants
    @Test
    void testThrowParticipantNumberException() {
        // Arrange


        // Act & Assert
        assertThrows(ParticipantNumberException.class, () -> {
            RaceDTO raceDTO = new RaceDTO(LocalDateTime.now(), "Race 4", 4L, Arrays.asList(
                    new ParticipantDTO(1, "Participant 1"),
                    new ParticipantDTO(2, "Participant 2")
            ));

            RaceRegistryPort raceRegistryPort = mock(RaceRegistryPort.class);
            MessageConnector messageConnector = mock(MessageConnector.class);

            RaceService raceService = new RaceService(raceRegistryPort, messageConnector);
            raceService.saveAndSendMessage(raceDTO);
        });
    }

    // saves a race with the minimum number of participants to the database and sends a message to the broker
    @Test
    void test_save_race_with_minimum_participants_and_send_message() {
        // Arrange
        RaceDTO raceDTO = new RaceDTO(LocalDateTime.now(), "Race 5", 5L, Arrays.asList(
                new ParticipantDTO(1, "Participant 1"),
                new ParticipantDTO(2, "Participant 2"),
                new ParticipantDTO(3, "Participant 3")
        ));

        RaceRegistryPort raceRegistryPort = mock(RaceRegistryPort.class);
        MessageConnector messageConnector = mock(MessageConnector.class);

        RaceService raceService = new RaceService(raceRegistryPort, messageConnector);

        // Act
        var race = raceService.saveAndSendMessage(raceDTO);

        // Assert
        verify(raceRegistryPort, times(1)).save(any(Race.class));
        verify(messageConnector, times(1)).sendMessage(any());
        assertEquals(raceDTO, race);
    }

}
