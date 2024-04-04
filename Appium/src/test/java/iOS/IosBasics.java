package iOS;

import java.nio.charset.MalformedInputException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.SliderUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class IosBasics extends IOSBaseTest {
	
	@Test
	public void WifiSettingName() throws MalformedInputException, Exception{
		
		driver.findElement(By.id("")).click();
		driver.findElement(AppiumBy.iOSClassChain("**//XCUIElementTypeStaticText[`@label=='Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("//**@tagname[`@nmae=''`]")).sendKeys("");
		driver.findElement(AppiumBy.iOSNsPredicateString("")).click();
		
		//scroll
		WebElement ele1= driver.findElement(AppiumBy.iOSClassChain("**//XCUIElementTypeButton[`label=='Text Entry'`]"));
		
		Map<String, Object> param=new HashMap<>();
		param.put("element", ((RemoteWebElement)ele1).getId());
		param.put("direction", "down");
		driver.executeScript("mobile:scroll", param);
		
		//long press
		WebElement ele= driver.findElement(AppiumBy.iOSClassChain("**//XCUIElementTypeButton[`label=='Text Entry'`]"));
		Map<String, Object> params=new HashMap<>();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration", 5);
		driver.executeScript("mobile:touchAndHold", param);
		
		//sliding
		driver.executeScript("mobile:touchAndHold", params);
		WebElement slider=driver.findElement(By.xpath(""));
		slider.sendKeys("0%");
		System.out.println(slider.getAttribute("value"));
		slider.sendKeys("1%");
		
		
		// Locate the element you want to scroll to
		WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name CONTAINS[c] 'WebView2'"));

		// Scroll to the element
		driver.executeScript("mobile:scroll", 
		    ImmutableMap.of("element", ((RemoteWebElement) element).getId(), "toVisible", true));
		
		
	}

}
