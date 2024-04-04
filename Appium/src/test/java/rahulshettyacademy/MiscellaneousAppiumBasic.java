package rahulshettyacademy;

import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneousAppiumBasic extends BaseTest {
	
	@Test
	public void WifiSettingName() throws MalformedInputException, Exception{
		
		//Actual Automation ==>> xPath , id, accebilityId , className, androidUIAutomator
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", 
				ImmutableMap.of("intent"," io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		
		
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
//		DeviceRotation landscape=new DeviceRotation(0, 0, 90);
//		driver.rotate(landscape);
		
		
		Thread.sleep(3000);
		driver.findElement(AppiumBy.xpath("//*[@text='WiFi settings']")).click();
		String title=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(title, "WiFi settings");
		System.out.println(title);
		
		driver.setClipboardText("Akshay");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
//		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}

}
