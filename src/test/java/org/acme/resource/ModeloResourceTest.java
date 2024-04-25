
package org.acme.resource;

import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.MediaType;
import dto.ModeloDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ModeloResourceTest {
    @Test
    public void createTest(){
        ModeloDTO dto = new ModeloDTO("xixi");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/modelos")
        .then()
        .statusCode(200)
        .body("id", is(1));

        
        ModeloDTO dto1 = new ModeloDTO("xixi");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto1)
        .when()
        .post("/modelos")
        .then()
        .statusCode(200)
        .body("id", is(2));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/modelos")
        .then()
        .statusCode(200);
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/modelos/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void updateTest(){
        ModeloDTO dto = new ModeloDTO("bosta");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/modelos/1")
        .then()
        .statusCode(204);
    }
    
    
    @Test
    public void deleteTest() {
        given()
            .when()
            .delete("/modelos/1")
            .then()
            .statusCode(204);
    }
}
