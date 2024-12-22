package com.example.restassureddemo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAPITests extends BaseTest {

    @Test
    public void testGetPosts() {
        Response response = given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Validate response size
        Assert.assertTrue(response.jsonPath().getList("$").size() > 0, "Posts list is empty!");
    }

    @Test
    public void testGetPostById() {
        Response response = given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Validate specific post ID
        Assert.assertEquals(response.jsonPath().getInt("id"), 1, "Post ID does not match!");
    }
}
