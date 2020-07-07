package com.ibm.mobile.training;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeActivity {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability("deviceName", "selvi tab");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "selvi tab");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		//--- When app is installed ------------
			//cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
			//cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		
		//--When app is not installed, only apk file is available
				//cap.setCapability("app", ".apk file");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		
		driver.findElement(MobileBy.xpath("//*[@content-desc='Search']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(MobileBy.AccessibilityId("Search")).sendKeys("math");
		
		driver.hideKeyboard();
		
		//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Doodling in math: Stars\")")).click();
		
		//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Doodling in math: Stars\")"));
		
		TouchAction act = new TouchAction(driver);
		Dimension d = driver.manage().window().getSize();
		int height = d.height;
		int width = d.width;
		int x1 = width/2;
		int y1 = 4*height/5;
		
		int x2 = width/2;
		int y2 = height/5;
		
		//act.press(PointOption.point(x1,y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x2,y2)).release().perform();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		while(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"Math patterns: table\")")).size()==0) {
			driver.executeScript("mobile:shell", ImmutableMap.of("command","input swipe "+x1+" "+y1+" "+x2+" "+y2));
		}
		
		//System.out.println(driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"Math patterns: table\")")).size());
		
		//act.moveByOffset(x1,y1).clickAndHold().moveByOffset(x2,y2).release().perform();
		
		//To open notifications
		driver.openNotifications();
		
		//driver.findElement(MobileBy.AccessibilityId("Airplane,mode,Off.,Button")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Email\")")).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}

}
