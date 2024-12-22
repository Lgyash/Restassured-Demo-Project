package com.example.restassureddemo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostAPITests extends BaseTest {

    @Test
    public void testCreatePost() {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body("{\n" +
                        "                    \"title\": \"foo\",\n" +
                        "                    \"body\": \"bar\",\n" +
                        "                    \"userId\": 1\n" +
                        "                }")
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .response();

        // Validate response body
        Assert.assertEquals(response.jsonPath().getString("title"), "foo");
        Assert.assertEquals(response.jsonPath().getString("body"), "bar");
    }
}
