package tests;

import models.CreateUserModel;
import models.CreateUserResponseModel;
import models.ResourceListResponseModel;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.CreateUserSpec.*;
import static specs.ResourceListSpec.*;

@Tag("SMOKE")

public class ReqresTests extends TestBase {


    CreateUserModel createUserModel = new CreateUserModel();

    @Test
    void successfulCheckListResourceTest() {


        ResourceListResponseModel response = step("GetList", ()->
        given(resourceListRequestSpec)
                .get()

                .then()
                .spec(resourceListResponseSpec)
                .extract().as(ResourceListResponseModel.class));


        step("СheckResourceList", ()->
            assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", response.getSupport().getText())
        );
    }

    @Test
    void unsuccessfulCheckListResourceTest() {

        ResourceListResponseModel response = step("GetList", ()->
                given(resourceListRequestSpec)
                        .get()

                        .then()
                        .spec(resourceListResponseSpec)
                        .extract().as(ResourceListResponseModel.class));


        step("СheckResourceList", ()->
                assertEquals("https://fail.reqres.in/#support-heading", response.getSupport().getUrl())
        );
    }

    @Test
    void successfulCheckCreateUserTest() {

        createUserModel.setName("morpheus");
        createUserModel.setJob("leader");

        CreateUserResponseModel response = step("СreateUser", ()->
            given(createUserRequestSpec)
                    .body(createUserModel)

            .when()
                    .post()

            .then()
                    .spec(createUserResponseSpec)
                    .extract().as(CreateUserResponseModel.class));


        step("СheckCreateUser", ()-> {
            assertEquals("morpheus", response.getName());
            assertEquals("leader", response.getJob());
        });
    }

    @Test
    void unsuccessfulCheckCreateUserTest() {

        createUserModel.setName("morpheus");
        createUserModel.setJob("leader");

        CreateUserResponseModel response = step("CreateUser", () ->
                given(createUserRequestSpec)
                        .body(createUserModel)

                .when()
                        .post()

                .then()
                        .spec(notCreateUserResponseSpec)
                        .extract().as(CreateUserResponseModel.class));

        step("СheckCreateUser", () -> {
            assertEquals("morpheus", response.getName());
            assertEquals("nobody", response.getJob());
        });
    }
}
