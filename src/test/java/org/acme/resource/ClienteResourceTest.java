package org.acme.resource;

import dto.ClienteDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ClienteResourceTest {

    @Test
    public void createTest(){
        ClienteDTO dto = new ClienteDTO("Nome Cliente", "12345678901", "27/07/1997", "1234567890", "Endereço Cliente");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/clientes")
        .then()
        .statusCode(201)
        .body("nome", is("Nome Cliente"));

        ClienteDTO dto1 = new ClienteDTO("Outro Cliente", "12345678902", "27/12/2003", "0987654321", "Endereço Outro Cliente");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto1)
        .when()
        .post("/clientes")
        .then()
        .statusCode(201)
        .body("nome", is("Outro Cliente"));
    }

    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/clientes")
        .then()
        .statusCode(200);
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/clientes/1")
        .then()
        .statusCode(200);
    }

    @Test
    public void updateTest(){
        ClienteDTO dto = new ClienteDTO("Novo Nome", "12345678903", "20/03/2000", "9876543210", "Novo Endereço");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/clientes/1")
        .then()
        .statusCode(204); // Verifica se a atualização foi bem-sucedida
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 1)
        .delete("/clientes/{id}")
        .then()
        .statusCode(204); // Verifica se a exclusão foi bem-sucedida
    }
}
