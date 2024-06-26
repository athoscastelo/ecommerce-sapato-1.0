
package org.acme.resource;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import dto.FornecedorDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class FornecedorResourceTest {
    @Test
    public void createTest(){
        FornecedorDTO dto = new FornecedorDTO("Athos", "1234", "quadra 2", "0000");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/fornecedores")
        .then()
        .statusCode(201)
        .body("nome", is("Athos"));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/fornecedores")
        .then()
        .statusCode(200)
        .body("id", hasItem(is(1)));;
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/fornecedores/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void updateTest(){
        FornecedorDTO dto = new FornecedorDTO("Gabriela", "12345", "quadra 3", "9999");

        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/fornecedores/2")
        .then()
        .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 1)
        .delete("/fornecedores/{id}")
        .then()
        .statusCode(204);
    }
}
