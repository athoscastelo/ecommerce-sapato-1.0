
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
        FornecedorDTO dto = new FornecedorDTO("athos", "1231", "alameda", "3232he2");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/fornecedores")
        .then()
        .statusCode(201)
        .body("nome", is("athos"));
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
    public void findByNomeTest(){
        given()
        .when()
        .get("/fornecedores/1")
        .then()
        .statusCode(200)
        .body("nome", is("Fornecedor A"));
    }

    @Test
    public void updateTest(){
        FornecedorDTO dto = new FornecedorDTO("gabriela", "1231", "quadra", "3232he2");

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
