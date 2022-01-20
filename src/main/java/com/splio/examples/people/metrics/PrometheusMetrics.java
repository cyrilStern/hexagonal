package com.splio.examples.people.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PrometheusMetrics {

    /*
    The micrometer registry makes you able the public metrics to the endpoint /metrics
    (configurable in applications.properties)
    These metrics will be able to be scrapped by Prometheus & exported !
    https://quarkus.io/guides/micrometer
     */

    @Inject
    MeterRegistry meterRegistry;

    private static final String METRIC_NAME = "nb_of_people_found";

    public void incrementCountPersonFound() {
        meterRegistry.counter(METRIC_NAME, Tags.of("my_custom_tag", "Quarkus-template-example")).increment();
    }

}
