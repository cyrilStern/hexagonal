/** Copyright (c) 2024 Splio.com All rights reserved. */
package io.pmu.race.service;

import io.pmu.race.dto.RaceDTO;
import io.pmu.race.entity.Race;
import io.pmu.race.port.connector.MessageConnector;
import io.pmu.race.port.repository.RaceRegistryPort;

import java.time.LocalDateTime;
import java.util.Optional;

public class RaceService {
  private final RaceRegistryPort peopleRegistryPort;
  private final MessageConnector<RaceDTO> messageConnector;

  public RaceService(RaceRegistryPort peopleRegistryPort, MessageConnector<RaceDTO> messageConnector) {
    this.peopleRegistryPort = peopleRegistryPort;
    this.messageConnector = messageConnector;
  }


  /**
   * retrieve a race from the date and the number of the provide race to save
   * @param id number of the race
   * @param localDateTime estimate that a race as a year month day and hour
   * @return Optional<Race>
   */
  public Optional<Race> retrieve(long id, LocalDateTime localDateTime) {
    return peopleRegistryPort.retrieve(id, localDateTime);
  }

  /**
   * check if race exist, if exist raise error, if not save it to db and send it to broker as kafka, rabbit....
   * Circuit breaker, and retry should be handled by infrastructure
   * @param raceDTO race dto from controller
   * @return just the raceDto, no need more information as id save in db
   * @throws DuplicationException
   */
  public RaceDTO saveAndSendMessage(RaceDTO raceDTO) throws DuplicationException {
    retrieve(raceDTO.number(), raceDTO.localDateTime()).ifPresent(e -> {throw new DuplicationException();}); // if exist run exception
    peopleRegistryPort.save(Race.from(raceDTO));
    messageConnector.sendMessage(raceDTO);
    return raceDTO;
  }
}
