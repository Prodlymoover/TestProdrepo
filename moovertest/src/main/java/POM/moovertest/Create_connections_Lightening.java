package POM.moovertest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Create_connections_Lightening {
	Loginto_Org sign_in;
	public static WebDriverWait wait;

	@Test(priority = 1)
	public void Test_Connection() throws Exception {
		sign_in = Loginto_Org.getInstance();
		sign_in.Sourceorglogin();
		wait = new WebDriverWait(sign_in.sDriver, 30);
		Connection_Test(sign_in.sDriver);
	}

	public void Connection_Test(WebDriver driver) throws Exception

	{

		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'Connections')]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='New']"))).click();

			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[contains(@placeholder, 'Optional connection name')]"))
					.sendKeys("Local connection");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Connect']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@title, 'Edit Active')]")))
					.click();

			Thread.sleep(6000);
			boolean checked1 = driver.findElement(By.xpath("//span[.='Active']/../../input")).isSelected();
			boolean checked2 = driver.findElement(By.xpath("//span[.='Control Org']/../../input")).isSelected();
			if (checked1 && checked2) {
				System.out.println("local connection is created");
			} else
				System.out.println("Local connection is not created");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Cancel']"))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'Connections')]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='New']"))).click();

			Thread.sleep(5000);

			driver.findElement(By.xpath("//input[contains(@placeholder,'Optional connection name...')]"))
					.sendKeys("Destination connection");
			Thread.sleep(3000);
			WebElement mySelectElement = driver.findElement(By.xpath("//select[contains(@class,'slds-select')]"));
			Select dropdown = new Select(mySelectElement);
			dropdown.selectByVisibleText("Sandbox");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Connect']"))).click();
			Thread.sleep(10000);
			driver.findElement(By.id("username")).sendKeys("avanish.kumar@simplyforce.com.moover2.qa3");
			driver.findElement(By.id("password")).sendKeys("prodlymoover123");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@name, 'Login')]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id, 'oaapprove')]")))
					.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@title, 'Edit Active')]")))
					.click();
			Thread.sleep(6000);
			boolean checked3 = driver.findElement(By.xpath("//span[.='Active']/../../input")).isSelected();
			boolean checked4 = driver.findElement(By.xpath("//span[.='Control Org']/../../input")).isSelected();

			if (checked3 == true && checked4 == false) {
				System.out.println("destination connection is created");
			}

			else {
				System.out.println("destination connection is not created");
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Cancel']"))).click();

		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
