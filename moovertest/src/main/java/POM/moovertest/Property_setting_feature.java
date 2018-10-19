package POM.moovertest;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Property_setting_feature  extends Constant{

	public static WebDriverWait wait;
	Loginto_Org sign_in;
	@Test
	public void Runtest() throws InterruptedException {

		sign_in = Loginto_Org.getInstance();
		sign_in.Sourceorglogin();
		wait = new WebDriverWait(sign_in.sDriver, 30);
		//test(sign_in.sDriver);
		//create_record_in_Sourceorg(sign_in.sDriver);
		create_Dataset_for_Scramblevaluefeature(sign_in.sDriver);
		//Validate_Scramblevaluefeature(sign_in.sDriver);

	}

	public static void create_record_in_Sourceorg(WebDriver driver) throws InterruptedException

	{
		System.out.println("Hello");
		
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[contains(@class,'slds-icon-waffle')]"))))
				.click();
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[.='Moover']")))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Search apps or items...')]"))))
				.sendKeys("java dev");
		// Thread.sleep(10000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//mark[.='Java dev']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[contains(@title,'New')]")))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//label//span[.='Java dev Name']//following::input[1]"))))
				.sendKeys("Java_dev1");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_Number']//following::input[1]"))))
				.sendKeys("366");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_Percent']//following::input[1]"))))
				.sendKeys("555");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_Phone']//following::input[1]"))))
				.sendKeys("7737485858");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_Email']//following::input[1]"))))
				.sendKeys("vishnu4770@gmail.com");
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_Checkbox']//following::input[1]"))))
				.click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_Currency']//following::input[1]"))))
				.sendKeys("2525");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_Date']//following::input[1]"))))
				.sendKeys("9/25/2018");
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_Date_time']//following::input[1]"))))
				.sendKeys("9/25/2018");
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='ava_Date_time']//following::input[2]")))).sendKeys("12:00
		// AM");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_URL']//following::input[1]"))))
				.sendKeys("www.gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[.='Java_Time']//following::input[1]"))))
				.sendKeys("12:00 AM");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_Text']//following::input[1]"))))
				.sendKeys("Hello i am vishnu");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//span[.='Java_TextArea']//following::textarea[1]"))))
				.sendKeys("This is text area");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//span[.='Java_TextAreaLong']//following::textarea[1]"))))
				.sendKeys("This is long text area");
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_TextAreaRich']//following::div[5]//div[1]"))))
				.sendKeys("This rich text area");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//span[.='Java_TextEncrypted']//following::input[1]"))))
				.sendKeys("12345");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[contains(@title,'Save')][2]")))).click();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
	}

	public static void create_Dataset_for_Scramblevaluefeature(WebDriver driver) throws InterruptedException

	{

		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//span[.='Deployment Plans']//preceding::span[.='Data Sets']"))))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[contains(@title,'New')]")))).click();

		switchingframe(driver);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name your data set...')]"))))
				.sendKeys("ScramblevalueTest");

		Select drpCountry = new Select(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//select[contains(@class,'slds-select selectObj dsLabel')]")))));
		drpCountry.selectByVisibleText("Java dev (Java_dev__c)");
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name
		// your data set...')]")))).sendKeys("ScramblevalueTest");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(("//*[.='Data Set Editor - ScramblevalueTest']//following::a[.='Object Fields']")))).click();

		try {
			for (String fieldName : fieldsList) {

				String path = "//*[.='" + fieldName + "']//following::span[contains(@class,'fieldSettingIconPanel"
						+ fieldName + "__c')]";
				
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[.=' Scramble Value']")))).click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//button[.='Close'])[1]")))).click();
				Thread.sleep(2000);

			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//button[.='Deploy']//following::button[.='Save']")))).click();

		Deployment(driver);

	}

	

	public static void Validate_Scramblevaluefeature(WebDriver driver)

	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[.='View Results'])[1]")))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Related']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[contains(@class,'uiOutputURL')])[2]"))))
				.click();

		// switch to new tab

		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[contains(@title,'Details')]")))).click();

		try {
			for (String fieldName : fieldsList) {

				for (String fieldValue : fieldsList2) {

					String path = "//span[.='Edit " + fieldName + "']";
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).click();
					String Value = wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath(("(//span[.='" + fieldName + "'])[2]//following::input[1]")))).getText();
					Boolean Testing = Value.equals(fieldValue);
					if (Testing) {
						System.out.println("value for the field" + fieldName + "is not scrambled");
					} else {
						System.out.println("value for the field" + fieldName + "is scrambled");
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}


	public static void create_Dataset_for_Fixedvaluefeature(WebDriver driver) throws InterruptedException

	{

		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//span[.='Deployment Plans']//preceding::span[.='Data Sets']"))))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[contains(@title,'New')]")))).click();

		switchingframe(driver);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name your data set...')]"))))
				.sendKeys("FixedvalueTest");

		Select drpCountry = new Select(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//select[contains(@class,'slds-select selectObj dsLabel')]")))));
		drpCountry.selectByVisibleText("Java dev (Java_dev__c)");
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name
		// your data set...')]")))).sendKeys("ScramblevalueTest");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(("//*[.='Data Set Editor - FixedvalueTest']//following::a[.='Object Fields']")))).click();

		try {
			for (String fieldName : fieldsList) {

				for (String fieldvalue : fieldsList2) {

					String path = "//*[.='" + fieldName + "']//following::span[contains(@class,'fieldSettingIconPanel"
							+ fieldName + "__c')]";
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[.=' Fixed Value']")))).click();
					wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath(("//textarea[contains(@placeholder,'Fixed field value...')]"))))
							.sendKeys(fieldvalue);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//button[.='Close'])[1]")))).click();

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//button[.='Deploy']//following::button[.='Save']")))).click();

		Deployment(driver);

	}

	
	public static void Validate_Fixedvaluefeature(WebDriver driver)

	{
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[.='View Results'])[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Related']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[contains(@class,'uiOutputURL')])[2]")))).click();
		
		
		//switch to new tab
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[contains(@title,'Details')]")))).click();
		
		try {
			for (String fieldName : fieldsList) {
				
				for (String fieldValue : fieldsList2) {

				String path = "//span[.='Edit " + fieldName +"']";
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).click();
				String Value = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//span[.='" + fieldName + "'])[2]//following::input[1]")))).getText();
				Boolean Testing = Value.equals(fieldValue);
				if(Testing)
				{
				System.out.println("value for the field" + fieldName + "is fixed");
			}
				else
				{
					System.out.println("value for the field" + fieldName + "is not fixed");
				}
		}
	}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		
	}
	
	public static void create_Dataset_for_Deploylastfeature(WebDriver driver) throws InterruptedException

	{

		
		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//span[.='Deployment Plans']//preceding::span[.='Data Sets']"))))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[contains(@title,'New')]")))).click();

		switchingframe(driver);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name your data set...')]"))))
				.sendKeys("DeploylastTest");

		Select drpCountry = new Select(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//select[contains(@class,'slds-select selectObj dsLabel')]")))));
		drpCountry.selectByVisibleText("Java dev (Java_dev__c)");
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name
		// your data set...')]")))).sendKeys("ScramblevalueTest");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(("//*[.='Data Set Editor - DeploylastTest']//following::a[.='Object Fields']")))).click();

		try {
			for (String fieldName : fieldsList) {

				for (String fieldvalue : fieldsList3) {

					String path = "//*[.='" + fieldName + "']//following::span[contains(@class,'fieldSettingIconPanel"
							+ fieldName + "__c')]";
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[.='Deploy Last']")))).click();
					wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath(("(//textarea[contains(@placeholder,'Temporary field value...')])[2]"))))
							.sendKeys(fieldvalue);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//button[.='Close'])[1]")))).click();

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//button[.='Deploy']//following::button[.='Save']")))).click();

		Deployment(driver);

		
	}

	
	public static void Validate_Deploylastfeature(WebDriver driver)
	
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[.='View Results'])[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Related']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[contains(@class,'uiOutputURL')])[2]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Related']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java dev History']")))).click();
		
		
		// capture screenshot

	}
	
	public static void create_Dataset_for_Deployoninsertfeature(WebDriver driver) throws InterruptedException

	{

		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//span[.='Deployment Plans']//preceding::span[.='Data Sets']"))))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[contains(@title,'New')]")))).click();

		switchingframe(driver);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name your data set...')]"))))
				.sendKeys("DeployInsertTest");

		Select drpCountry = new Select(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//select[contains(@class,'slds-select selectObj dsLabel')]")))));
		drpCountry.selectByVisibleText("Java dev (Java_dev__c)");
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name
		// your data set...')]")))).sendKeys("ScramblevalueTest");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(("//*[.='Data Set Editor - DeployInsertTest']//following::a[.='Object Fields']")))).click();

		try {
			for (String fieldName : fieldsList) {

				for (String fieldvalue : fieldsList4) {

					String path = "//*[.='" + fieldName + "']//following::span[contains(@class,'fieldSettingIconPanel"
							+ fieldName + "__c')]";
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[.='Delay On Insert']")))).click();
					wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath(("(//textarea[contains(@placeholder,'Temporary field value...')])[1]"))))
							.sendKeys(fieldvalue);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//button[.='Close'])[1]")))).click();

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//button[.='Deploy']//following::button[.='Save']")))).click();

		Deployment(driver);

	}

	public static void Validate_DeployInsertfeature(WebDriver driver)

	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[.='View Results'])[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Related']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[contains(@class,'uiOutputURL')])[2]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Related']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java dev History']")))).click();

		// capture screenshot

	}
	
	public static void create_Dataset_for_SetEmptyfeature(WebDriver driver) throws InterruptedException

	{

		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//span[.='Deployment Plans']//preceding::span[.='Data Sets']"))))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[contains(@title,'New')]")))).click();

		switchingframe(driver);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name your data set...')]"))))
				.sendKeys("SetEmptyTest");

		Select drpCountry = new Select(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//select[contains(@class,'slds-select selectObj dsLabel')]")))));
		drpCountry.selectByVisibleText("Java dev (Java_dev__c)");
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name
		// your data set...')]")))).sendKeys("ScramblevalueTest");

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(("//*[.='Data Set Editor - SetEmptyTest']//following::a[.='Object Fields']")))).click();

		try {
			for (String fieldName : fieldsList) {

				String path = "//*[.='" + fieldName + "']//following::span[contains(@class,'fieldSettingIconPanel"
						+ fieldName + "__c')]";
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[.=' Set Empty']")))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//button[.='Close'])[1]")))).click();

			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//button[.='Deploy']//following::button[.='Save']")))).click();

		Deployment(driver);

	}

	public static void Validate_SetEmptyfeature(WebDriver driver)

	{
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[.='View Results'])[1]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Related']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[contains(@class,'uiOutputURL')])[2]")))).click();
		
		
		//switch to new tab
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[contains(@title,'Details')]")))).click();
		
		try {
			for (String fieldName : fieldsList) {

				String path = "//span[.='Edit " + fieldName +"']";
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).click();
				String Value = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//span[.='" + fieldName + "'])[2]//following::input[1]")))).getText();
				Boolean Testing = Value.isEmpty();
				if(Testing)
				{
				System.out.println("value for the field" + fieldName + "is Set Empty");
			}
				else
				{
					System.out.println("value for the field" + fieldName + "is not Set Empty");
				}
		}
	}
		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		
	}	
	
	
	public static void Deployment(WebDriver driver) throws InterruptedException

	{

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[.='Deploy']")))).click();

		Thread.sleep(8000);

		driver.switchTo().defaultContent();

		Thread.sleep(8000);

		WebElement strf = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(("//iframe[contains(@title,'Deploy Data Set')]"))));
		driver.switchTo().frame(strf);

		Thread.sleep(5000);

		try {

			Select select = new Select(wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(("//select[contains(@multiple,'multiple')]")))));

			System.out.println(select.getAllSelectedOptions());
			select.selectByIndex(1);

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(("//select[contains(@multiple,'multiple')]//following::button[.='Deploy']")))).click();

		Thread.sleep(4000);

		driver.switchTo().defaultContent();
		Thread.sleep(50000);

		WebElement strf1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//iframe[contains(@name,'vfFrameId')]//following::iframe[2]"))));
		driver.switchTo().frame(strf1);

		Boolean C1 = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//span[.='Finished'])[2]")))).isDisplayed();

		Boolean C2 = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Result']//following::img[1]"))))
				.isDisplayed();

		if (C1 & C2) {
			System.out.println("Deployment completed successfully");

		}

		else {
			System.out.println("Deployment could not get completed successfully");

		}

	}
	
	public static void switchingframe(WebDriver driver)

	{

		WebElement Frm = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(("//iframe[contains(@name,'vfFrameId')]"))));
		driver.switchTo().frame(Frm);

	}
	

}
