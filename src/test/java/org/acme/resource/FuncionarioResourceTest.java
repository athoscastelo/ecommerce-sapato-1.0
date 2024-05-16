package org.acme.resource;

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
        FuncionarioDTO dto = new FuncionarioDTO("Nome Funcionario", "email@teste.com", "senha", "Cargo", "Endereco", "12345678901", "27/07/1997");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/funcionarios")
        .then()
        .statusCode(201)
        .body("nome", is("Nome Funcionario"));

        FuncionarioDTO dto1 = new FuncionarioDTO("Outro Funcionario", "outro@teste.com", "senha", "Outro Cargo", "Outro Endereco", "12345678902", "27/12/2003");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto1)
        .when()
        .post("/funcionarios")
        .then()
        .statusCode(201)
        .body("nome", is("Outro Funcionario"));
    }
    
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/funcionarios")
        .then()
        .statusCode(200)
        .body("$.size()", is(2)); // Verifica se existem 2 funcionários cadastrados
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/funcionarios/1")
        .then()
        .statusCode(200)
        .body("id", is(1)); // Verifica se o funcionário com ID 1 existe
    }

    @Test
    public void updateTest(){
        FuncionarioDTO dto = new FuncionarioDTO("Novo Nome", "novoemail@teste.com", "novasenha", "Novo Cargo", "Novo Endereco", "12345678903", "20/03/2000");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/funcionarios/2")
        .then()
        .statusCode(204); // Verifica se a atualização foi bem-sucedida
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 1)
        .delete("/funcionarios/{id}")
        .then()
        .statusCode(204); // Verifica se a exclusão foi bem-sucedida
    }
}
