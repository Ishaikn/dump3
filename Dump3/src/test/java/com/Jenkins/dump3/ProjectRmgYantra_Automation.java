package com.Jenkins.dump3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class ProjectRmgYantra_Automation {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException, SQLException {

		Random ran = new Random();
		int random = ran.nextInt(500);

		String Expectedata = "EDBBank" + random;

		Properties Pobj = new Properties();
		Pobj.setProperty("browser", "chrome");
		Pobj.setProperty("url", "http://rmgtestingserver:8084/");
		Pobj.setProperty("Project", "EDBBank");
		Pobj.setProperty("Manager", "Irshad");

		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\Readata.properties");
		Pobj.store(fout, "data");
		String Browser = Pobj.getProperty("browser");
		String url = Pobj.getProperty("url");
		String ProjectName = Pobj.getProperty("Project");
		String ProjectManager = Pobj.getProperty("Manager");

		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		driver.findElement(By.xpath("//a[text()='Projects']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));

		driver.findElement(By.xpath("//span[text()='Create Project']")).click();

		driver.findElement(By.name("projectName")).sendKeys(Expectedata);
		driver.findElement(By.name("createdBy")).sendKeys(ProjectManager);

		WebElement options = driver.findElement(By.name("status"));
		Select sel = new Select(options);
		sel.selectByVisibleText("Created");

		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		Connection connnection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%",
				"root");

		Statement state = connnection.createStatement();
		String query = "select * from project where lower(project_name)='" + Expectedata + "';";

		ResultSet res = state.executeQuery(query);
		System.out.println(res.getMetaData());
		while (res.next()) {
			String actual = res.getString(4);
			if (actual.equals(Expectedata)) {
				System.out.println("Data is Present");

			} else {
				System.out.println("data is not present");
			}
		}
		connnection.close();
	}
}
