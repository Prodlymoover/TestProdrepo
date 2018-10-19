package POM.moovertest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Loginto_Org {

	private static Loginto_Org instance;
	public WebDriver sDriver, tDriver;
	public String selected_driver;

	public Loginto_Org() {
	}

	// static method to create instance of Singleton class
	public static Loginto_Org getInstance() {
		if (instance == null)
			instance = new Loginto_Org();

		return instance;
	}

	
	
	
	public void Sourceorglogin()

	{

		selected_driver = "source";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		sDriver = new ChromeDriver(capabilities);
		// driver = new ChromeDriver();
		sDriver.manage().window().maximize();
		sDriver.get("https://test.salesforce.com/");
		sDriver.findElement(By.id("username")).sendKeys("avanish.kumar@simplyforce.com.moover2.qa4");
		sDriver.findElement(By.id("password")).sendKeys("prodlymoover123");
		sDriver.findElement(By.id("Login")).click();
		// return driver;

	}

	@SuppressWarnings("deprecation")
	public void Targetorglogin()

	{

		selected_driver = "target";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		tDriver = new ChromeDriver(capabilities);
		// driver = new ChromeDriver();
		tDriver.manage().window().maximize();

		tDriver.get("https://test.salesforce.com/");
		tDriver.findElement(By.id("username")).sendKeys("avanish.kumar@simplyforce.com.moover2.qa3");
		tDriver.findElement(By.id("password")).sendKeys("prodlymoover123");
		tDriver.findElement(By.id("Login")).click();

		// return driver;

	}

	
}
