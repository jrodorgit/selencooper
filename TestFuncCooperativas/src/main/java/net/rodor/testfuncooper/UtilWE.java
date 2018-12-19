package net.rodor.testfuncooper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UtilWE {

	public static void clickByClassName(WebElement we, String className) throws InterruptedException{
		we.findElement(By.className(className)).click();
		Thread.sleep(3000);
	}
	
	public static void clickAnchor(WebElement weorigen,String atr, String valor){
		WebElement we = null;
		try{
			we = weorigen.findElement(By.xpath(".//a[contains(@"+atr+",'"+valor+"')]"));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
	}
}
