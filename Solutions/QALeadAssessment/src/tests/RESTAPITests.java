package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;
import io.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RESTAPITests {

	private static final String BASE_URI = "http://localhost:3000";

	@Test
	public void testCreateTask() {
		// Create JSON payload for new task
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", "CreateTaskAPI");
		requestBody.put("description", "Create a test that PUTs a new object");
		requestBody.put("completed", false);

		// Send POST request to create new task
		given()
		    .header("Content-Type", "application/json")
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
		    .body(requestBody.toJSONString())
		.when()
		    .post(BASE_URI + "/tasks")
		.then()
		    .assertThat()
		    .statusCode(201)
		    .body("name", equalTo("CreateTaskAPI"))
		    .body("description", equalTo("Create a test that PUTs a new object"))
		    .body("completed", equalTo(false));
	}

	@Test
	public void testGetTaskById() {

		given()
        .when()
            .get(BASE_URI + "/tasks/1")
        .then()
            .statusCode(200)
            .body("id", equalTo("1"))
            .body("name", equalTo("OpenNewTab"))
            .body("description", equalTo("Create a test that opens a new tab in Chrome and navigates to it"))
            .body("completed", equalTo(true));
		
	}

	@Test
	public void testGetAllTasks() {

		Response response = given().when().get(BASE_URI + "/tasks");

		assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void testUpdateTask() {
		
		 // Create JSON payload for updating task
	    JSONObject requestBody = new JSONObject();
	    requestBody.put("completed", false);

	    // Send PATCH request to update task
	    given()
	        .header("Content-Type", "application/json")
	        .contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .body(requestBody.toJSONString())
	    .when()
	        .patch(BASE_URI + "/tasks/2")
	    .then()
	        .assertThat()
	        .statusCode(200)
	        .body("completed", equalTo(false));

	}

}
