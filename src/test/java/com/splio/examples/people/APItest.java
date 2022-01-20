package com.splio.examples.people;

import com.splio.examples.people.MySQL.Repository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class APItest {

    @InjectMock
    Repository mockRepository;

    @BeforeEach
    public void setUp() {
        /* You can easily mock some services/classes by using @InjectMock */
        Mockito.when(mockRepository.fetchByID(1L))
                .thenReturn(Uni.createFrom().item(
                        new People("test", 1L, LocalDate.now())
                ));
    }

    @Test
    public void testPeopleEndpoint() {
        given()
        .when()
            .get("/people/1")
        .then()
            .statusCode(200);
    }

}