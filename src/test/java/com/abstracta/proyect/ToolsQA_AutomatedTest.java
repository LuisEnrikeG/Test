package com.abstracta.proyect;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ToolsQA_AutomatedTest {
	
	public WebDriver driver; 
	By FormLocator = By.className("card-up");
	By TextboxLocator = By.className("text");
	By TextPageLocator = By.xpath("//img[@src='/images/Toolsqa.jpg']");
	By UserNameLocator = By.id("userName");
	By EmailLocator = By.id("userEmail");
	By CurrentAddressLocator = By.id("currentAddress");
	By PermanentAddressLocator = By.id("permanentAddress");
	By SubmitLocator = By.id("submit");
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
	}
	
	@Test
	
	//Ingreso al formulario
	
	public void ElementsTexBox() throws InterruptedException {
		
		Scroll(driver, 4);
		Thread.sleep(3000);
		driver.findElement(FormLocator).click();
		driver.findElement(TextboxLocator).click();

		if (driver.findElement(TextPageLocator).isDisplayed()) {
			
	//Ingreso datos del formulario
		
		driver.findElement(UserNameLocator).sendKeys("Luis Enrique Gonzalez");
		driver.findElement(EmailLocator).sendKeys("prueba@test.cl");
		driver.findElement(CurrentAddressLocator).sendKeys("Santiago");
		Scroll(driver, 4);
		driver.findElement(PermanentAddressLocator).sendKeys("Chile");	
		Thread.sleep(3000);
		driver.findElement(SubmitLocator).click();
			
	//Imprime resultados
		
		String Salida = (driver.findElement(By.id("output"))).getText();
		System.out.println(Salida);
			
		}
	
	}
	
	@After
	
	//Close window
	
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
	//Scroll Page
	public void Scroll(WebDriver driver, int cant){
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0," + String.valueOf(cant * 55) + ")", "");
		
	}
		

}
