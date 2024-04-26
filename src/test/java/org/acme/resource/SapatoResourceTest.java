
package org.acme.resource;

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
        SapatoDTO dto = new SapatoDTO(11.0, 111, 39,1,2, 1L,1L,1L,1L);
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/sapatos")
        .then()
        .statusCode(201)
        .body("id", is(1));

        SapatoDTO dto1 = new SapatoDTO(11.0, 111, 40,1,2, 1L,1L,1L,1L);
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto1)
        .when()
        .post("/sapatos")
        .then()
        .statusCode(201)
        .body("id", is(2));
    }

    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/sapatos")
        .then()
        .statusCode(200);
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/sapatos/1")
        .then()
        .statusCode(200);
    }

 
    @Test
    public void updateTest(){
        SapatoDTO dto = new SapatoDTO(67.0, 34, 38,1,1, 1L,1L,1L,1L);

        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/sapatos/2")
        .then()
        .statusCode(204)
        .body("id", is(2));
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 2)
        .delete("/sapatos/{id}")
        .then()
        .statusCode(204);
    }


}



