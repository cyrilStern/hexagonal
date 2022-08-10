/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template.configuration.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PrometheusMetrics {
  private static final String METRIC_NAME = "nb_of_people_found";

  private final MeterRegistry meterRegistry;

  /*
  The micrometer registry makes you able the public metrics to the endpoint /metrics
  (configurable in applications.properties)
  These metrics will be able to be scrapped by Prometheus & exported !
  https://quarkus.io/guides/micrometer
   */

  public PrometheusMetrics(final MeterRegistry meterRegistry) {
    this.meterRegistry = meterRegistry;
  }

  public void incrementCountPersonFound() {
    meterRegistry
        .counter(METRIC_NAME, Tags.of("my_custom_tag", "Quarkus-template-example"))
        .increment();
  }
}
