package POM.moovertest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Createdataset {

public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			WebDriver driver=new ChromeDriver(capabilities);
       // driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://test.salesforce.com/");
	    driver.findElement(By.id("username")).sendKeys("avanish.kumar@simplyforce.com.moover1.winter6");
	    driver.findElement(By.id("password")).sendKeys("prodlymoover1234");
	    driver.findElement(By.id("Login")).click();
	    driver.findElement(By.xpath("//*[.='Templates']")).click();
	    driver.findElement(By.xpath("//a[.='T-00000000']//following::a[.='T-00000000']")).click();
	    driver.findElement(By.xpath("//input[contains(@title,'Generate Data Set')]")).click();
		
	}
	
	
}
