package com.docker.web.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	DesiredCapabilities capabilities;
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browser) {
		//String browser = "chrome";
		System.out.println("--------------------"+browser+"----------------------");
		capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.LINUX);
		if (browser.equalsIgnoreCase("chrome")) {
			capabilities.setBrowserName("chrome");
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4441/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		if (browser.equalsIgnoreCase("firefox")) {
			capabilities.setBrowserName("firefox");
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4442/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Test running with browser "+ browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().setSize(new Dimension(1300,768));
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public static void wait(int waitTimeInSeconds) {
		try {
			//Thread.sleep(waitTimeInSeconds*1000);
		}
		catch(Exception e) {
			
		}
		System.out.println("Waited for "+waitTimeInSeconds+ " seconds");
	}

}
