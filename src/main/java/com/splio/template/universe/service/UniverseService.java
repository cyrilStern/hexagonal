/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template.universe.service;

import com.splio.template.universe.client.UniverseClient;
import com.splio.template.universe.model.Universe;
import io.quarkus.cache.CacheResult;
import io.smallrye.mutiny.Uni;
import java.util.Set;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Slf4j
@ApplicationScoped
public class UniverseService {
  private final UniverseClient universeClient;

  public UniverseService(@RestClient final UniverseClient universeClient) {
    this.universeClient = universeClient;
  }

  @CacheResult(cacheName = "GetAllActiveUniverses")
  public Uni<Set<Universe>> getActiveUniverses() {
    return universeClient
        .getAllUniverses()
        .map(
            universes ->
                universes.stream()
                    .filter(universe -> !universe.isExpired() && !universe.isInMaintenance())
                    .collect(Collectors.toSet()));
  }
}
