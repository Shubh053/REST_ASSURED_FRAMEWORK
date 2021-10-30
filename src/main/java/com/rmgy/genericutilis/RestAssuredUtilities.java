package com.rmgy.genericutilis;

import io.restassured.response.Response;

/**
 * this class contains generic methods pertaining to rest-assured
 * @author shubh
 *
 */
public class RestAssuredUtilities {
	/**
	 * this method will return the data inside json path
	 * @param res
	 * @param jsonPath
	 * @return
	 */
	public String getJsonData(Response res, String jsonPath) {
		String value = res.jsonPath().get(jsonPath);
		return value;
	}
}
