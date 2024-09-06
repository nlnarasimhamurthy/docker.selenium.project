package com.docker.web.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewDockerClass {
	
	@Test
	public void testChromeLauncher() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1265, 765));
		driver.get("https://my.ehrtutor.com");
		System.out.println(driver.getTitle());
		assertEquals("Login - EHR Tutor", driver.getTitle());
		driver.quit();
	}
	@Test
	public void testFirefoxLauncher() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1265, 765));
		driver.get("https://my.ehrtutor.com");
		System.out.println(driver.getTitle());
		assertEquals("Login - EHR Tutor", driver.getTitle());
		driver.quit();
	}
	@Test
	public void testEdgeLauncher() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().setSize(new Dimension(1265, 765));
		driver.get("https://my.ehrtutor.com");
		System.out.println(driver.getTitle());
		assertEquals("Login - EHR Tutor", driver.getTitle());
		driver.quit();
	}
}
