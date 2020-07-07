package com.ibm.appium.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class UdemyBrowse {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Selvi's tab");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.udemy.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.udemy.android.SplashActivity");
		
		//Driver Setup
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		AndroidElement browse_btn = driver.findElement(MobileBy.id("com.udemy.android:id/browse_button"));
		if(browse_btn.isDisplayed()) {
			browse_btn.click();
			driver.findElement(MobileBy.AccessibilityId("Search tab")).click();
			driver.findElement(MobileBy.id("com.udemy.android:id/search_bar_text")).click();
			driver.findElement(MobileBy.id("com.udemy.android:id/search_bar_text")).sendKeys("selenium");
			driver.hideKeyboard();
			
			driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"com.udemy.android:id/body\")")).click();
			
			List<AndroidElement> course_title = driver.findElements(MobileBy.
					AndroidUIAutomator("UiSelector().resourceId(\"com.udemy.android:id/course_title\")"));
			
			int courses_displayed = course_title.size();
			
			System.out.println("No.of Courses displayed : "+courses_displayed);
			System.out.println("Course clicked is : "+course_title.get(0).getText());
			course_title.get(0).click();
			
			AndroidElement addToCart = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")"));
			
			if(addToCart.isDisplayed()) {
				System.out.println("PASS : Add to Cart is displayed");
				addToCart.click();
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"SIGN IN\")")).click();
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in with email\")")).click();
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Email\")")).sendKeys("rmselvi16@gmail.com");
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Next\")")).click();
				
				driver.findElement(MobileBy.id("com.udemy.android:id/password")).sendKeys("Welcome@123");
				
				driver.findElement(MobileBy.id("com.udemy.android:id/signin_button")).click();
				
				AndroidElement goToCart = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"GO TO CART\")"));
				if(goToCart.isDisplayed()) { 
					
					System.out.println("PASS : Course is added to cart");
				}else {
					System.out.println("FAIL : Course is not added to cart");
				}
				
				//To Go back to main screen 
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				
				Thread.sleep(3000);
				
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				
				AndroidElement acc_icon = driver.findElement(MobileBy.AccessibilityId("Account tab"));
				if(acc_icon.isDisplayed()) {
					acc_icon.click();
					driver.findElement(MobileBy.id("com.udemy.android:id/sign_out")).click();
					
					driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"SIGN OUT\")")).click();
					System.out.println("Tada!!! Signed Out from App");
				}
				else {
					System.out.println("FAIL : User Account is not created !!!");
				}
			}else {
				System.out.println("FAIL : Add To Cart is not displayed");
			}
			
		}
		
		

	}

}
