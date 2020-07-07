package com.ibm.appium.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonAddToCart {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Selvi's tab");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, 
						"C:\\Users\\MuthuselviRajapandi\\Documents\\Selenium\\Drivers\\chromedriver.exe");
		//cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.amazon.windowshop");
		//cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.windowshop.home.HomeLauncherActivity");
		
		//Driver Setup
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.get("https://amazon.in");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone 7 case");
		
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		
		WebElement iphone_case = driver.findElement(By.xpath("//img[@alt='Spigen Ultra Hybrid Back Cover Case Designed for iPhone SE (2020) / iPhone 8 / iPhone 7 - Black']"));
		if(iphone_case.isDisplayed()) {
			iphone_case.click();
		}
		
		Set<String> win_id = driver.getWindowHandles();
		System.out.println(win_id);
		// String winHandle=win_id.iterator().next();
			//driver.switchTo().window(winHandle);
			
		driver.findElement(By.xpath("//*[text() = 'Rose Crystal']")).click();
		
		Select quanity = new Select(driver.findElement(By.id("quantity")));
		quanity.selectByVisibleText("5");
		
		driver.findElement(By.xpath("//*[text()='Save for Later']")).click();
		
	}

}
