package testClasses;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassPackage.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC002_Get_Single_Employees_Record extends TestBase{
	public static Logger logger=Logger.getLogger("TC002_Get_Single_Employees_Record");
	
	@BeforeClass
	void getEmployeeData() throws InterruptedException{
		logger.info("********** Started TC002_Get_Single_Employee Record ***********");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employee/"+empID);
		Thread.sleep(3);
	}

	@Test(priority=1)
	public void checkResponseBody(){
		logger.info("*********** Checking Response Body **********");
		String responseBody=response.getBody().asString();
		logger.info("Response Body==>	"+ responseBody);
		Assert.assertEquals(responseBody.contains(empID),true);
		
	}
	
	@Test(priority=2)
	void checkStatusCode(){
		logger.info("********** Checking Status code *********");
		int statusCode=response.getStatusCode(); //Getting Status Code
		logger.info("Status Code is==>"+ statusCode); //200
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test(priority=3)
	void responseTime(){
		logger.info("********** Checking Response Time *********");
		long responseTime=response.getTime(); //Getting response Time
		logger.info("Response time is==>"+ responseTime); 
		
		if(responseTime>2000)
		{
		logger.warn("Response Time is greater than 2000");
		}
		Assert.assertTrue(responseTime>= 2000);
	}
	
	@Test(priority=4)
	void checkStatusLine(){
		logger.info("********** Checking Status Line *********");
		String statusLine=response.getStatusLine(); //Getting Status Line
		logger.info("Status Line is==>"+ statusLine); 
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test(priority=5)
	void checkContentType(){
		logger.info("********** Checking Content Type *********");
		String contentType=response.getContentType(); //Getting Content Type
		logger.info("Content Type is==>"+ contentType); 
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}
	
	@Test(priority=6)
	void checkServerType(){
		logger.info("********** Checking Content Type *********");
		String serverType=response.header("Server"); //Getting Content Type
		logger.info("Server Type is==>"+ serverType); 
		Assert.assertEquals(serverType, "Apache");
	}
	
	@Test(priority=7)
	void checkContentEncoding(){
		logger.info("********** Checking Content Encoding *********");
		String contentEncoding=response.header("Content-Encoding"); //Getting Content Type
		logger.info("Content Encoding is==>"+ contentEncoding); 
		Assert.assertEquals(contentEncoding, "gzip");
	}
	
	@Test(enabled=false, priority=8)
	void checkContentLength(){
		logger.info("********** Checking Content Length *********");
		String contentLength=response.header("Content-Length"); //Getting Content Type
		logger.info("Content Length is==>"+ contentLength); 
		
		if(Integer.parseInt(contentLength)<100)
			logger.warn("Content Length is less than 100");
		
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
	}
	
	@Test(priority=9)
	void cookies(){
	logger.info("****** Checking Cookies **********");
	String cookie=response.getCookie("PHPSESSID");
	}
	
	@AfterClass
	public void afterClass(){
		logger.info("********* Finsihed TC001_Get_All_Employess ***********");
	}
	
	
}
