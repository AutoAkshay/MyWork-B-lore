package rahulshettyacademy;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_4 extends BaseTest {

	@Test
	public void FillForm() throws MalformedURLException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Akshay");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));

		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		

		int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i=0;i<productCount;i++) {
			String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				Thread.sleep(5000);
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPress(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		Thread.sleep(5000);
		
		

	}

}
