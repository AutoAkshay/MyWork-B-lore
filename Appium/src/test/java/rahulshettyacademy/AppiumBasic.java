package rahulshettyacademy;

import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.appium.java_client.AppiumBy;

public class AppiumBasic extends BaseTest {
	
	@Test
	public void WifiSettingName() throws MalformedInputException, Exception{
		
		//Actual Automation ==>> xPath , id, accebilityId , className, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@text='WiFi settings']")).click();
		String title=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(title, "WiFi settings");
		System.out.println(title);
		driver.findElement(By.id("android:id/edit")).sendKeys("Akshay");
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}
