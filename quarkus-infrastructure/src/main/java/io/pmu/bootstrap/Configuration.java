/**
 * Copyright (c) 2024 Splio.com All rights reserved.
 */
package io.pmu.bootstrap;

import io.pmu.adapteur.registry.RaceRegistryAdapter;
import io.pmu.race.dto.RaceDTO;
import io.smallrye.reactive.messaging.MutinyEmitter;
import jakarta.enterprise.inject.Default;
import io.pmu.race.service.RaceService;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;

public class Configuration {

    @Default
    @Produces
    public RaceService raceService(RaceRegistryAdapter raceRegistryAdapter, MessageAdapter messageAdapter) {
        return new RaceService(raceRegistryAdapter, messageAdapter);
    }

}
