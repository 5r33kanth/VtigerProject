package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListnerClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" testcase execution started");
		
		test = report.startTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
//		Reporter.log(methodName+" testcase passed");
		
		test.log(LogStatus.PASS, methodName);
		
		
		report.endTest(test);
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" testcase failed");
		Reporter.log(result.getThrowable().toString());
		
		GenericUtilities gu = new GenericUtilities();
		String path= "C:\\Testing\\Vtiger\\src\\test\\resources\\defectimages\\Vtiger_"+methodName+"_"+gu.currentDate()+".jpg";

		
		test.log(LogStatus.FAIL, test.addScreenCapture(gu.captureScreenShot(BaseClass.sdriver, path)));
			
		report.endTest(test);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+" testcase skipped");
		
		test.log(LogStatus.SKIP, methodName+"Skipped");
		
		report.endTest(test);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		Reporter.log("---Execution Started---");
		report = new ExtentReports("./reports/extentReport_Vtiger.html");
		
		report.addSystemInfo("OS", "Windows 11");
		report.addSystemInfo("browser", "Edge");
		report.addSystemInfo("User Name", "Sreekanth");
		report.addSystemInfo("Project Name", "Vtiger");
		report.addSystemInfo("BaseUrl", "http://localhost:8888/");
		report.addSystemInfo("username", "admin");
		report.addSystemInfo("password", "admin");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("---Execution Finished---");
		
		report.flush();
	}
	
	

}
