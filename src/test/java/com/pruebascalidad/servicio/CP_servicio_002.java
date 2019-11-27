package com.pruebascalidad.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CP_servicio_002 {

	private WebDriver driver;
	By _idmenuservicio = By.id("menu-item-6142");
	
	@Before
	public void precondiciones() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/servicio/");
	}
	
	@Test
	public void testIngresoServicioTitulo() throws InterruptedException {
		
		String searchBox = driver.findElement(By.xpath("//a[@href='#capacidades']")).getAttribute("href");
		driver.get(searchBox);
		try {
			if(driver.findElement(By.xpath("//a[@href='#capacidades']")).isDisplayed()) {
				WebElement element = driver.findElement(By.className("elementor-element-8752f0a"));
				WebElement element2 = element.findElement(By.className("elementor-widget-container"));
				WebElement element3 = element.findElement(By.className("elementor-heading-title"));
				assertEquals("Capacidades de Pruebas Centradas en el negocio",element3.getText());
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

