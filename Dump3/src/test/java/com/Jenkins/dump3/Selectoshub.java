package com.Jenkins.dump3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v120.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;

public class Selectoshub {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String date = "Hello";
		
//		JavascriptExecutor jss = (JavascriptExecutor) driver;
//		jss.executeScript("window.scrollBy(0,1400)");
		WebElement shadowroots = driver.findElement(By.xpath("//div[@id='userName']"));
		SearchContext shadow = shadowroots.getShadowRoot();
		shadow.findElement(By.id("kils")).sendKeys(date);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//		WebElement shadowroots1 = shadow.findElement(By.cssSelector("//div[@id='app2']"));
//		SearchContext shadow1 = shadowroots1.getShadowRoot();
//		shadow1.findElement(By.id("pizza")).sendKeys("ihihih");
		Actions action=new Actions(driver);
		action.sendKeys(Keys.TAB).sendKeys("hello").perform();
		action.sendKeys(Keys.TAB).sendKeys("hi").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("pass").build().perform();
		
	}
}
//WebElement shadowRoot = (WebElement) jsExecutor.executeScript("return document.querySelector('your-shadow-root-selector').shadowRoot;");
//WebElement shadowElement = (WebElement) jsExecutor.executeScript("return arguments[0].querySelector('your-shadow-element-selector');", shadowRoot);
