package com.rmgy.withbdd;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PostProjectWithBDD {
	@Test
	public void createProject() {
	JSONObject jobj =	new JSONObject();
	jobj.put("createdBy", "Shubham");
	jobj.put("projectName", "rmgyantra");
	jobj.put("status", "Created");
	jobj.put("teamSize", 8);
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	
	.when()
	.post("http://localhost:8084/addProject")
	
	.then()
	.assertThat().statusCode(201)
	.assertThat().contentType("application/json")
	.log().all();
	}
}
