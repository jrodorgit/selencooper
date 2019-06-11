package net.rodor.testfuncooper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OPAccesoChrome extends OPAccesoBase {

	
	
	public static WebDriver autenticacion(String entorno) throws InterruptedException, AWTException {
		
		System.out.println("Test en entorno: " +entorno);
		
		
		// driver navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// url cooperativas
		driver.get(entorno);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		WebElement searchBox = driver.findElement(By.id("botonEntrarCertificado"));
		searchBox.click();
		Thread.sleep(5000);
				
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		return driver;
	}
	public static WebDriver accesoPublico(String entorno) throws InterruptedException, AWTException {
		
		System.out.println("Test en entorno: " +entorno);
		
		
		// driver navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// url cooperativas
		driver.get(entorno);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		
		return driver;
	}
	public static void autenticacionPublica(WebDriver driver) throws InterruptedException, AWTException {
	
	WebElement searchBox = driver.findElement(By.id("botonEntrarCertificado"));
	searchBox.click();
	Thread.sleep(5000);
			
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_TAB);
	robot.delay(1000);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.delay(1000);
	robot.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(4000);
	robot.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(4000);
	robot.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(3000);
		
	}
	public static void firmarConCertificado(WebDriver driver) throws InterruptedException, AWTException {
		
		
				
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
			
		}
	
}
