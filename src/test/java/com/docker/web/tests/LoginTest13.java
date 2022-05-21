package com.docker.web.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v99.browser.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest13 extends BaseTest {

	@Test(priority=1)
	public void testLogin() {
		System.out.println("Running Thread ----- "+Thread.currentThread().getId());
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		wait(1);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		wait(1);
		driver.findElement(By.id("btnLogin")).click();
	}
	
	
	@Test(priority=2)
	public void testLogout() {
		System.out.println("Running Thread ----- "+Thread.currentThread().getId());
		driver.findElement(By.id("welcome")).click();
		wait(15);
		driver.findElement(By.linkText("Logout")).click();
	}
}
