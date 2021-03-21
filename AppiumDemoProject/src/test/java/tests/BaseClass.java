package tests;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() {
		
		try {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
//		caps.setCapability("platformName", "ANDROID");
//		caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3a XL API 28");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
//		caps.setCapability(MobileCapabilityType.NO_RESET, true);
//		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//		caps.setCapability(MobileCapabilityType.APP, "");
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		caps.setCapability("appPackage","com.android.calculator2");
		
		caps.setCapability("appActivity","com.android.calculator2.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url,caps);
//		driver = new AndroidDriver<MobileElement>(url,caps); 
	
		}catch(Exception exp)  {
			System.out.println("Cause is :" +exp.getCause());
			System.out.println("Message is :"+exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	@Test
	public void sampleTest() {
		System.out.println("I am inside sample Test");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
		
	}
}
