package dataDrivenTesting;

import java.io.File;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DataDrivenTest_AddNewEmployee {
	
	@Test(dataProvider="empDataProvider")
	public void postNewEmployee(String empName, String empSalary,String empAge ){
		
		// Specify the Base URI
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
      JSONObject requestParams=new JSONObject();
		
		requestParams.put("name", empName);
		requestParams.put("age", empSalary);
		requestParams.put("salary", empAge);
		
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response=httpRequest.request(Method.POST, "/create");
		
		//Capture Response Body to perform validations
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+ responseBody);
		
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
		Assert.assertEquals(responseBody.contains(empSalary), true);
		
		int statusCode=response.getStatusCode();
		Assert.assertEquals(statusCode, 200);	
		
	}
	
	@DataProvider(name="empDataProvider")
	String [][]	 getEmpData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/dataDrivenTesting/empdata.xlsx";
		int rowNum=XLUtils.getRowCount(path, "Sheet1");
		int colNum=XLUtils.getCellCount(path, "Sheet1", rowNum);
		
		String empData[][]=new String[rowNum][colNum];
		
		for(int i=1; i<=rowNum; i++){
			for(int j=0; j<colNum; j++){
				empData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return(empData);
		
		/*String empData[][]={{"Ks1","2000","20"},{"ks2","2000","21"}};
		return(empData);*/
	}

}
