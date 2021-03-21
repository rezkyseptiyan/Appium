package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstAppium {
	
	AndroidDriver<MobileElement> driver;
	
	@Test
	public void setup() throws MalformedURLException, InterruptedException {
		
DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3a XL API 28");
		caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
		caps.setCapability(MobileCapabilityType.NO_RESET, true);
//		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.APP, "/Users/rezkydwiseptiyan/Downloads/OK-DEV-OFFLINE-040321_2.apk");
//		caps.setCapability("appPackage","id.ottopay.kasir.debug");
//		caps.setCapability("appActivity","id.ottopay.kasir.ui.activity.auth");
//		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//		caps.setCapability("appPackage","com.android.calculator2");
//		caps.setCapability("appActivity","com.android.calculator2.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
				
		driver = new AndroidDriver<MobileElement>(url,caps);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// Permission 
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		
		driver.findElementById("id.ottopay.kasir.debug:id/phoneEdit").click();
		driver.findElementById("id.ottopay.kasir.debug:id/phoneEdit").sendKeys("085342920295");
		
		
		driver.findElementById("id.ottopay.kasir.debug:id/pinEdit").click();
		driver.findElementById("id.ottopay.kasir.debug:id/pinEdit").sendKeys("112233");
		
		driver.findElementById("id.ottopay.kasir.debug:id/loginButton").click();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElementById("id.ottopay.kasir.debug:id/cbTac").click();
		driver.findElementById("id.ottopay.kasir.debug:id/btnTac").click();
		
		driver.findElementById("id.ottopay.kasir.debug:id/btnOk");
		
		
		driver.quit();
		
	}

}


