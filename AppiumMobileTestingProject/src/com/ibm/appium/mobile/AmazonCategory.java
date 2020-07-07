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

public class AmazonCategory {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Selvi's tab");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, 
						"C:\\Users\\MuthuselviRajapandi\\Documents\\Selenium\\Drivers\\chromedriver.exe");
		cap.setCapability("autoDismissAlerts", true);
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://amazon.in");
		
		driver.findElement(By.xpath("//*[@id='nav-hamburger-menu']")).click();
		
		driver.findElement(By.xpath("//*[text()='Fire TV Stick']")).click();	
		driver.findElement(By.xpath("//*[text()='Fire TV Stick with all-new Alexa Voice Remote']")).click();
		
		driver.findElement(By.xpath("//*[contains(text(),'Fire TV Stick + Echo Dot')]")).click();
		
		driver.findElement(By.xpath("//*[text()='Save for Later']")).click();
		
	}

}
