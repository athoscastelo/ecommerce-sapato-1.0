package org.acme.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import org.junit.jupiter.api.Test;
import dto.ClienteDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class ClienteResourceTest {
    @Test
    public void createTest(){
        ClienteDTO dto = new ClienteDTO("Athos", "athos@gmail.com", "xxx", "12345678901", "27/07/1997");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/clientes")
        .then()
        .statusCode(201)
        .body("nome", is("Athos"));

        ClienteDTO dto1 = new ClienteDTO("Marcelo", "marcelo@gmail.com", "xxx", "12345678902", "27/12/2003");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto1)
        .when()
        .post("/clientes")
        .then()
        .statusCode(201)
        .body("nome", is("Marcelo"));
    }
    
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/clientes")
        .then()
        .statusCode(200)
        .body("$.size()", is(2)); // Verifica se existem 2 clientes cadastrados
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/clientes/1")
        .then()
        .statusCode(200)
        .body("id", is(1)); // Verifica se o cliente com ID 1 existe
    }

    @Test
    public void updateTest(){
        ClienteDTO dto = new ClienteDTO("Pedro", "pedro@gmail.com", "xxx", "12345678903", "20/03/2000");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/clientes/2")
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
