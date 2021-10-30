package com.rmgy.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameters {
	@Test
	public void queryParameter() {
		baseURI = "https://reqres.in";
		
		given()
		.queryParam("page", 2)
		
		.when()
		.get("/api/users")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
