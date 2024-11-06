package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

public class UserSpec {

    public static RequestSpecification createUserRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().all();

    public static ResponseSpecification createUserResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(ALL)
            .build();

    public static RequestSpecification resourceListRequestSpec = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .log().all();

    public static ResponseSpecification resourceListResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();
}