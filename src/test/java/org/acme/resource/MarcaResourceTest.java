
package org.acme.resource;

import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.MediaType;
import dto.MarcaDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MarcaResourceTest {
    @Test
    public void createTest(){
        MarcaDTO dto = new MarcaDTO("bonito");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/marcas")
        .then()
        .statusCode(201)
        .body("nome", is("bonito"));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/marcas")
        .then()
        .statusCode(200)
        .body("id", hasItem(is(1)));;
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/marcas/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    
    @Test
    public void updateTest(){
        MarcaDTO dto = new MarcaDTO("Feio");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/marcas/2")
        .then()
        .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 1)
        .delete("/marcas/{id}")
        .then()
        .statusCode(204);
    }
}


    
    


