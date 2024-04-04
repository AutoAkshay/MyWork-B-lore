package rahulshettyacademy;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class BaseTest {

//	AppiumDriverLocalService service;
	AndroidDriver driver;

	@BeforeClass
	public void configuration() throws MalformedURLException {
//		service= new AppiumServiceBuilder().withAppiumJS(new File("C://Users//akshayak//AppData//Roaming//npm//node_modules//appium//lib//main.js"))
//				.withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("AkshayMobile");
		options.setApp("C://automationTraining//Appium//src//test//java//resources//ApiDemos-debug.apk");
//		options.setApp("C://automationTraining//Appium//src//test//java//resources//General-Store.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//		driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
	}

	public void scrollMethod() {

		// Use when to know scroll and select
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView2\"));"));
	/*
	 
		//for iOS
		MobileElement element = (MobileElement) driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND name CONTAINS[c] 'WebView2'"));

		// Scroll to the element
		driver.executeScript("mobile:scroll", 
		    ImmutableMap.of("element", element.getId(), "toVisible", true));
		    
		    */
	}

	public void LongPress(WebElement ele) {
		
//		JavascriptExecutor js=(JavascriptExecutor) driver;
		Map< String, Object> param=new HashMap<>();
		param.put("elementId", ((RemoteWebElement)ele).getId());
		param.put("duration", 2000);
//		(js).executeScript("mobile: longClickGesture",param);
		driver.executeScript("mobile: longClickGesture",param);
		driver.executeScript("mobile: touchAndHold",param);
		 
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
//				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void SwipeMethod(WebElement ele, String direction , double swipePercentage) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(

				"elementId", ((RemoteWebElement) ele).getId(), "direction", direction, "percent", swipePercentage));

	}
	
	public void DragDrop(WebElement cordinator){
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)cordinator).getId(),
			    "endX", 434,
			    "endY", 365
			));
		
	}
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
	}

//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//		service.stop();
//	}

}
