/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template.universe.client;

import com.splio.template.universe.model.Universe;
import io.smallrye.mutiny.Uni;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/universes")
@RegisterRestClient(configKey = "subscription-service.rest-api")
public interface UniverseClient {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  Uni<Set<Universe>> getAllUniverses();
}
