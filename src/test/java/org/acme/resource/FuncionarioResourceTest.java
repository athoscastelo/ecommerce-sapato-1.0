// package org.acme.resource;

// import static org.hamcrest.CoreMatchers.is;
// import org.junit.jupiter.api.Test;
// import dto.FuncionarioDTO;
// import io.quarkus.test.junit.QuarkusTest;
// import jakarta.ws.rs.core.MediaType;
// import static io.restassured.RestAssured.given;

// @QuarkusTest
// public class FuncionarioResourceTest {

//     @Test
//         public void createTest(){
//             FuncionarioDTO dto = new FuncionarioDTO("Nome Funcionario", "12345678901", "Endereço Funcionario", "27/07/1997", "1234567890", "Cargo Funcionario", "email@teste.com", "senha123");
//             given()
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto)
//             .when()
//             .post("/funcionarios")
//             .then()
//             .statusCode(201)
//             .body("nome", is("Nome Funcionario"));
    
//             FuncionarioDTO dto1 = new FuncionarioDTO("Outro Funcionario", "12345678902", "Endereço Outro Funcionario", "27/12/2003", "0987654321", "Outro Cargo Funcionario", "outro@teste.com", "outrasenha");
//             given()
//             .contentType(MediaType.APPLICATION_JSON)
//             .body(dto1)
//             .when()
//             .post("/funcionarios")
//             .then()
//             .statusCode(201)
//             .body("nome", is("Outro Funcionario"));
//         }
    
//     @Test
//     public void findAllTest(){
//         given()
//         .when()
//         .get("/funcionarios")
//         .then()
//         .statusCode(200);
//         }

//     @Test
//     public void findByIdTest(){
//         given()
//         .when()
//         .get("/funcionarios/1")
//         .then()
//         .statusCode(200);
//     }

//     @Test
//     public void updateTest(){
//         FuncionarioDTO dto = new FuncionarioDTO("Novo Nome", "12345678903", "Novo Endereço", "20/03/2000", "9876543210", "Novo Cargo", "novoemail@teste.com", "novasenha");
//         given()
//         .contentType(MediaType.APPLICATION_JSON)
//         .body(dto)
//         .when()
//         .put("/funcionarios/1")
//         .then()
//         .statusCode(204); // Verifica se a atualização foi bem-sucedida
//     }

//     @Test
//     public void deleteTest(){
//         given()
//         .when()
//         .pathParam("id", 1)
//         .delete("/funcionarios/{id}")
//         .then()
//         .statusCode(204); // Verifica se a exclusão foi bem-sucedida
//     }
// }
