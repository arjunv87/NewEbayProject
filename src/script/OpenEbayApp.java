package script;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.GenericUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

//*********************Script to Add Product to cart and Verify its Price while Checking out****************************
public class OpenEbayApp extends BaseTest {
	
	
	@Test(priority=0)
	public void myFirstAppiumtc() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		GenericUtils.changeCountry();
		GenericUtils.searchProduct(driver, "65-inch TV");
		GenericUtils.scrollAndClick((AndroidDriver<MobileElement>) driver, "Panasonic");
				
		//***********Getting the product details from product details page and storing to variable//
		String tvPrice = driver.findElement(By.xpath("//*[@text='AU $1,199']")).getText();
		String tvName = driver.findElement(By.xpath("//*[@text='TH-65FX600A Panasonic 65 Inch LED TV']")).getText();
		
		GenericUtils.scrollAndClick((AndroidDriver<MobileElement>) driver, "ADD TO CART");
		GenericUtils.scrollAndClick((AndroidDriver<MobileElement>) driver, "VIEW IN CART");
		GenericUtils.scrollAndClick((AndroidDriver<MobileElement>) driver, "CHECKOUT");
		
		//***********Getting the product details from checkoutpage and storing to variable//
		String cartTvName = driver.findElement(By.xpath("//*[@text='TH-65FX600A Panasonic 65 Inch LED TV']")).getText();
		String cartTvPrice = driver.findElement(By.xpath("//*[@text='AU $1,239.00']")).getText().trim();
		
		
		//************Verify if TV price is equal to Cart Price while Checking Out**************
		SoftAssert sAssert=new SoftAssert();
		sAssert.assertEquals(tvPrice,cartTvPrice);
		sAssert.assertTrue(tvPrice.equals(cartTvPrice),"The price of the TV is not matching in the checkout page as in Product detail page");
		sAssert.assertEquals(tvName, cartTvName);
		sAssert.assertFalse(tvName.equals(cartTvName),"The name of the TV in product detail page is matching the name of the TV in the checkout page");
		sAssert.assertAll();
		
	}
}
