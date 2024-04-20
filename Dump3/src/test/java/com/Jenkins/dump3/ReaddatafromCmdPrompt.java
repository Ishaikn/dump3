package com.Jenkins.dump3;

import java.io.IOException;

import java.sql.SQLException;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class ReaddatafromCmdPrompt {

	public static WebDriver driver;

	@Test
	public void Readdata() throws IOException, SQLException, InterruptedException {

//		Properties Pobj = new Properties();
		// Pobj.setProperty("browser", "chrome");
		// Pobj.setProperty("url",
		// "http://rmgtestingserver/domain/Online_Banking_System/staff_login.php");
		// Pobj.setProperty("Staffid", "210001");
		// Pobj.setProperty("Password", "password");

		String Browser = System.getProperty("browser");
		String url = System.getProperty("url");
		String Login = System.getProperty("Staffid");
		String Pwd = System.getProperty("Password");

		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.name("staff_id")).sendKeys(Login);
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(Pwd);
		driver.findElement(By.xpath("//input[@class='login-btn']")).click();
	}

	@Test
	public void executedata() {
		System.out.println("Data Executed");

	}
}
