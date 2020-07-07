package com.ibm.mobile.training;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class NativeAppTesting {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "selvi tab");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				
				cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
				cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
				
			//	cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, 
						//"C:\\Users\\MuthuselviRajapandi\\Documents\\Selenium\\Drivers\\chromedriver.exe");
				//cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
				// cap.setCapability(MobileCapabilityType.NO_RESET, true);
				
				AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
				
				driver.findElement(MobileBy.AccessibilityId("Continue with Facebook")).click();
				
				Thread.sleep(5000);
				
				System.out.println(driver.getContextHandles());
				
				driver.context("NATIVE_APP");
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"m_login_email\")")).sendKeys("test");
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"m_login_password\")")).sendKeys("test");
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log In\")")).click();
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log in to your Facebook account to connect to Khan Academy\")")).click();
				
				WebElement error = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"The mobile number or email address that you've entered doesn't match any account.\")"));
				
				if(error.isDisplayed()) {
					System.out.println("PASS : "+error);
				}

	}

}
