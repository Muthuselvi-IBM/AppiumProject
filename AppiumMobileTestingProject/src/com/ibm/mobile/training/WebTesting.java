package com.ibm.mobile.training;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebTesting {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability("deviceName", "selvi tab");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "selvi tab");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		//cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, 
				//"C:\\Users\\MuthuselviRajapandi\\Documents\\Selenium\\Drivers\\chromedriver.exe");
		
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://google.com");
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys( "selenium");
		
		
	}

}
