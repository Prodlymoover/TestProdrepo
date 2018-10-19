package POM.moovertest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class UserTestListner implements ITestListener {

	Loginto_Org sign_in;
	  
    String filePath="F:\\screenshots";
public void onFinish(ITestContext finish) {
		// TODO Auto-generated method stub
		Date endDate = finish.getEndDate();
		System.out.println("END DATE OF EXECUTION:-" + endDate);
		System.out.println("******************************************");
		
	}
public void onStart(ITestContext start) {
		// TODO Auto-generated method stub
		sign_in = Loginto_Org.getInstance();
		Date startDate = start.getStartDate();
		System.out.println("START DATE OF EXECUTION:-" + startDate);
		System.out.println("******************************************");
     
		
	}
public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailure(ITestResult failure) 
	   {
		// TODO Auto-generated method stub
		String failureTest = failure.getName();
		System.out.println(failureTest + "--->" + "Failed");
		String methodName = failure.getName().toString().trim();
		if(sign_in.selected_driver.equals("source"))
			takeScreenShot(methodName,sign_in.sDriver);
		else
			takeScreenShot(methodName,sign_in.tDriver);
	 }

	public void takeScreenShot(String methodName,WebDriver driver) {
		// get the driver
		
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test
		// method name
		try {
			FileUtils.copyFile(scrFile,
					new File(filePath + methodName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			System.out.println("I am in catch");
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult skipped) {
		// TODO Auto-generated method stub
		String skippedTest = skipped.getName();
		System.out.println(skippedTest + "--->" + "Skipped");

	}

	public void onTestStart(ITestResult testStart) {
		// TODO Auto-generated method stub
		
		String nameTest = testStart.getName()+""+testStart.getStartMillis();
		System.out.println(nameTest);

	}

	public void onTestSuccess(ITestResult testSuccess) {
		// TODO Auto-generated method stub
		String name = testSuccess.getName();
		System.out.println(name + "--->" + "passed");
		String methodName = testSuccess.toString().trim();	
		if(sign_in.selected_driver.equals("source"))
			takeScreenShot(methodName,sign_in.sDriver);
		else
			takeScreenShot(methodName,sign_in.tDriver);
		
	}

	
}
