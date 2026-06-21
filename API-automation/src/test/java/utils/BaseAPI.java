package utils;

import io.restassured.RestAssured;

public class BaseAPI {

    public static final String BASE_URL =
            "https://jsonplaceholder.typicode.com";

    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }
}