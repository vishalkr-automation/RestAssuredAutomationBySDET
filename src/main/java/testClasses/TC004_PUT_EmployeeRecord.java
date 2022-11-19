package testClasses;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassPackage.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import utilitiesClass.RestUtils;

public class TC004_PUT_EmployeeRecord extends TestBase {
	
	public static Logger logger=Logger.getLogger("TC003_POST_EmployeeRecord");
	
	String empName;
	String empSalary;
	String empAge;
	
	/*String empName=RestUtils.empName();
	String empSalary=RestUtils.empSal();
	String empAge=RestUtils.empAge();*/
	
	public void getData(){
		/*String empName=RestUtils.empName();
		String empSalary=RestUtils.empSal();
		String empAge=RestUtils.empAge();*/
		
		 empName=RestUtils.empName();
		 empSalary=RestUtils.empSal();
		 empAge=RestUtils.empAge();
		
	}
	
	
	@BeforeClass
	public void createEmployee() throws InterruptedException{
		logger.info("********** Started TC004_PUT_Employee Record ***********");
		
		getData();
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
	    
		//JSONObject is a class that represent a simple JSON. We can add key-value pairs using the put method
		//{"name": "John123", "salary":"15000","age": "21"}
		JSONObject requestParams=new JSONObject();
		requestParams.put("name", empName);
		requestParams.put("salary", empSalary);
		requestParams.put("age", empAge);
		
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		//Response Object
		 response=httpRequest.request(Method.PUT, "/update/"+empID);
		
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void checkResponseBody(){
		String responseBody=response.getBody().asString();
		logger.info("Response Body is: "+ responseBody);
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSalary), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
	}

	@Test(priority=2)
	void checkStatusCode(){
		logger.info("********** Checking Status code *********");
		int statusCode=response.getStatusCode(); //Getting Status Code
		logger.info("Status Code is==>"+ statusCode); //200
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=3)
	void checkStatusLine(){
		logger.info("********** Checking Status Line *********");
		String statusLine=response.getStatusLine(); //Getting Status Line
		logger.info("Status Line is==>"+ statusLine); 
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test(priority=4)
	void checkContentType(){
		logger.info("********** Checking Content Type *********");
		String contentType=response.getContentType(); //Getting Content Type
		logger.info("Content Type is==>"+ contentType); 
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}
	
	@Test(priority=5)
	void checkServerType(){
		logger.info("********** Checking Content Type *********");
		String serverType=response.header("Server"); //Getting Content Type
		logger.info("Server Type is==>"+ serverType); 
		Assert.assertEquals(serverType, "Apache");
	}
	
	@Test(priority=6, enabled=false)
	void checkContentEncoding(){
		logger.info("********** Checking Content Encoding *********");
		String contentEncoding=response.header("Content-Encoding"); //Getting Content Type
		logger.info("Content Encoding is==>"+ contentEncoding); 
		Assert.assertEquals(contentEncoding, "gzip");
	}
	
	@AfterClass
	public void afterClass(){
		logger.info("********* Finsihed TC003_POST_Employee_Record ***********");
	}
}
