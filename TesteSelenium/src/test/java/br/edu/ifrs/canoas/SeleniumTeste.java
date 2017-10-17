package br.edu.ifrs.canoas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTeste {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpClass() {
		System.setProperty("webdriver.chrome.driver" ,  ".\\chromedriver.exe");
	}
	
	@AfterClass
	public static void tearDownClass(){
		driver.quit();
		
	}
	
	@Before
	public void setUp(){
		
		driver = new ChromeDriver();
		driver.get("http://www.seleniumhq.org/");
	}
	
	@Test
	public void checkPageTitle(){
		
		String expected = "Selenium - Web Browser Automation";
		String actual = driver.getTitle();
		
		assertThat(expected).as(actual);
	}
	
	@Test
	public void  findAndClickOnElement(){
		
		WebElement downloadLink = driver.findElement(By.linkText("Download Selenium"));
		String expected = "Download Selenium";
		
		assertEquals (expected, downloadLink.getText());
		downloadLink.click();
		
	}

}