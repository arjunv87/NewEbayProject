package generic;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

	
	

	
public class GenericUtils extends BaseTest
{
	//***********This method will change the County to Australia ****************	
	public static void changeCountry() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement hambergMenu = driver.findElement(By.id("com.ebay.mobile:id/home"));
		hambergMenu.click();
		GenericUtils.scrollAndClick((AndroidDriver<MobileElement>) driver, "Settings");
		MobileElement settings = driver.findElement(By.xpath("//*[@text='Settings']"));
		settings.click();
		MobileElement country = driver.findElement(By.xpath("//*[@text='Country / region']"));
		country.click();
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("//*[@text='ON']")).click();
			MobileElement region = driver.findElement(By.xpath("//*[@text='India']"));
			region.click();
			driver.findElement(By.xpath("//*[@text='Enter search text']")).sendKeys("australia");
			driver.findElement(By.xpath("//*[@text='Australia']")).click();
			driver.findElementByAccessibilityId("Navigate up").click();
			driver.findElementByAccessibilityId("Navigate up").click();
			Thread.sleep(3000);
		}
		
	
	//**********This Method will Search the Required product*******************
	@SuppressWarnings("rawtypes")
	public static void searchProduct(AppiumDriver<MobileElement> driver, String product) throws InterruptedException
	{
		MobileElement searchBox = driver.findElement(By.xpath("//*[@text='Search for anything']"));
		searchBox.sendKeys(product);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(3000);	
	}
	//*********This method will scroll to mentioned element and click that Element****************
	public static void scrollAndClick(AndroidDriver<MobileElement> driver,String visibleText) 
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	}
	
	//*********This method will scroll to mentioned element****************
	public static void scroll(String visibleText) 
	{
		((FindsByAndroidUIAutomator<?>) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))");
	}
	
	public static void clickButton(String text)
	{
		GenericUtils.scroll(text);
		driver.findElement(By.xpath("//*[@text='"+text+"']")).click();
	}
	
	
	
	
	
	
	 
}
		

		


