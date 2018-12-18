package net.rodor.testfuncooper;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilDriver {
	

	public static void goURL(WebDriver driver, String url) throws InterruptedException{
		driver.get(url);
		Thread.sleep(3000);
	}
	
	public static void setCampoById(WebDriver driver, String id, String valor) throws InterruptedException{
		driver.findElement(By.id(id)).sendKeys(valor);
		Thread.sleep(200);
	}
	
	public static void clickByName(WebDriver driver, String name) throws InterruptedException{
		driver.findElement(By.name(name)).click();
		Thread.sleep(3000);
	}
	
	public static WebElement buscarById(WebDriver driver, String id) throws InterruptedException{
		return driver.findElement(By.id(id));
	}
	
	public static void clickBoton(WebDriver driver,String id,  String name ) throws InterruptedException{
		
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
	
	/***
	 * //List<WebElement> msgOK = driver.findElements(By.id(ALERT_SUCCESS));
		//for(WebElement we : msgOK){
		//	System.out.println(we.getText());
		//}
	 */
}


