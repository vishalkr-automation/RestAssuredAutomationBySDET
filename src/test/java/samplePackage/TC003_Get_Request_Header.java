package samplePackage;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_Get_Request_Header {
	
	@Test
	public void getWeatherDetails(){
		
		//Specify the Base URI
		RestAssured.baseURI="https://places.cit.api.here.com";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response=httpRequest.request(Method.GET, "/places/v1/autosuggest?at=40.74917,-73.98529&q=chrysler&app_id=Ju5BDDpQQnnpsXw8EyTI&app_code=zwhfqC-Q0ZESO5n8GSaWQA");
		
		//Print Response in Console Window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+ responseBody);
		
		//Status Code Validation
		int statusCode=response.getStatusCode();
		System.out.println("Status code is: "+ statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Content Type
		String contentType=response.header("content-type");
		System.out.println("Content-Type is: "+ contentType);
		
		// Content Encoding
		String contentEncoding = response.header("content-encoding");
		System.out.println("Content-Encoding is: " + contentEncoding);
		
		
		
	}

}
