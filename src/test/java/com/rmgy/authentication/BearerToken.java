package com.rmgy.authentication;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerToken() {
		// create the data
		HashMap map = new HashMap();
		map.put("name", "REST-BearerToken");
		
		given()
		.auth()
		.oauth2("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")
		.body(map)
		
		.when()
		.post("https://api.github.com/user/repos")
		
		.then().log().all();
	}
}
