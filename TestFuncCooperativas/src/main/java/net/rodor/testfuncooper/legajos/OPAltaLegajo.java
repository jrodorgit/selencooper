package net.rodor.testfuncooper.legajos;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.UtilWE;

public class OPAltaLegajo extends OPLegajosBase {
	
	private static final String TIPO_EXPEDIENTE_2 = "2";
	private static final String ID_TIPO_EXPEDIENTE = "idTipoExpediente";
	private static final String MSG_ALERT_SUCCESS = "alert-success";
	private static final String BOTON_ATRAS = "botonAtras";
	private static final String BOTON_ACEPTAR = "aceptar";
	private static final String NUMERO_REGISTRO = "numeroRegistro";
	private static final String NUMERO_INSCRIPCION = "numeroInscripcion";
	
	
	public static void alta(WebDriver driver,VOLegajo vo) throws InterruptedException{
		
		
		UtilDriver.goMenu(driver, OPLegajosBase.MENU,OPLegajosBase.SUB_MENU_ALTA);
		
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION, vo.getNumeroInscripcion());
		
		UtilWE.selectOption(UtilDriver.buscarById(driver, ID_TIPO_EXPEDIENTE, null, null),TIPO_EXPEDIENTE_2);
		
		UtilDriver.setCampoById(driver, NUMERO_REGISTRO, vo.getNumeroRegistro());
		
		UtilDriver.clickBoton(driver, null, BOTON_ACEPTAR);
		
		UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null);
		
		UtilDriver.clickBoton(driver, BOTON_ATRAS, null);
		
		
		System.out.println("Alta de legajo correcta.");
		
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
