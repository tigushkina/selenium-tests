package backend;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PetStoreApi extends AbstractAPI{

    private static final String ADD_PET_PARTIAL_URL = "/v2/pet";

    public String addNewPet(final String petBody){
        return RestAssured
                .given()
               // .header( "Content-Type:","application/json")
                .contentType(ContentType.JSON)
                .body(petBody)
               .when()
                .post(ADD_PET_PARTIAL_URL)
              .then()
              .statusCode(200)
              .extract()
              .body()
                .asString();

    }

}
