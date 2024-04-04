package rahulshettyacademy;

import java.net.MalformedURLException;
import java.time.Duration;
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

public class eCommerce_tc_2 extends BaseTest {

	@Test
	public void FillForm() throws MalformedURLException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

//		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Akshay");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));

		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

		driver.findElement(By.className("android.widget.Button")).click();		

		String msg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		System.out.println("Message::" + msg);
		Assert.assertEquals(msg, "Please enter your name");

	}

}
