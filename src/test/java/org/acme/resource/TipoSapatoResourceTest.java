
package org.acme.resource;

import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.MediaType;
import dto.TipoSapatoDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TipoSapatoResourceTest {
    @Test
    public void createTest(){
        TipoSapatoDTO dto = new TipoSapatoDTO("Casual");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/tiposapatos")
        .then()
        .statusCode(201)
        .body("descricao", is("Casual"));

        TipoSapatoDTO dto1 = new TipoSapatoDTO("Social");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto1)
        .when()
        .post("/tiposapatos")
        .then()
        .statusCode(201)
        .body("descricao", is("Social"));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/tiposapatos")
        .then()
        .statusCode(200)
        .body("id", hasItem(is(1)));;
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/tiposapatos/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void updateTest(){
        TipoSapatoDTO dto = new TipoSapatoDTO("Social/Casual");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/tiposapatos/1")
        .then()
        .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 2)
        .delete("/tiposapatos/{id}")
        .then()
        .statusCode(204);
    }
}
