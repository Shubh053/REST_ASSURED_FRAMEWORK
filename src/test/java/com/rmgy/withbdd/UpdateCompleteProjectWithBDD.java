package com.rmgy.withbdd;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class UpdateCompleteProjectWithBDD {
	@Test
	public void updateProject() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Shubham");
		jobj.put("projectName", "rmgyantra");
		jobj.put("status", "Completed");
		jobj.put("teamSize", "10");
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_403")
		
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType("application/json")
		.log().all();
	}
}
