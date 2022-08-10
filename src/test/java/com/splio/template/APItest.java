/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template;

import static io.restassured.RestAssured.given;

import com.splio.template.people.model.People;
import com.splio.template.people.repository.Repository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Uni;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@QuarkusTest
public class APItest {

  @InjectMock Repository mockRepository;

  @BeforeEach
  public void setUp() {
    /* You can easily mock some services/classes by using @InjectMock */
    Mockito.when(mockRepository.fetchByID(1L))
        .thenReturn(Uni.createFrom().item(new People("test", 1L, LocalDate.now())));
  }

  @Test
  public void testPeopleEndpoint() {
    given().when().get("/people/1").then().statusCode(200);
  }
}
