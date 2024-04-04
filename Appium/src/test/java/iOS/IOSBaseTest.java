package iOS;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {
	IOSDriver driver;
	AppiumDriverLocalService service;
	
	@BeforeClass
	public void config() throws MalformedURLException {
		service=new AppiumServiceBuilder().withAppiumJS(new File("")).withIPAddress("").usingPort(0).build();
	service.start();
	
	XCUITestOptions options=new XCUITestOptions();
	options.setDeviceName("AkshayMobile");
	options.setApp("C://automationTraining//Appium//src//test//java//resources//General-Store.apk");
	options.setPlatformVersion("15.5");
	options.setWdaLaunchTimeout(Duration.ofSeconds(20));
	
	driver=new IOSDriver(new URL("http://127.0.0.1:4723"),options);
	
	}

}
