package samplePackage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC007_Get_Request_Autherization {
	
	@Test
	public void authorization(){
		//Specify the Base URI
				RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
				
				//Basic Authentication
				PreemptiveBasicAuthScheme authScheme=new PreemptiveBasicAuthScheme();
				authScheme.setUserName("ToolsQA");
				authScheme.setPassword("TestPassword");
				
				RestAssured.authentication=authScheme;
				
				
				//Request Object
				RequestSpecification httpRequest=RestAssured.given();
				
				//Response Object
				Response response=httpRequest.request(Method.GET, "/");
				
				//Print Response in Console Window
				String responseBody=response.getBody().asString();
				System.out.println("Response Body is: "+ responseBody);
				
				//Status Code Validation
				int statusCode=response.getStatusCode();
				System.out.println("Status coed is: "+ statusCode);
				Assert.assertEquals(statusCode, 200);
				
				//Status Line Verification
				String statusLine=response.getStatusLine();
				System.out.println("Status line is: "+ statusLine);	
				
	}
}
