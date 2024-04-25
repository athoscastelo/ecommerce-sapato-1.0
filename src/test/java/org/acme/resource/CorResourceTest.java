package org.acme.resource;

import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;

import dto.CorDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CorResourceTest {
    @Test
    public void createTest(){
        CorDTO dto = new CorDTO("azul");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/cores")
        .then()
        .statusCode(200)
        .body("id", is(1));

        CorDTO dto1 = new CorDTO("vermelho");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto1)
        .when()
        .post("/cores")
        .then()
        .statusCode(200)
        .body("id", is(2));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/cores")
        .then()
        .statusCode(200);
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/cores/1")
        .then()
        .statusCode(204)
        .body("id", is(1));
    }

    @Test
    public void updateTest(){
        CorDTO dto = new CorDTO("vermelho");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/cores/1")
        .then()
        .statusCode(204);
    }
    
    
    @Test
    public void deleteTest() {
        given()
            .when()
            .delete("/cores/1")
            .then()
            .statusCode(204);
    }
}