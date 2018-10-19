package POM.moovertest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import org.openqa.selenium.JavascriptExecutor;

public class Create_missing_Fileds {

	// public static WebDriver sourceorg_driver,targetorg_driver;
		public static WebDriverWait wait;

		Loginto_Org sign_in;

		@Test(priority = 2)
		public void TestRun() throws InterruptedException {

			sign_in = Loginto_Org.getInstance();
			sign_in.Sourceorglogin();
			wait = new WebDriverWait(sign_in.sDriver, 30);
			String Source_Windowname = sign_in.sDriver.getWindowHandle();
			// Verify_Object(sign_in.sDriver);
			// CreateMissingfields(sign_in.sDriver);

			// sign_in.Targetorglogin();
			// wait = new WebDriverWait(sign_in.tDriver, 30);
			// Verify_Object(sign_in.tDriver);
			// Thread.sleep(4000);

			// sign_in.sDriver.switchTo().window(Source_Windowname);
			Deployment(sign_in.sDriver);
			sign_in.Targetorglogin();
			wait = new WebDriverWait(sign_in.tDriver, 30);
			ValidateCreatedfields(sign_in.tDriver);
			sign_in.sDriver.switchTo().window(Source_Windowname);

		}

		public static void Verify_Object(WebDriver driver) throws InterruptedException

