package com.rmgy.withoutbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProjectWithoutBDD {
	@Test
	public void getSingleProject() {
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_204");
		System.out.println(resp.getStatusCode() + "\n" + resp.getContentType() + "\n" + resp.getTime());
		
		resp.then()
		.assertThat().statusCode(200)
		.assertThat().contentType("application/json")
		.log().all();
	}
}
