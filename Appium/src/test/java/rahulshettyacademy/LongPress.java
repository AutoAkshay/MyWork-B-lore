package rahulshettyacademy;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {
	
	@Test
	public void LongGesture() throws MalformedURLException{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		LongPress(ele);
		
		String menuBar=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']")).getText();
		Assert.assertEquals(menuBar, "Sample menu");
		System.out.println("menu bar::"+menuBar);
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Sample menu']")).isDisplayed());
		
	}
	

}
