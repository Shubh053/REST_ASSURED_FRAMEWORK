package com.rmgy.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	public void pathParameter() {
		baseURI = "http://localhost";
		port = 8084;
		
		given()
		.pathParam("projID", "TY_PROJ_204")
		
		.when()
		.get("/projects/{projID}")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
