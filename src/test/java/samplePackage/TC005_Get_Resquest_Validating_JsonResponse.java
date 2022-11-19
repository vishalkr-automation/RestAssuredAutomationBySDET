package samplePackage;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_Get_Resquest_Validating_JsonResponse {
	
	@Test
	public void getWeatherDetails(){
		
		//Specify the Base URI
		RestAssured.baseURI="http://www.7timer.info";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response=httpRequest.request(Method.GET, "/bin/api.pl?lon=113.17&lat=23.09&product=astro&output=json");
		
		//Print Response in Console Window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+ responseBody);
		
		JsonPath jsonPath=response.jsonPath();
		
		//System.out.println("value "+jsonPath.get("product"));
		//System.out.println("value "+jsonPath.get("timepoint"));
//		System.out.println("value "+jsonPath.get("Temperature"));
//		System.out.println("value "+jsonPath.get("Humidity"));
//		System.out.println("value "+jsonPath.get("WeatherDescription"));
//		System.out.println("value "+jsonPath.get("WindSpeed"));
//		System.out.println("value "+jsonPath.get("WindDirectionDegree"));
		
		
	}

}
