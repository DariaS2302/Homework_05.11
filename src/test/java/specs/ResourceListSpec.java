package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.hasItems;

public class ResourceListSpec {

    public static RequestSpecification resourceListRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .contentType(JSON)
            .basePath("/api/unknown/2");

    public static ResponseSpecification resourceListResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();
}
