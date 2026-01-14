package backend;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public abstract class AbstractAPI {
    public AbstractAPI(){
        RestAssured.baseURI = "https://petstore.swagger.io/";
        RestAssured.filters(new RequestLoggingFilter());
        RestAssured.filters(new ResponseLoggingFilter());




    }
}
