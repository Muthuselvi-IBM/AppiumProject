package com.ibm.appium.mobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class UdemySignIn {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Selvi's tab");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.udemy.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.udemy.android.SplashActivity");
		
		//Driver Setup
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		AndroidElement signin_btn = driver.findElement(MobileBy.id("com.udemy.android:id/signin_button"));
		
		if(signin_btn.isDisplayed()) {
			System.out.println("PASS : Sign in button is displayed");
			signin_btn.click();
			
			//SignIn Page
			AndroidElement signin_page = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")"));
			if(signin_page.isDisplayed()) {
				System.out.println("PASS : Sign in page is displayed");
				driver.findElement(MobileBy.id("com.udemy.android:id/create_account_or_sign_in")).click();
				
				driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign up with email\")")).click();
				
			//Create an Account Page
				AndroidElement create_acc_page = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Create an account\")"));
				if(create_acc_page.isDisplayed()) {
					driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Name\")")).sendKeys("selmsjjhd");
					driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Email\")")).sendKeys("rmtestwer123@gmail.com");
					driver.findElement(MobileBy.id("com.udemy.android:id/password_edit")).sendKeys("Welcome@123");
					
					driver.findElement(By.id("com.udemy.android:id/create_account_button")).click();
					
					
					AndroidElement acc_icon = driver.findElement(MobileBy.AccessibilityId("Account tab"));
					if(acc_icon.isDisplayed()) {
						System.out.println("PASS : User Account is created !!!");
						acc_icon.click();
						
						driver.findElement(MobileBy.id("com.udemy.android:id/sign_out")).click();
						
						driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"SIGN OUT\")")).click();
						System.out.println("Tada!!! Signed Out from App");
					}
					else {
						System.out.println("FAIL : User Account is not created !!!");
					}
					
					
				}else {
					System.out.println("FAIL : Create Account Page is not displayed");
				}
				
			}else {
				System.out.println("FAIL : Sign in Page is not displayed");
			}
			
			
		}else {
			System.out.println("FAIL : Sign in button is not displayed");
		}

	}

}
