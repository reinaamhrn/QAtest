package apis;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostAPI {

    public Response createPost(String requestBody) {

        return given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/posts");
    }

    public Response getPosts() {

        return given()
                .when()
                .get("/posts");
    }

    public Response deletePost(int id) {

        return given()
                .when()
                .delete("/posts/" + id);
    }

    public Response updatePost(int id, String requestBody) {

        return given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/posts/" + id);
    }
}