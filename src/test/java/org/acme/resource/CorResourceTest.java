
package org.acme.resource;

import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.MediaType;
import dto.CorDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CorResourceTest {
    @Test
    public void createTest(){
        CorDTO dto = new CorDTO("bonito");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/cores")
        .then()
        .statusCode(201)
        .body("nome", is("bonito"));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/cores")
        .then()
        .statusCode(200)
        .body("id", hasItem(is(1)));;
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/cores/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void updateTest(){
        CorDTO dto = new CorDTO("Feio");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/cores/3")
        .then()
        .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 1)
        .delete("/cores/{id}")
        .then()
        .statusCode(204);
    }
}
