package net.rodor.testfuncooper.legajos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.rodor.testfuncooper.OPAccesoBase;

public class OPAltaLegajo extends OPLegajosBase {
	
	private static final String MSG_ALERT_SUCCESS = "alert-success";
	private static final String BOTON_ATRAS = "botonAtras";
	private static final String BOTON_ACEPTAR = "aceptar";
	private static final String NUMERO_REGISTRO = "numeroRegistro";
	private static final String NUMERO_INSCRIPCION = "numeroInscripcion";
	public static final String URL = "alta/legajoEditLoad.htm";
	
	public static void alta(WebDriver driver,VOLegajo vo) throws InterruptedException{
		
		driver.get(OPAccesoBase.URL_PRIV+OPLegajosBase.URL+URL);
		Thread.sleep(3000);
		
		WebElement elementoWeb = driver.findElement(By.id(NUMERO_INSCRIPCION));
		elementoWeb.sendKeys(vo.getNumeroInscripcion());
		
		
		elementoWeb = driver.findElement(By.id(NUMERO_REGISTRO));
		elementoWeb.sendKeys(vo.getNumeroRegistro());
		
		elementoWeb = driver.findElement(By.name(BOTON_ACEPTAR));
		elementoWeb.click();
		Thread.sleep(3000);

		// buscar mensaje de alta correcta
		driver.findElement(By.id(MSG_ALERT_SUCCESS));
		
		//volver.
		elementoWeb = driver.findElement(By.id(BOTON_ATRAS));
		elementoWeb.click();
		System.out.println("Alta de legajo correcta");
		
	}
}
