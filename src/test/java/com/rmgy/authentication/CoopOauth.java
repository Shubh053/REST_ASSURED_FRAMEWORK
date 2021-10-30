package com.rmgy.authentication;

import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CoopOauth {
	@Test
	public void createOauth2OnCoop() {
		// Generate the token
		Response res = given()
		.formParam("client_id", "SDET21-REST")
		.formParam("client_secret", "8bf552ad638974caf7bdc38cc30e20eb")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		// Capture the token
		String token = res.jsonPath().get("access_token");
		
		// Create a new request to access the token
		given()
		.auth()
		.oauth2(token)
		.pathParam("USER_ID", "2406")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then().log().all();
		
	}
}
