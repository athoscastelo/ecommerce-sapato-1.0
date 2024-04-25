
package org.acme.resource;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import dto.SapatoDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class SapatoResourceTest {
    @Test
    public void createTest(){
        SapatoDTO dto = new SapatoDTO(11.0, 111, 39, 1L,1L,1L,1L);
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/sapatos")
        .then()
        .statusCode(201)
        .body("id", is(1));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/sapatos")
        .then()
        .statusCode(200)
        .body("id", hasItem(is(1)));;
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/sapatos/1")
        .then()
        .statusCode(200)
        .body("id", hasItem(is(1)));
    }

    @Test
    public void updateTest(){
        SapatoDTO dto = new SapatoDTO(20.0, 130, 40, 2L,2L,2L,2L);

        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/sapatos/1")
        .then()
        .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 1)
        .delete("/sapatos/{id}")
        .then()
        .statusCode(204);
    }
}



