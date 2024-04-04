package rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends BaseTest {
	
	boolean canScrollMore ;
	@Test
	public void SwipeDemoTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		
		WebElement firstImage=driver.findElement(By.xpath("//android.widget.Gallery[@resource-id='io.appium.android.apis:id/gallery']/android.widget.ImageView[1]"));
		
		Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
		
		SwipeMethod(firstImage, "left", 0.1);
		Assert.assertEquals(firstImage.getAttribute("focusable"), "false");
		
	}

}
