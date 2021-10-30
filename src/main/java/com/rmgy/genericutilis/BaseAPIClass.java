package com.rmgy.genericutilis;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;
/**
 * 
 * @author shubh
 *
 */
public class BaseAPIClass {
	public DatabaseUtility dLib = new DatabaseUtility();
	public RestAssuredUtilities rLib = new RestAssuredUtilities();
	public JavaUtility jLib = new JavaUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable {
		dLib.connectToDB();
		baseURI = "http://localhost";
		port = 8084;
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		dLib.closeDB();
	}
}
