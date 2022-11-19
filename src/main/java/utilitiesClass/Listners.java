package utilitiesClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listners implements ITestListener {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/myreport.html");
		
		htmlReporter.config().setDocumentTitle("Automation Report"); //Title of the Report
		htmlReporter.config().setReportName("Rest API Testing Report");  //name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extentReports=new ExtentReports();
		extentReports.attachReporter(htmlReporter);
		extentReports.setSystemInfo("Project Name", "Employee Database API");
		extentReports.setSystemInfo("Host Name", "localhost");
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("user", "Pavan");
				
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest=extentReports.createTest(result.getName()); //Create new Entry in the report
		extentTest.log(Status.PASS, "Test Case PASSED IS"+ result.getName());	
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest=extentReports.createTest(result.getName());//Create new Entry in the report
		extentTest.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());  //To Add Name in the report
		extentTest.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // To Add error/exception in the extent Report
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest=extentReports.createTest(result.getName()); //Create new Entry in the report
		extentTest.log(Status.SKIP, "Test case SKIPPED IS " + result.getName());
		
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
		
	}


	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
