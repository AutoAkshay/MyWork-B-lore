package rahulshettyacademy;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {
	
	boolean canScrollMore ;
	@Test
	public void ScrollDemoTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		scrollMethod();
		
		/*
		 
		 This method is used when just scrolling operation is required
		do{
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));}
		
		while(canScrollMore);
		
		*/
		
		driver.findElement(AppiumBy.accessibilityId("WebView2")).click();
	}

}
