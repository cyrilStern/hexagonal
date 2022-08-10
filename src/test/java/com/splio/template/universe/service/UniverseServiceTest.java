/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template.universe.service;

import static org.junit.jupiter.api.Assertions.*;

import com.splio.template.universe.model.Universe;
import io.quarkus.test.junit.QuarkusTest;
import java.util.Set;
import javax.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UniverseServiceTest {
  @Inject UniverseService universeService;

  @Test
  @DisplayName("should return a valid universe")
  void getActiveUniverses() {
    final Set<Universe> indefinitely = universeService.getActiveUniverses().await().indefinitely();
    assertFalse(indefinitely.isEmpty());
  }
}
