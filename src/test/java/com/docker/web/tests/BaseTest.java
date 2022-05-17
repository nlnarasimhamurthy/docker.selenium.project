package com.docker.web.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	DesiredCapabilities capabilities;
	@Parameters({"browser", "gridExe"})
	@BeforeClass
	public void beforeClass(String browser, String gridExe) {
		//String browser = "chrome";
		System.out.println("--------------------"+browser+"----------------------");
		capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.LINUX);
		if (gridExe.equalsIgnoreCase("Yes")) {
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
		}
		if (gridExe.equalsIgnoreCase("") || gridExe.equalsIgnoreCase("No")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			driver = new ChromeDriver(chromeOptions);
		}
		System.out.println("Test running with browser "+ browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().setSize(new Dimension(1300,760));
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
