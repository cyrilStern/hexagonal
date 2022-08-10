/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.splio.template.universe.model.Universe;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import io.smallrye.reactive.messaging.providers.connectors.InMemoryConnector;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testcontainers.containers.MySQLContainer;

public class QuarkusTestResources implements QuarkusTestResourceLifecycleManager {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private MySQLContainer db;
  private WireMockServer wireMockServer;

  @Override
  public Map<String, String> start() {
    /*
    You can declare InMemoryConnector to replace Kafka topics inside tests !
    https://quarkus.io/guides/getting-started-testing
     */
    Map<String, String> conf = new HashMap<>();
    // replace the loyalty-subscriptions channel, which is supposed to be a Kafka topic, by an
    // InMemory structure
    Map<String, String> peopleTopic =
        InMemoryConnector.switchOutgoingChannelsToInMemory("people-channel");
    Map<String, String> idTopic = InMemoryConnector.switchIncomingChannelsToInMemory("id-channel");
    startMockServer(conf);
    startMysqlDB(conf);
    conf.putAll(idTopic);
    conf.putAll(peopleTopic);
    return conf;
  }

  private void startMysqlDB(Map<String, String> conf) {
    db =
        new MySQLContainer<>("mysql:5.7.34") // this could be upgrade regarding your msql version
            .withInitScript("init_mysql.sql")
            .withUsername("user")
            .withPassword("password")
            .withDatabaseName("data_alfounet")
            .withEnv("MYSQL_ROOT_HOST", "%");
    db.start();
    System.out.printf(
        "mysql port mapper: %s%n",
        db.getFirstMappedPort()); // this is needed to get port mapping database
    conf.put("quarkus.datasource.reactive.url", db.getJdbcUrl().replace("jdbc:", ""));
    conf.put("quarkus.datasource.reactive.host", db.getHost());
    conf.put("quarkus.datasource.reactive.port", db.getFirstMappedPort().toString());
    conf.put("quarkus.datasource.username", db.getUsername());
    conf.put("quarkus.datasource.password", db.getPassword());
  }

  private void startMockServer(Map<String, String> conf) {
    wireMockServer = new WireMockServer();
    wireMockServer.start();
    try {
      stubFor(
          get(urlEqualTo("/universes"))
              .willReturn(
                  aResponse()
                      .withHeader("Content-Type", "application/json")
                      .withBody(
                          OBJECT_MAPPER.writeValueAsString(
                              List.of(
                                  new Universe(
                                      LocalDateTime.now()
                                          .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                                      false,
                                      1,
                                      "alfounet",
                                      false,
                                      false,
                                      false,
                                      LocalDateTime.now()
                                          .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))))));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    conf.put(
        "quarkus.rest-client.\"com.splio.universe.client.UniverseClient\".url",
        wireMockServer.baseUrl());
  }

  @Override
  public void stop() {
    if (db != null) db.stop();
    if (wireMockServer != null) wireMockServer.stop();
    InMemoryConnector.clear();
  }
}
