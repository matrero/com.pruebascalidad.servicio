package com.pruebascalidad.servicio;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP_servicio_016 {

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
		
		String searchBox = driver.findElement(By.xpath("//a[@href='#transaccion']")).getAttribute("href");
		driver.get(searchBox);
		try {
			if(driver.findElement(By.xpath("//a[@href='#transaccion']")).isDisplayed()) {
				WebElement element = driver.findElement(By.className("elementor-element-c4c1f55"));
				WebElement element2 = element.findElement(By.className("elementor-widget-container"));
				WebElement element3 = element.findElement(By.cssSelector("div.elementor-text-editor >p:nth-child(1)"));
				assertEquals("Automatización de Pruebas para Switches transaccionales",element3.getText());
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
