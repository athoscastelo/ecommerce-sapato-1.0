package org.acme.resource;

import dto.FornecedorDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class FornecedorResourceTest {
    @Test
    public void findAllTest (){
        given()
                .when()
                .get("/fornecedores/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void findByIdTest() {
        given()
                .when()
                .get("/fornecedores/1")
                .then()
                .statusCode(200)
                .body("id", is(1));
    }

    @Test
    public void createTest() {
        FornecedorDTO dto = new FornecedorDTO("pedro", "1234567890007","Rua G, 1617", "(77) 2468-9753" );

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/fornecedores")
                .then()
                .statusCode(201)
                .body("id", is(2));
    }

    @Test
    public void updateTest(){
        FornecedorDTO dto = new FornecedorDTO("Gisele","329832u32","wwhefefwfew","656665");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/fornecedores/1")
        .then()
        .statusCode(200);
    }

    @Test
    public void deleteTest() {
        given()
                .when()
                .delete("/fornecedores/2")
                .then()
                .statusCode(204);
    }
}
