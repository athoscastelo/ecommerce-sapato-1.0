
package org.acme.resource;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import dto.ClienteDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class ClienteResourceTest {
    @Test
    public void createTest(){
        ClienteDTO dto = new ClienteDTO("Athos", "athos@gmail.com", "xxx", "12345", "27/07/1997");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/clientes")
        .then()
        .statusCode(201)
        .body("nome", is("Athos"));

        ClienteDTO dto1 = new ClienteDTO("Marcelo", "marcelo@gmail.com", "xxx", "123456", "27/12/2003");
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
        .body("id", hasItem(is(1)));;
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/clientes/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void updateTest(){
        ClienteDTO dto = new ClienteDTO("Pedro", "pedro@gmail.com", "xxx", "1234", "20/03/2000");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/clientes/2")
        .then()
        .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 1)
        .delete("/clientes/{id}")
        .then()
        .statusCode(204);
    }
}
