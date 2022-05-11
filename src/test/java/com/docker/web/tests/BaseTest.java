package com.docker.web.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	WebDriver driver;
	DesiredCapabilities capabilities;
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browser) {
		browser = "chrome";
		capabilities = new DesiredCapabilities();
		System.out.println("Running browser is "+ browser);
		if (browser.equalsIgnoreCase("chrome")) {
			capabilities.setBrowserName("chrome");
		}
		if (browser.equalsIgnoreCase("chrome")) {
			capabilities.setBrowserName("firefox");
		}
		capabilities.setPlatform(Platform.LINUX);
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().setSize(new Dimension(1300,768));
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public static void wait(int waitTimeInSeconds) {
		try {
			Thread.sleep(waitTimeInSeconds*1000);
		}
		catch(Exception e) {
			
		}
		System.out.println("Waited for "+waitTimeInSeconds+ " seconds");
	}

}
