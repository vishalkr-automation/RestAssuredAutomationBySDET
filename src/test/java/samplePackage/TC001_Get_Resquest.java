package samplePackage;
import org.json.JSONObject;
import org.json.XML;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_Get_Resquest {
	
	@Test
	public void getWeatherDetails(){
		
		//Specify the Base URI
		RestAssured.baseURI="https://api.coindesk.com";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response=httpRequest.request(Method.GET, "/v1/bpi/currentprice.json");
		
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
		
		/*String str="";
		JSONObject obj=new JSONObject(str);
		
		String xml=XML.toString(obj);
		
		JSONObject obj1=XML.toJSONObject(xml);*/
		
		
	}

}
