package com.ibm.appium.mobile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonDeals {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Selvi's tab");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.amazon.windowshop");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.amazon.windowshop.home.HomeLauncherActivity");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(MobileBy.id("com.amazon.windowshop:id/skip_sign_in_button")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"com.amazon.windowshop:id/action_bar_burger_icon\")")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Today's Deals\")")).click();
		
			System.out.println("Deals of the day page is displayed");
			
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"100 9ef8f8f0-announce\")")).click();
			
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().description(\"asin image url\")")).click();
			
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"add-to-cart-button\")")).click();
			
			String cart_msg = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"android:id/message\")")).getText();
			
			if(cart_msg!="") {
				System.out.println("PASS : "+cart_msg);
				byte[] screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				new FileOutputStream("PASS_AmazonDeals.jpg").write(screenshot);
			}else {
				System.out.println("FAIL");
				byte[] screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				new FileOutputStream("PASS_AmazonDeals.jpg").write(screenshot);
			}
	}

}
