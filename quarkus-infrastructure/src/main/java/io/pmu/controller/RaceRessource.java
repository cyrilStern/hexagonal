/** Copyright (c) 2024 Splio.com All rights reserved. */
package io.pmu.controller;

import io.pmu.race.dto.RaceDTO;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import io.pmu.race.service.RaceService;
@RunOnVirtualThread
@Path("/api/v1/race")
public class RaceRessource implements io.pmu.race.port.controller.RaceController {
  private final RaceService raceService;

  public RaceRessource(final RaceService raceService) {
    this.raceService = raceService;
  }

  @POST
  @Override
  public RaceDTO saveRace(RaceDTO raceDTO) {
     return raceService.saveAndSendMessage(raceDTO);
  }
}
