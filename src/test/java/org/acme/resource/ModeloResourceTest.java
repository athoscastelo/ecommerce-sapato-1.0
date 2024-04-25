
package org.acme.resource;

import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.MediaType;
import dto.ModeloDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ModeloResourceTest {
    @Test
    public void createTest(){
        ModeloDTO dto = new ModeloDTO("bonito");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/modelos")
        .then()
        .statusCode(201)
        .body("nome", is("bonito"));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/modelos")
        .then()
        .statusCode(200)
        .body("id", hasItem(is(1)));;
    }

    @Test
    public void findByNomeTest(){
        given()
        .when()
        .get("/modelos/1")
        .then()
        .statusCode(200)
        .body("nome", is("Modelo A"));
    }

    @Test
    public void updateTest(){
        ModeloDTO dto = new ModeloDTO("Feio");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/modelos/2")
        .then()
        .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 1)
        .delete("/modelos/{id}")
        .then()
        .statusCode(204);
    }
}
