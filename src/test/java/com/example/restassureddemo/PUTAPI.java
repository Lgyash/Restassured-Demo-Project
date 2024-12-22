package com.example.restassureddemo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PUTAPI extends BaseTest {
    @Test
    public void testUpdatePost() {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "                    \"title\": \"Updated\",\n" +
                        "                    \"body\": \"Far\",\n" +
                        "                    \"userId\": 1\n" +
                        "                }")
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Assert.assertEquals(response.jsonPath().getString("title"), "Updated");
    }
}
