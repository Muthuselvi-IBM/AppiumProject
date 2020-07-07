package com.ibm.appium.mobile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonSignUp {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Selvi's tab");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, 
						"C:\\Users\\MuthuselviRajapandi\\Documents\\Selenium\\Drivers\\chromedriver.exe");
		//cap.setCapability("autoDismissAlerts", true);
		
		//Driver Setup
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		driver.get("https://amazon.in");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Account & Lists']")));
		
		driver.findElement(By.xpath("//*[text()='Account & Lists']")).click();
		
		driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
		
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("Muthuselvi");
		
		driver.findElement(By.xpath("//input[@id='ap_phone_number']")).sendKeys("8867632797");
		
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("rmselvi161@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Welcome@123");
		
		
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		WebElement error_msg = driver.findElement(By.xpath("//h4[text()='Mobile number already in use']"));
		String err_msg = error_msg.getText();
		
		if(error_msg.isDisplayed()) {
			String error_content = driver.findElement(By.xpath("//div[@class='a-box a-alert a-alert-warning a-spacing-base']/div/div/p")).getText();
			System.out.println("Error Content : \n"+err_msg+"\n"+error_content);
			byte[] screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			new FileOutputStream("PASS_AmazonSignup.jpg").write(screenshot);
		}else {
			System.out.println("Error message is not displayed");
			byte[] screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			new FileOutputStream("FAIL_AmazonSignup.jpg").write(screenshot);
		}

	}

}
