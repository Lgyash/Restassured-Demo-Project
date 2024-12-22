package com.example.restassureddemo;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteApi extends BaseTest {

    @Test
    public void testDeletePost() {
        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);
    }

}
