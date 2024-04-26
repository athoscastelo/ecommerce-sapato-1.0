
package org.acme.resource;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;
import dto.FuncionarioDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class FuncionarioResourceTest {
    @Test
    public void createTest(){
        FuncionarioDTO dto = new FuncionarioDTO("Athos", "athos@gmail.com", "xxx", "12345 x", "quadra x","27/07/1997", "empacotador", "xxx");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/funcionarios")
        .then()
        .statusCode(201)
        .body("nome", is("Athos"));

        FuncionarioDTO dto1 = new FuncionarioDTO("Marcelo", "marcelo@gmail.com", "xxx", "12345", "quadra x","27/12/2006", "recepcionista", "yyy");

        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto1)
        .when()
        .post("/funcionarios")
        .then()
        .statusCode(201)
        .body("nome", is("Marcelo"));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/funcionarios")
        .then()
        .statusCode(200)
        .body("id", hasItem(is(1)));;
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/funcionarios/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void updateTest(){
        FuncionarioDTO dto = new FuncionarioDTO("Pedro", "pedro@gmail.com", "xxx", "12345", "quadra x","27/12/2006", "atendente", "zzz");

        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/funcionarios/2")
        .then()
        .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 1)
        .delete("/funcionarios/{id}")
        .then()
        .statusCode(204);
    }
}
