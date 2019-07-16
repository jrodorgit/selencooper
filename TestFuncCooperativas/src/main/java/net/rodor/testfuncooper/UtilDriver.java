package net.rodor.testfuncooper;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UtilDriver {
	

	public static void goURL(WebDriver driver, String url) throws InterruptedException{
		driver.get(url);
		Thread.sleep(3000);
	}
	
	public static void setCampoById(WebDriver driver, String id, String valor) throws InterruptedException{
		//driver.findElement(By.id(id)).clear();
		driver.findElement(By.id(id)).sendKeys(valor);
		Thread.sleep(100);
	}
	public static void cleanAndSetCampoById(WebDriver driver, String id, String valor) throws InterruptedException{
		driver.findElement(By.id(id)).clear();
		driver.findElement(By.id(id)).sendKeys(valor);
		Thread.sleep(100);
	}
	public static void clearCampoById(WebDriver driver, String id) throws InterruptedException{
		driver.findElement(By.id(id)).clear();
		
		Thread.sleep(100);
	}
	public static void clickCheckBox(WebDriver driver, String tipo, String texto) throws InterruptedException{
		WebElement weInput = null;
		List<WebElement> weDivs = null;
		WebElement weDiv = null;
		weDivs = driver.findElements(By.xpath("//div[@class='"+tipo+"']"));
		// cogemos el div que tiene el input que queremos.
		for(int i = 0; i< weDivs.size(); i++ ){
			weDiv = weDivs.get(i);
			break;
			//System.out.println(" --->"+weDiv.toString());
			/***
			weInput = weDiv.findElement(By.xpath("//input[@value='"+texto+"']"));
			
			System.out.println(" value es:"+weInput.getAttribute("value"));
			
			if( weInput != null){
				weDiv =  weDivs.get(i);
				break;
			}
			**/
			
		}
		weDiv.click();
		
		Thread.sleep(100);
	}
	
	public static void clickByName(WebDriver driver, String name) throws InterruptedException{
		driver.findElement(By.name(name)).click();
		Thread.sleep(3000);
	}
	public static void clickById(WebDriver driver, String id) throws InterruptedException{
		driver.findElement(By.id(id)).click();
		Thread.sleep(3000);
	}
	public static void clickByClassName(WebDriver driver, String className) throws InterruptedException{
		try{
			driver.findElement(By.className(className)).click();
			Thread.sleep(3000);
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		try{
			driver.findElement(By.xpath(".//*[@class='"+className+"']")).click();
			Thread.sleep(3000);
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
	}
	public static void clickByText(WebDriver driver, String text) throws InterruptedException{
		
		try{
			driver.findElement(By.xpath(".//*[text()='"+ text + "']")).click();
			Thread.sleep(3000);
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
	}
	
	public static WebElement buscarById(WebDriver driver, String id, String name, String className) throws InterruptedException{
		WebElement we = null;
		
		try{
			we = driver.findElement(By.id(id));
			Thread.sleep(500);
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		try{
			we = driver.findElement(By.name(name));
			Thread.sleep(500);
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		try{
			we = driver.findElement(By.className(className));
			Thread.sleep(500);
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		return we;
		//return driver.findElement(By.id(id));
	}
	
	public static void clickBoton(WebDriver driver,String id,  String name , String... texto ) throws InterruptedException{
		
		WebElement we = null;
		
		try{
			we = driver.findElement(By.id(id));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
		try{
			we = driver.findElement(By.name(name));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
		try{
			we = driver.findElement(By.xpath("//button[text()='"+texto[0]+"']"));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			e.printStackTrace();
		}
		try{
			we = driver.findElement(By.xpath("//button[@class='"+texto[0]+"']"));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		try{
			we = driver.findElement(By.xpath("//button[contains(.,'"+texto[0]+"')]"));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
	}
	
	public static void clickSeleccionCombo(WebDriver driver, String seleccion, String nombreCombo, String divNombre) throws InterruptedException {
		WebElement elementoWebDivProc = driver.findElement(By.xpath("//div[@class='"+divNombre+"']"));
		elementoWebDivProc.findElement(By.xpath("//button[@data-id='"+nombreCombo+"']")).click();
		Thread.sleep(3000);
		elementoWebDivProc.findElement(By.xpath("//a[@data-normalized-text='"+seleccion+"']")).click();
		Thread.sleep(2000);
	}
	public static void clickSeleccionCombo(WebDriver driver, String seleccion, String id) throws InterruptedException {
		WebElement elementoCombo = driver.findElement(By.id(id));
		elementoCombo.findElement(By.xpath("//option[@value='"+seleccion+"']")).click();
		
		Thread.sleep(2000);
	}
	public static void clickByTextoClassBoton(WebDriver driver,String texto, String classButton){
		WebElement we = null;
		
		try{
			we = driver.findElement(By.xpath("//button[@class='"+classButton+"' and contains(., '"+texto+"')]"));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
	}
	public static void clickByTextoBoton(WebDriver driver,String texto, String typeButton){
		//driver.findElement(By.xpath("//button[@type='submit' and contains(., '"+BOTON_DOCUMENTO+"')]")).click();
		WebElement we = null;
		
		try{
			we = driver.findElement(By.xpath("//button[@type='"+typeButton+"' and contains(., '"+texto+"')]"));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		try{
			we = driver.findElement(By.xpath("//button[text()='"+ texto + "']"));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
	}
	
	/**
	 * Intenta hacer click en enlace anchor que CONTIENE atributo atr cuyo valor contiene "valor"
	 * @param driver
	 * @param atr
	 * @param valor
	 */
	public static void clickAnchor(WebDriver driver,String atr, String valor){
		WebElement we = null;
		try{
			we = driver.findElement(By.xpath(".//a[contains(@"+atr+",'"+valor+"')]"));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
	}
	
	public static void clickAnchorByText(WebDriver driver,String texto){
		WebElement we = null;
		try{
			we = driver.findElement(By.xpath(".//a[contains(.,'"+texto+"')]"));
			we.click();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
	}
	

	public static void passByText(WebDriver driver,String texto){
		WebElement we = null;
		try{
			Actions action = new Actions(driver);
			we = driver.findElement(By.xpath(".//a[contains(.,'"+texto+"')]"));
			action.moveToElement(we).build().perform();
			Thread.sleep(3000);
			return;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
	}

	public static void goMenu(WebDriver driver,String menu, String submenu){
		
		clickAnchorByText(driver,menu);
		if(submenu != null && !"".equalsIgnoreCase(submenu)){
			clickAnchorByText(driver,submenu);
			
		}
		
	}
	
	public static void goMenuBis(WebDriver driver,String menu, String submenu,String... subsubmenu ){
		
		clickAnchorByText(driver,menu);
		if(submenu != null && !"".equalsIgnoreCase(submenu)){
			passByText(driver,submenu);
			if(subsubmenu[0] != null && !"".equalsIgnoreCase(subsubmenu[0])){
				clickAnchorByText(driver,subsubmenu[0]);
				
			}
		}
		
	}
	
	
	/**
	 * Busca un tabla por su id y busca entre sus filas un registro que contiene el texto reg.
	 * @param driver
	 * @param idTabla
	 * @param reg
	 * @return true si la tabla contiene el registro, false en otro caso
	 */
	public static boolean exiteRegistroEnTabla(WebDriver driver, String idTabla, String reg){
		boolean resultado = false;
		
		try{
			driver.findElement(By.xpath(".//*[@id='"+idTabla+"']//td[contains(.,'"+reg+"')]"));
			resultado = true;
		}catch(Exception e){
			//elemento no encontrado
			//e.printStackTrace();
		}
		
		
		return resultado;
	}
	
	public static WebElement buscarTexto(WebDriver driver, String tagName, String texto) throws InterruptedException{
		WebElement we = null;
		
		try{
			we =  driver.findElement(By.xpath(".//"+tagName+"[contains(.,'"+texto+"')]"));
		}catch(Exception e){
			//elemento no encontrado
		}
		
		return we;
	}
	
}


