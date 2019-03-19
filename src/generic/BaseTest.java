package generic;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;



public abstract class BaseTest implements IAutoConst {

	
	public static AppiumDriver<MobileElement> driver;
	private static DesiredCapabilities capabilities;
	
	
	//Setting the DesiredCapabilities
	@BeforeClass(alwaysRun=true)
	public void beforeClass()
	{
		capabilities = new DesiredCapabilities();
		 capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		 capabilities.setCapability("deviceName", lib.getProperty(CONFIG_PATH, "deviceName"));
		 capabilities.setCapability("udid", lib.getProperty(CONFIG_PATH, "udid"));
		 capabilities.setCapability("platformVersion", lib.getProperty(CONFIG_PATH, "platformVersion"));
		 capabilities.setCapability("platformName", lib.getProperty(CONFIG_PATH, "platformName"));
		 capabilities.setCapability("appPackage", lib.getProperty(CONFIG_PATH, "appPackage"));
		 capabilities.setCapability("appActivity", lib.getProperty(CONFIG_PATH, "appActivity"));
		 capabilities.setCapability("noReset", true);
				
	}

		//Opening the ebay app through Android driver and loging in to the application		
		@BeforeMethod(alwaysRun=true)
		
		public void beforeMethod()
		{
			
				try {
					driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
					
				} catch (MalformedURLException e) {
					System.out.println(e.getMessage());
				}
				
			//to login--to the application
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
				driver.findElement(By.xpath("//*[@resource-id='com.ebay.mobile:id/edit_text_username']")).sendKeys(lib.readData("login", 1, 0));
				driver.findElement(By.id("com.ebay.mobile:id/edit_text_password")).sendKeys(lib.readData("login", 1, 1));
				driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
				
	}



		@AfterClass(alwaysRun=true)
		public static void afterMethod()
		{
			driver.quit();
		}
	


}
