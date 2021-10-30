package com.rmgy.parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetOneRepoUsingPathParameter {
	@Test
	public void getRepo() {
		given()
			.auth().basic("Shubh053", "githubAutomation")
			.pathParam("ownerName", "Shubh053")
			.pathParam("repoName", "SDET_21_REPO")
		.when()
			.get("https://api.github.com/repos/{ownerName}/{repoName}")
		.then()
			.log().all();
	}
}
