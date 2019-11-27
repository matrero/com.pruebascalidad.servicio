package com.pruebascalidad.servicio;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP_servicio_006 {
	private WebDriver driver;
	
	@Before
	public void precondiciones() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/servicio/");
	}
	
	@Test
	public void testIngresoServicioTitulo() throws InterruptedException {
		
		String searchBox = driver.findElement(By.xpath("//a[@href='#moviles']")).getAttribute("href");
		driver.get(searchBox);
		try {
			if(driver.findElement(By.xpath("//a[@href='#moviles']")).isDisplayed()) {
				WebElement element = driver.findElement(By.className("elementor-element-95b0b27"));
				WebElement element2 = element.findElement(By.className("elementor-widget-container"));
				WebElement element3 = element.findElement(By.cssSelector("div.elementor-text-editor >p:nth-child(1)"));
				assertEquals("Pruebas para aplicativos móviles",element3.getText());
			}	
		}
		catch(Exception e ){
			System.out.println("No se encuentra ");
		}
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
