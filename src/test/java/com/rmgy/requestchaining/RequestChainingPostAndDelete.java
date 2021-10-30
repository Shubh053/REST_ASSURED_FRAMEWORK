package com.rmgy.requestchaining;
import org.testng.annotations.Test;

import com.rmgy.genericutilis.JavaUtility;
import com.rmgy.pojoclass.ProjectLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

//@JacksonFeatures(serializationDisable = {SerializationFeature.FAIL_ON_EMPTY_BEANS})
public class RequestChainingPostAndDelete {
	@Test
	public void chainPostAndDelete() {
		JavaUtility ju = new JavaUtility();
		baseURI = "http://localhost";
		port = 8084;
		
		ProjectLibrary pLib = new ProjectLibrary("Shubham", "Amex" + ju.getRanDomNumber(), "Completed", 20);
		Response res = given()
				.contentType(ContentType.JSON)
				.body(pLib)
				.when()
				.post("/addProject");
		
				String projId = res.jsonPath().get("projectId");
				System.out.println(projId);
				
				res.then().log().all();
				
				given()
				.pathParam("projID", projId)
				
				.when()
				.delete("/projects/{projID}")
				.then().assertThat().statusCode(204).log().all();
	}
}
