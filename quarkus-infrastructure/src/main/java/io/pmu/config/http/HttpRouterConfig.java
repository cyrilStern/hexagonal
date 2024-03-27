/** Copyright (c) 2023 Splio.com All rights reserved. */
package io.pmu.config.http;

import io.vertx.ext.web.Router;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.regex.Pattern;

@ApplicationScoped
public class HttpRouterConfig {
  private static final Pattern NO_ALLOWED_PATH =
      Pattern.compile("^((?!\\/api\\/|\\/q\\/|\\/metrics|\\/health|\\/dev-ui).)+$");
  private static final String SWAGGER_UI_END_POINT = "/api/docs";

  public void init(@Observes Router router) {
    router.routeWithRegex(NO_ALLOWED_PATH.pattern()).handler(r -> r.reroute(SWAGGER_UI_END_POINT));
  }
}
