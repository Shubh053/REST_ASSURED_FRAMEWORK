package com.rmgy.withbdd;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteProjectWithBDD {
	@Test
	public void deleteProject() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_402")
		.then()
		.assertThat().contentType("application/json")
		.assertThat().statusCode(204)
		.log().all();
	}
}