		{

			(new WebDriverWait(driver, 180))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Setup']/..")))).click();

			WebElement element = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(("//li[contains(@id,'related_setup_app_home')]"))));
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();

			ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windowHandles.get(1));

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Quick Find')]"))))
					.sendKeys("object Manager");

			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//mark[.='Object Manager']")))).click();
			Thread.sleep(5000);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					("//label[contains(@for,'globalQuickfind')]/preceding::div/input[contains(@id,'globalQuickfind')]"))))
					.sendKeys("Java dev");

			// Delete_Object(driver);

			String S10 = "Test";

			try {

				S10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//tbody//tr//th//a[.='Java dev']"))))
						.getText();
				System.out.println("Object is :" + S10);

			} catch (Exception e) {

				System.out.println(e.getMessage());

			}

			if (S10.contains("Java dev"))

			{
				System.out.println("Object is ---");
				System.out.println("Object is already created");
				System.out.println("Deleting Object");
				Delete_Object(driver);
				System.out.println("Object is deleted---");
				Create_Object(driver);

			}

			else

			{

				Create_Object(driver);

			}

		}

		public static void Create_Object(WebDriver driver)

		{
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(("//span[.='Schema Builder']//following::span[.='Create']")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Custom Object']")))).click();
			WebElement ele3 = (new WebDriverWait(driver, 90)).until(
					ExpectedConditions.presenceOfElementLocated(By.xpath(("//iframe[contains(@name,'vfFrameId')]"))));
			driver.switchTo().frame(ele3);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java dev");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'PluralLabel')]"))))
					.sendKeys("Java dev");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[.='Allow Activities']")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[.='Track Field History']")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath(("//*[.='Custom Object Definition Edit']//following::input[contains(@name,'save')][1]"))))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[contains(@title,'Object Manager')]//span"))))
					.click();
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(("(//*[.='Object Manager']//preceding::a[.='Setup'])[2]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Quick Find')]"))))
					.sendKeys("Tab");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//mark[.='Tab'])[2]")))).click();
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(("//input[contains(@title,'New Custom Object Tabs')]")))).click();
			switchingframe(driver);

			Select chooseobject = new Select(
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//select[contains(@name,'p1')]")))));
			chooseobject.selectByVisibleText("Java dev");
			String winHandleBefore = driver.getWindowHandle();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//img[contains(@class,'lookupIcon')]")))).click();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//img[contains(@title,'Airplane')]")))).click();
			driver.switchTo().window(winHandleBefore);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			
			

		}

		

		public static void Delete_Object(WebDriver driver) throws InterruptedException

		{
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[contains(@for,'globalQuickfind')]/preceding::div/input[contains(@id,'globalQuickfind')]")))).sendKeys("java
			// dev");

			try {

				wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_dev__c']//following::td[5]//a"))))
						.click();

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Delete']//span")))).click();

				WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Delete']")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete);

				Thread.sleep(5000);

				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[text()='Del‌​ete']")))).click();

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		public static void switchingframe(WebDriver driver)

		{

			WebElement Frm = (new WebDriverWait(driver, 120))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(("//iframe[contains(@name,'vfFrameId')]"))));
			driver.switchTo().frame(Frm);

		}

		public static void CreateMissingfields(WebDriver driver) throws InterruptedException

		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[.='Fields & Relationships']")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[contains(@title,'Custom Field')]"))))
					.click();

			try {
				switchingframe(driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[.='Auto Number']")))).click();

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();

				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
						.sendKeys("Java_Autonumber");

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'startNum')]"))))
						.sendKeys("15");

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]"))))
						.click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
						.click();

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// number

			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th2)))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Number");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Percent

			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th3)))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Percent");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Phone

			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th4)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Phone");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Email

			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th5)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Email");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Checkbox

			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th6)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Checkbox");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Currency
			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th7)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Currency");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Date
			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th8)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Date");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Date/Time

			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th9)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Date_time");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// URL
			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th10)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_URL");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Time
			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th11)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Time");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Text
			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th12)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Text");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'Length')]"))))
					.sendKeys("18");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Text Area
			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th13)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_TextArea");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Text Area(Long)

			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th14)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_TextAreaLong");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Text Area(Rich)

			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th15)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_TextAreaRich");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Text Encrypted

			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th16)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_TextEncrypted");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'Length')]"))))
					.sendKeys("18");

			Select SL1 = new Select(driver.findElement(By.xpath("//select[contains(@name,'MaskType')]")));
			SL1.selectByVisibleText("Credit Card Number");

			Select SL2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'MaskChar')]")));
			SL2.selectByVisibleText("*");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Formula

			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath((Constant.Th17)))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_Formula");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'DeveloperName')]"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[.='Number']")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[.='Advanced Formula']")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//textarea[contains(@title,'Formula Editor')]"))))
					.sendKeys("Java_Number__c");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Visible')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Next')]")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// multipicklist

			switchingframe(driver);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[.='Picklist (Multi-Select)']")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@title,'Next')])[1]"))))
					.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_multipicklist");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@name,'picklistType')])[2]"))))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//textarea[contains(@name,'ptext')]"))))
					.sendKeys("java1\r\n" + "java2\r\n" + "java3\r\n" + "java4\r\n" + "");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@title,'Next')])[1]"))))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@title,'Visible')])[1]"))))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@title,'Next')])[1]"))))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

			// Picklist
			switchingframe(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//label[.='Picklist']")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@title,'Next')])[1]"))))
					.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@name,'MasterLabel')]"))))
					.sendKeys("Java_picklist");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@name,'picklistType')])[2]"))))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//textarea[contains(@name,'ptext')]"))))
					.sendKeys("java1\r\n" + "java2\r\n" + "java3\r\n" + "java4\r\n" + "");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@title,'Next')])[1]"))))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@title,'Visible')])[1]"))))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@title,'Next')])[1]"))))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save & New')]"))))
					.click();

		}

		/*
		 * public static void ValidateCreatedfields2(WebDriver driver)
		 * 
		 * {
		 * 
		 * (new WebDriverWait(driver, 300))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath((
		 * "//span[.='Setup']/..")))).click(); WebElement element = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.xpath((
		 * "//li[contains(@id,'related_setup_app_home')]")))); Actions action = new
		 * Actions(driver); action.moveToElement(element).click().perform();
		 * 
		 * ArrayList<String> windowHandles = new
		 * ArrayList<String>(driver.getWindowHandles());
		 * driver.switchTo().window(windowHandles.get(1));
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("//input[contains(@placeholder,'Quick Find')]"))))
		 * .sendKeys("object Manager");
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("//mark[.='Object Manager']")))).click();
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("//label[contains(@for,'globalQuickfind')]/preceding::div/input[contains(@id,'globalQuickfind')]"
		 * )))) .sendKeys("java dev");
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("//tbody//tr//th//a[.='Java dev']")))).click();
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("(//*[.='Page Layouts'])[2]")))).click();
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("(//*[.='Java dev Layout'])[3]")))).click();
		 * 
		 * WebElement From1 = driver.findElement(By.xpath("//span[.='Java_Number']"));
		 * WebElement To1 =
		 * driver.findElement(By.xpath("(//span[.='Java dev Name'])[2]")); Actions act =
		 * new Actions(driver);
		 * 
		 * // BANK drag and drop. act.dragAndDrop(From1, To1).build().perform();
		 * 
		 * (//*[.='Related Lists'])[1]
		 * 
		 * 
		 * 
		 * //*[.='Set History Tracking'] (//*[.='Java_Currency'])[2]
		 * (//input[contains(@title,'Save')])[1]
		 * 
		 * 
		 * }
		 * 
		 */
		public static void Deployment(WebDriver driver) throws InterruptedException

		{

			(new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath(("//span[.='Deployment Plans']//preceding::span[.='Data Sets']"))))
					.click();

			(new WebDriverWait(driver, 60))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[contains(@title,'New')]")))).click();

			switchingframe(driver);

			(new WebDriverWait(driver, 60))
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name your data set...')]"))))
					.sendKeys("TestingCreatemissingfunctionality");

			Select drpCountry = new Select((new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath(("//select[contains(@class,'slds-select selectObj dsLabel')]")))));
			drpCountry.selectByVisibleText("Java dev (Java_dev__c)");

			(new WebDriverWait(driver, 60))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Create Missing Fields']"))))
					.click();
			(new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath(("//button[.='Deploy']//following::button[.='Save']")))).click();

			(new WebDriverWait(driver, 60))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[.='Deploy']")))).click();

			Thread.sleep(8000);

			driver.switchTo().defaultContent();

			Thread.sleep(8000);

			WebElement strf = (new WebDriverWait(driver, 60)).until(
					ExpectedConditions.elementToBeClickable(By.xpath(("//iframe[contains(@title,'Deploy Data Set')]"))));
			driver.switchTo().frame(strf);

			Thread.sleep(5000);

			try {

				Select select = new Select((new WebDriverWait(driver, 60)).until(
						ExpectedConditions.elementToBeClickable(By.xpath(("//select[contains(@multiple,'multiple')]")))));

				System.out.println(select.getAllSelectedOptions());
				select.selectByIndex(1);

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}

			(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(
					By.xpath(("//select[contains(@multiple,'multiple')]//following::button[.='Deploy']")))).click();

			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			WebElement strf1 = (new WebDriverWait(driver, 120)).until(ExpectedConditions
					.elementToBeClickable(By.xpath(("//iframe[contains(@name,'vfFrameId')]//following::iframe[2]"))));
			driver.switchTo().frame(strf1);
			Thread.sleep(6000);
			(new WebDriverWait(driver, 80))
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath(("(//div[contains(@class,'plusMinusImage')])[1]//img"))))
					.click();

			Boolean C1 = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//span[.='Finished'])[2]")))).isDisplayed();
			Boolean C2 = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.elementToBeClickable(
							By.xpath(("(//span[.='Result']//following::img[contains(@alt,'Success.')])[1]"))))
					.isDisplayed();

			if (C1 & C2) {
				System.out.println("Deployment completed successfully");

			}

			else {
				System.out.println("Deployment could not get completed successfully");

			}

		}

		/*
		 * public static void ValidateCreatedfields(WebDriver driver) throws
		 * InterruptedException
		 * 
		 * {
		 * 
		 * (new WebDriverWait(driver, 300))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath((
		 * "//span[.='Setup']/..")))).click(); WebElement element = wait.until(
		 * ExpectedConditions.elementToBeClickable(By.xpath((
		 * "//li[contains(@id,'related_setup_app_home')]")))); Actions action = new
		 * Actions(driver); action.moveToElement(element).click().perform();
		 * 
		 * ArrayList<String> windowHandles = new
		 * ArrayList<String>(driver.getWindowHandles());
		 * driver.switchTo().window(windowHandles.get(1));
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("//input[contains(@placeholder,'Quick Find')]"))))
		 * .sendKeys("object Manager");
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("//mark[.='Object Manager']")))).click();
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("//label[contains(@for,'globalQuickfind')]/preceding::div/input[contains(@id,'globalQuickfind')]"
		 * )))) .sendKeys("java dev");
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("//tbody//tr//th//a[.='Java dev']")))).click();
		 * 
		 * wait.until(ExpectedConditions .elementToBeClickable(By.xpath(
		 * ("//*[.='Page Layouts']//preceding::*[.='Fields & Relationships']"))))
		 * .click();
		 * 
		 * List<String> arr2 = Constant.fieldsList1; Iterator<String> itr =
		 * arr2.iterator();
		 * 
		 * while (itr.hasNext())
		 * 
		 * {
		 * 
		 * String S1 = (String) itr.next(); try {
		 * 
		 * wait.until(ExpectedConditions.elementToBeClickable(
		 * By.xpath(("//*[.='Page Layouts']//preceding::*[.='Fields & Relationships']"))
		 * )).click(); wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ("//label[contains(@for,'globalQuickfind')]/preceding::div/input[contains(@id,'globalQuickfind')]"
		 * )))) .sendKeys(S1); String path = "//span[.='" + S1 + "']"; //
		 * System.out.println(path); String S2 =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).getText
		 * ();
		 * 
		 * if (S1.contains(S2))
		 * 
		 * { System.out.println("Field " + S1 + " has been created");
		 * 
		 * }
		 * 
		 * else
		 * 
		 * {
		 * 
		 * System.out.println("Field " + S1 + " has not been created");
		 * 
		 * }
		 * 
		 * }
		 * 
		 * catch (Exception e) { System.out.println(e.getMessage()); }
		 * 
		 * }
		 */

		public static void ValidateCreatedfields(WebDriver driver) throws InterruptedException

		{

			(new WebDriverWait(driver, 300))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Setup']/..")))).click();
			WebElement element = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(("//li[contains(@id,'related_setup_app_home')]"))));
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();

			ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windowHandles.get(1));

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Quick Find')]"))))
					.sendKeys("object Manager");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//mark[.='Object Manager']")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					("//label[contains(@for,'globalQuickfind')]/preceding::div/input[contains(@id,'globalQuickfind')]"))))
					.sendKeys("java dev");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//tbody//tr//th//a[.='Java dev']")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//*[.='Page Layouts'])[2]")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java dev Layout']")))).click();

			switchingframe(driver);

			List<String> arr2 = Constant.fieldsList1;
			Iterator<String> itr = arr2.iterator();

			while (itr.hasNext())

			{

				String S1 = itr.next();
				try {

					String path = "//span[.='" + S1 + "']";
					WebElement From1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path))));

					WebElement To1 = wait
							.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//span[.='Java dev Name'])[2]"))));
					Actions act = new Actions(driver);
					act.dragAndDrop(From1, To1).build().perform();

					// System.out.println(path);
					String S2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).getText();

					if (S1.contains(S2))

					{
						System.out.println("Field " + S1 + " has been created");

					}

					else

					{

						System.out.println("Field " + S1 + " has not been created");

					}

				}

				catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//div[.='Related Lists'])[1]")))).click();

			WebElement From2 = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java dev History']"))));

			WebElement To2 = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(("//div[contains(@class,'pbTitle relatedList')]"))));
			Actions act = new Actions(driver);
			Thread.sleep(2000);
			act.dragAndDrop(From2, To2).build().perform();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//button[.='Save']")))).click();
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(("//*[.='Page Layouts']//preceding::*[.='Fields & Relationships']"))))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//Button[.='Set History Tracking']")))).click();

			switchingframe(driver);
			List<String> arr3 = Constant.fieldsList1;
			Iterator<String> itr1 = arr3.iterator();

			while (itr1.hasNext())

			{

				String S1 = itr.next();
				try {

					String path = "(//*[.='" + S1 + "'])[2]";

					wait.until(ExpectedConditions.elementToBeClickable(By.xpath((path)))).click();

				}

				catch (Exception e) {
					System.out.println(e.getMessage());
				}

				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("(//input[contains(@title,'Save')])[2]"))))
						.click();

			}

			/*
			 * String S11 = "Test";
			 * 
			 * try {
			 * 
			 * S11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
			 * ("//tbody//tr//th//a[.='Java dev']")))).getText();
			 * 
			 * 
			 * } catch(Exception e ){ System.out.println(e); }
			 * 
			 * 
			 * 
			 * 
			 * if(S11.contains("Java dev"))
			 * 
			 * { System.out.println("Object is already created");
			 * System.out.println("Deleting Object"); Delete_Object(driver);
			 * Create_Object(driver); }
			 * 
			 * else
			 * 
			 * { Create_Object(driver);
			 * 
			 * }
			 */

		}

}
