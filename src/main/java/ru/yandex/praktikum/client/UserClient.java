package ru.yandex.praktikum.client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends StellarRestClient{

    private static final String USER_URI = BASE_URI + "api/auth/";

    @Step("Delete user")
    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getBaseReqSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(USER_URI + "user/")
                .then();
    }



}
