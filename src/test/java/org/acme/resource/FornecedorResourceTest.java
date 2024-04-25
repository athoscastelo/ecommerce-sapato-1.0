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
                .get("/fornecedores")
                .then()
                .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
                .when()
                .get("/fornecedores/1")
                .then()
                .statusCode(204);
    }

    @Test
    public void createTest() {
    FornecedorDTO dto1 = new FornecedorDTO("Fulano", "1234567890010", "Rua J, 2021", "(11) 1111-1111");

    given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto1)
            .when()
            .post("/fornecedores")
            .then()
            .statusCode(201)
            .body("id", is(1));

    FornecedorDTO dto2 = new FornecedorDTO("Ciclano", "1234567890011", "Rua K, 2122", "(22) 2222-2222");

    given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto2)
            .when()
            .post("/fornecedores")
            .then()
            .statusCode(201)
            .body("id", is(2));

    FornecedorDTO dto3 = new FornecedorDTO("Beltrano", "1234567890012", "Rua L, 2223", "(33) 3333-3333");

    given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto3)
            .when()
            .post("/fornecedores")
            .then()
            .statusCode(201)
            .body("id", is(3));
}
@Test
public void updateTest(){
    FornecedorDTO dto = new FornecedorDTO("gisele", "arroz", "feijao", "carros");
    given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/fornecedores/1") 
        .then()
        .statusCode(204);
}

    @Test
    public void deleteTest() {
        given()
                .when()
                .delete("/fornecedores/1")
                .then()
                .statusCode(204);
    }
}

