package com.example.restassureddemo;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        // Base URI for REST APIs
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
