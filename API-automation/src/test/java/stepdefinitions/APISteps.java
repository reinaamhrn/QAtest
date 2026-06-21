package stepdefinitions;

import apis.PostAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.List;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class APISteps {

    PostAPI postAPI = new PostAPI();

    Response response;

    String requestBody;

    // Create a New Post //
    @Given("user prepares request body for new post")
    public void prepareRequestBody() {

        requestBody =
                "{\n" +
                "\"title\":\"Learn API Testing\",\n" +
                "\"body\":\"Practicing API testing with JSONPlaceholder\",\n" +
                "\"userId\":101\n" +
                "}";
    }

    @When("user sends POST request to create post")
    public void sendPostRequest() {

        response = postAPI.createPost(requestBody);

        System.out.println(response.asPrettyString());
    }

    @Then("response status code should be {int}")
    public void validateStatusCode(int statusCode) {

        response.then().statusCode(statusCode);
    }

    @And("response should contain title {string}")
    public void validateTitle(String title) {

        assertEquals(title, response.jsonPath().getString("title"));
    }

    @And("response should contain body {string}")
    public void validateBody(String body) {

        assertEquals(body, response.jsonPath().getString("body"));
    }

    @And("response should contain userId {int}")
    public void validateUserId(int userId) {

        assertEquals(userId, response.jsonPath().getInt("userId"));
    }

    @And("response should match post JSON schema")
    public void validateSchema() {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));
    }

    @And("response should match get JSON schema")
    public void validateGetSchema() {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/get-schema.json"));
    }

    // Retrieve Posts //
    @Given("user is ready to retrieve all posts")
    public void prepareGetPosts() {
        // no request body needed for GET
    }

    @When("user sends GET request to retrieve posts")
    public void sendGetRequest() {

        response = postAPI.getPosts();

        System.out.println(response.asPrettyString());
    }

    @And("each post id should not be null")
    public void validatePostIdsNotNull() {

        List<Integer> ids = response.jsonPath().getList("id");

        for (Integer id : ids) {
            assertNotNull(id);
        }
    }

    // Delete a Post //
    @When("user sends DELETE request to delete post with id {int}")
    public void sendDeleteRequest(int id) {

        response = postAPI.deletePost(id);

        System.out.println(response.asPrettyString());
    }

    @And("response body should indicate successful deletion")
    public void validateDeleteResponseBody() {

        String body = response.getBody().asString();

        assertTrue(body == null || body.trim().isEmpty() || body.equals("{}"));
    }

    @And("response should match delete post JSON schema")
    public void validateDeleteSchema() {

        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/delete-schema.json"));
    }

    // Update a Post //
    @Given("user prepares update request body")
    public void prepareUpdateBody() {

        requestBody =
                "{\n" +
                "\"title\":\"Updated Post Title\",\n" +
                "\"body\":\"This is the updated body content.\",\n" +
                "\"userId\":99\n" +
                "}";
    }

    @When("user sends PUT request to update post with id {int}")
    public void sendUpdateRequest(int id) {

        response = postAPI.updatePost(id, requestBody);

        System.out.println(response.asPrettyString());
    }
}