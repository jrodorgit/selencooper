package net.rodor.testfuncooper.legajos;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPAccesoBase;
import net.rodor.testfuncooper.UtilDriver;

public class OPAltaLegajo extends OPLegajosBase {
	
	private static final String MSG_ALERT_SUCCESS = "alert-success";
	private static final String BOTON_ATRAS = "botonAtras";
	private static final String BOTON_ACEPTAR = "aceptar";
	private static final String NUMERO_REGISTRO = "numeroRegistro";
	private static final String NUMERO_INSCRIPCION = "numeroInscripcion";
	public static final String URL = "alta/legajoEditLoad.htm";
	
	public static void alta(WebDriver driver,VOLegajo vo) throws InterruptedException{
		
		UtilDriver.goURL(driver, OPAccesoBase.URL_PRIV+OPLegajosBase.URL+URL);
		
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION, vo.getNumeroInscripcion());
		
		UtilDriver.setCampoById(driver, NUMERO_REGISTRO, vo.getNumeroRegistro());
		
		UtilDriver.clickBoton(driver, null, BOTON_ACEPTAR);
		
		UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS);
		
		UtilDriver.clickBoton(driver, BOTON_ATRAS, null);
		
		
		System.out.println("Alta de legajo correcta!");
		
	}
	/**
	 * 		//driver.get(OPAccesoBase.URL_PRIV+OPLegajosBase.URL+URL);
		//Thread.sleep(3000);
		UtilDriver.goURL(driver, OPAccesoBase.URL_PRIV+OPLegajosBase.URL+URL);
		
		//WebElement elementoWeb = driver.findElement(By.id(NUMERO_INSCRIPCION));
		//elementoWeb.sendKeys(vo.getNumeroInscripcion());
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION, vo.getNumeroInscripcion());
		
		//WebElement elementoWeb = driver.findElement(By.id(NUMERO_REGISTRO));
		//elementoWeb.sendKeys(vo.getNumeroRegistro());
		UtilDriver.setCampoById(driver, NUMERO_REGISTRO, vo.getNumeroRegistro());
		
		//WebElement elementoWeb = driver.findElement(By.name(BOTON_ACEPTAR));
		//elementoWeb.click();
		//Thread.sleep(3000);
		//UtilDriver.clickByName(driver, BOTON_ACEPTAR);
		UtilDriver.clickBoton(driver, null, BOTON_ACEPTAR);
		
		// buscar mensaje de alta correcta
		//driver.findElement(By.id(MSG_ALERT_SUCCESS));
		UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS);
		
		//volver.
		//WebElement elementoWeb = driver.findElement(By.id(BOTON_ATRAS));
		//elementoWeb.click();
		UtilDriver.clickBoton(driver, BOTON_ATRAS, null);
		
		
		System.out.println("Alta de legajo correcta");
	 */
}
