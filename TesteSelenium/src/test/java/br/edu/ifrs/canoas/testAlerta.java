package br.edu.ifrs.canoas;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class testAlerta {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass() {
		System.setProperty("webdriver.chrome.driver" ,  ".\\chromedriver.exe");
	}
	
	@AfterClass
	public static void tearDownClass() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Before
	public void setUp(){
		
		driver = new ChromeDriver();
		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testSimpleAlert(){
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]/button"));
		element.click();
		
		Alert simpleAlert = driver.switchTo().alert();
		assertEquals ("A simple Alert", simpleAlert.getText());
		simpleAlert.accept();
	}
	
	@Test
	public void testSimplePrompt(){
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/p[11]/button"));
		element.findElement(ByName("Cancel"));
		
		Alert promptAlert = driver.switchTo().alert();
		assertEquals ("Do you like toolsqa?", promptAlert.getText());
		promptAlert.accept();
		
	}

	private By ByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private By ById(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}