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

public class eCommerce_tc_3 extends BaseTest {

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

		driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[1]"))
				.click();
		driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart'])[2]"))
				.click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		Thread.sleep(5000);
		
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum = 0;
		for (int i = 0; i < count; i++) {
			String amountString = productPrices.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price; // 160.97 + 120 =280.97

		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum = getFormattedAmount(displaySum);
		
		System.out.println("Total Price::"+totalSum);
		System.out.println("Displayed Price::"+displayFormattedSum);
		
		Thread.sleep(5000);
//		Assert.assertEquals(displayFormattedSum, totalSum);

	}

}
