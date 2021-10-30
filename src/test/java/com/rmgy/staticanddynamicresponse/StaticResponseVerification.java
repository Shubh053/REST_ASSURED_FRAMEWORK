package com.rmgy.staticanddynamicresponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseVerification {
	@Test
	public void verifyStaticResponse() {
		baseURI = "http://localhost";
		port = 8084;
		
		String expData = "TY_PROJ_002";
		
		// store all the responses
		Response res = when().get("/projects");
		
		
		// capture the data using json path
		String actData = res.jsonPath().get("[0].projectId");
		System.out.println(actData);
		
		// validate
		Assert.assertEquals(actData, expData);
		System.out.println(actData + " data verified");
		
		res.then().log().all();
	}
}
