package POM.moovertest;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Sync_Pick_and_Multi_picklist {

	Loginto_Org sign_in;
	public static WebDriverWait wait;

	@Test(priority = 3)
	public void RunSyncpicklist() throws InterruptedException {

		sign_in = Loginto_Org.getInstance();
		String Source_Windowname = sign_in.sDriver.getWindowHandle();
		wait = new WebDriverWait(sign_in.sDriver, 30);
		Addvalues(sign_in.sDriver);
		sign_in.sDriver.close();
		Deployment(sign_in.sDriver);

		wait = new WebDriverWait(sign_in.tDriver, 30);
		String Target_Windowname = sign_in.tDriver.getWindowHandle();
		sign_in.tDriver.switchTo().window(Target_Windowname);
		Validate_synced_picklist(sign_in.tDriver);
		sign_in.tDriver.close();
		sign_in.sDriver.switchTo().window(Source_Windowname);

	}

	public static void Addvalues(WebDriver driver) throws InterruptedException

	{

		(new WebDriverWait(driver, 60))
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
				.sendKeys("java dev");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_dev__c']//preceding::*[1]"))))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[.='Fields & Relationships']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_picklist']")))).click();
		swithingframe1(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'New Values')]"))))
				.click();
		swithingframe1(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//textarea[contains(@title,'Java_picklist')]"))))
				.sendKeys("" + "java5\r\n" + "java6\r\n" + "");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save')]")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[.='Fields & Relationships']")))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_multipicklist']")))).click();
		swithingframe1(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'New Values')]"))))
				.click();
		swithingframe1(driver);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//textarea[contains(@title,'Java_multipicklist')]"))))
				.sendKeys("" + "java5\r\n" + "java6\r\n" + "");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@title,'Save')]")))).click();

	}

	public static void swithingframe1(WebDriver driver)

	{

		WebElement Frm = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(("//iframe[contains(@name,'vfFrameId')]"))));
		driver.switchTo().frame(Frm);

	}

	public static void Deployment(WebDriver driver) throws InterruptedException

	{

		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//span[.='Deployment Plans']//preceding::span[.='Data Sets']"))))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//div[contains(@title,'New')]")))).click();

		swithingframe1(driver);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Name your data set...')]"))))
				.sendKeys("TestingCreatemissingfunctionality");

		Select drpCountry = new Select(wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//select[contains(@class,'slds-select selectObj dsLabel')]")))));
		drpCountry.selectByVisibleText("Java dev (Java_dev__c)");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Sync Picklist Field Values']"))))
				.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//button[.='Deploy']//following::button[.='Save']")))).click();

		System.out.println("hello5");

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

		System.out.println("hello1");
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(("//select[contains(@multiple,'multiple')]//following::button[.='Deploy']")))).click();
		System.out.println("hello2");
		Thread.sleep(8000);
		driver.switchTo().defaultContent();
		Thread.sleep(8000);
		WebElement strf1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(("//iframe[contains(@name,'vfFrameId')]//following::iframe[2]"))));
		driver.switchTo().frame(strf1);

		// swithingframe1(driver);
		Boolean C1 = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Finished']")))).isDisplayed();

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

	public static void Validate_synced_picklist(WebDriver driver)

	{
		try {

			(new WebDriverWait(driver, 60))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Setup']/..")))).click();

			WebElement element = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(("//li[contains(@id,'related_setup_app_home')]"))));
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();

			ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windowHandles.get(1));

			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(("//input[contains(@placeholder,'Quick Find')]"))))
					.sendKeys("object Manager");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//mark[.='Object Manager']")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					("//label[contains(@for,'globalQuickfind')]/preceding::div/input[contains(@id,'globalQuickfind')]"))))
					.sendKeys("java dev");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//tbody//tr//th//a[.='Java dev']")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath(("//*[.='Page Layouts']//preceding::*[.='Fields & Relationships']")))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_picklist']")))).click();
			swithingframe1(driver);
			String T1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[.='java5']")))).getText();
			String T2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[.='java6']")))).getText();

			if (T1.contains("java5") && T2.contains("java6"))

			{
				System.out.println("Picklist values have been synced ");
			}

			else

			{
				System.out.println("Picklist values have not been synced ");
			}

		}

		catch (Exception e)

		{
			System.out.println(e.getMessage());
		}

		try {

			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath(("//*[.='Page Layouts']//preceding::*[.='Fields & Relationships']")))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//span[.='Java_multipicklist']")))).click();
			swithingframe1(driver);
			String T3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[.='java5']")))).getText();
			String T4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//*[.='java6']")))).getText();
			if (T3.contains("java5") && T4.contains("java6"))

			{
				System.out.println("Multipicklist values have been synced ");
			}

			else

			{
				System.out.println("Multipicklist values have not been synced ");
			}

		}

		catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	
}
