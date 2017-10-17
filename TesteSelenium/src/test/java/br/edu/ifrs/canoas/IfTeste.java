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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class IfTeste {

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
		
		driver.get("http://www.canoas.ifrs.edu.br/site");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testValidAnchorLinks(){
		
		List<WebElement> links = getAllLinks(driver, "a");
		
		for (WebElement link : links){
			
			try {
			String msg = checkLink(new URL(link.getAttribute("href")));
			
			assertTrue(msg, !msg.toLowerCase().contains("not found"));
			
			} catch (MalformedURLException ex) {
				
				fail(ex.getMessage());
			}
		}
		
	}
	public List<WebElement> getAllLinks(WebDriver driver, String tag){
		
		List<WebElement> elementList = new ArrayList<WebElement>();
		
		elementList = driver.findElements(By.tagName(tag));
		for(int i = 0; i < elementList.size();i++){
			WebElement element = elementList.get(i);
			
			if(element.getAttribute("href") == null){
				
				elementList.remove(i);
				i--;
			}
			
		}
		
		return elementList;
	}
	
	public String checkLink(URL url){
		
		String response = "";
		
		try {
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.connect();
			response = connection.getResponseMessage();
			
			connection.disconnect();
		
		} catch (IOException ex) {
			Logger.getLogger(IfTeste.class.getName());
			
			response = ex.getMessage();
		}
		System.out.println(url + "" + response);
		return response;
	}
	
	
}
	