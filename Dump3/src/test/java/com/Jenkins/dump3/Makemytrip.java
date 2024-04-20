package com.Jenkins.dump3;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Makemytrip {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

//		String Monthdate = "April 2024";
//		int date = 30;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

		driver.get(
				"https://www.makemytrip.com/flights/?cmp=SEM|M|DF|B|Brand|B_M_Makemytrip_Search_Exact|Brand_Top_5_Exact|Expanded|&s_kwcid=AL!1631!3!!e!!o!!`makemytrip&ef_id=:G:s");
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		Thread.sleep(3000);
		WebElement Search = driver.findElement(By.id("fromCity"));
		Search.click();
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.sendKeys("Del").perform();
		List<WebElement> Cities = driver.findElements(By.xpath("//li[@role='option']"));
		for (WebElement from : Cities) {
			if (from.getText().contains("New")) {
				from.click();
				break;
			}
		}
		WebElement Cityto = driver.findElement(By.xpath("//input[@id='toCity']"));
		Cityto.click();
		action.sendKeys("Tirup").perform();
		List<WebElement> ToCity = driver.findElements(By.xpath("//li[@role='option']"));
		for (WebElement to : ToCity) {
			if (to.getText().contains("pati")) {
				to.click();
				break;
			}
		}
	}

}
