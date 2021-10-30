package com.rmgy.endtoend;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.rmgy.genericutilis.BaseAPIClass;
import com.rmgy.genericutilis.EndPoints;
import com.rmgy.pojoclass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProjectAndVerifyDatabase extends BaseAPIClass {
	@Test
	public void createProjectAndVerifyInDB() throws SQLException {
		ProjectLibrary pLib = new ProjectLibrary("Praveen", "chrome" + jLib.getRanDomNumber(), "Created", 34);
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post(EndPoints.AddProject);
		res.then().log().all();
		
		// capture the expected data
		String expData = rLib.getJsonData(res, "projectName");
		System.out.println(expData);
		
		// verify it in database
		String query = "select * from project";
		String actData = dLib.executeQueryAndGetData(query, 4, expData);
		
		// validate
		Assert.assertEquals(actData, expData);
		System.out.println("Successfull");
	}
}
