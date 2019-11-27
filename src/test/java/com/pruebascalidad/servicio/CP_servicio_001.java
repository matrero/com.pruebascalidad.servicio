package com.pruebascalidad.servicio;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP_servicio_001 {
	
	private WebDriver driver;
	//private String _idmenuservicio="menu-item-6142" ;
	By _idmenuservicio = By.id("menu-item-6142");
	
	@Before
	public void precondiciones() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/");
	}
	
	@Test
	public void test() throws InterruptedException {
		
		WebElement searchBox = driver.findElement(_idmenuservicio);
		searchBox.click();
		Thread.sleep(2000);
		assertEquals("Servicios – Choucair Testing",driver.getTitle());
		driver.quit();
	}
	public void testIngresoServicioUrl() throws InterruptedException {
		WebElement searchBox = driver.findElement(_idmenuservicio);
		searchBox.click();
		Thread.sleep(2000);
		
		assertEquals("https://www.choucairtesting.com/servicio/",driver.getCurrentUrl());
		driver.quit();
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
