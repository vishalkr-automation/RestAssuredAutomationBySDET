package baseClassPackage;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID="95698";
	
	
	
	@BeforeClass
	public void setup(){
		
		PropertyConfigurator.configure("log4j.properties");
		//logger.setLevel(Level.DEBUG); 
	}

}
