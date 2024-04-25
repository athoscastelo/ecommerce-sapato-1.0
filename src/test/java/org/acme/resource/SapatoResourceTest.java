package org.acme.resource;

import dto.SapatoDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class SapatoResourceTest {
    @Test
    public void findAllTest (){

        given()
        .when()
        .get("/sapatos")
        .then()
        .statusCode(200);
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
        SapatoDTO dto = new SapatoDTO(34.0, 1111, 41, 1L, 1L, 1L, 1L);
    
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/sapatos")
            .then()
            .statusCode(200)
            .body("id", is(1));
        
        SapatoDTO dto1 = new SapatoDTO(34.0, 1111, 39, 1L, 1L, 1L, 1L);
    
            given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto1)
                .when()
                .post("/sapatos")
                .then()
                .statusCode(200)
                .body("id", is(2));
        
            SapatoDTO dto2 = new SapatoDTO(36.0, 2222, 39, 1L, 1L, 1L, 1L);
            
            given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto2)
                .when()
                .post("/sapatos")
                .then()
                .statusCode(200)
                .body("id", is(3));
        
            SapatoDTO dto3 = new SapatoDTO(38.0, 3333, 37, 1L, 1L, 1L, 1L);
            
            given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto3)
                .when()
                .post("/sapatos")
                .then()
                .statusCode(200)
                .body("id", is(4));
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
            .pathParam("id", 1)
            .delete("/sapatos/{id}")
            .then()
            .statusCode(204);
    }


}


