package org.acme.resource;


import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;
import dto.SapatoDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class SapatoResourceTest {
    @Test
    public void findAllTest (){

        given()
        .when()
        .get("/sapatos/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void findByIdTest() {
    
        given()
        .when()
        .get("/sapatos/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

  

    @Test
    public void createTest() {
        SapatoDTO dto = new SapatoDTO(34.0, 1111, 41, 2L, 1L, 1L, 1L);
    
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/sapatos")
            .then()
            .statusCode(200)
            .body("id", is(3));
    }

    @Test
    public void updateTest() {
        SapatoDTO dto = new SapatoDTO(35.0, 2, 39, 2L, 1L, 1L, 1L);
    
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .put("/sapatos/1")
            .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest() {
        given()
            .when()
            .delete("/sapatos/1")
            .then()
            .statusCode(204);
    }
}


