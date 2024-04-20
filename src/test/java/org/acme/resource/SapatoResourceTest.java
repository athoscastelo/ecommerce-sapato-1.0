package org.acme.resource;


import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;
//import dto.SapatoDTO;
import io.quarkus.test.junit.QuarkusTest;
//import jakarta.ws.rs.core.MediaType;

import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class SapatoResourceTest {
    @Test
    public void findAllTest (){

        given()
        .when()
        .get("/sapatos/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void findByIdTest() {
    
        given()
        .when()
        .get("/sapatos/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

   // @Test
   // public void createTest() {
      //  SapatoDTO dto = new SapatoDTO(34, 1, 2, 3, 1);
    
      //  given()
       // .contentType(MediaType.APPLICATION_JSON)
       // .body(dto)
       // .when()
        //.get("/sapatos/1")
       // .then()
        //.statusCode(200)
       // .body("id", is(1));
   // }

   public void updateTest(){

   }
}

