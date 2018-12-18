package net.rodor.testfuncooper.asientos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.rodor.testfuncooper.UtilDriver;

public class OPAltaAsiento extends OPAsientosBase {

	private static final String BOTON_VOLVER = " Volver";
	public static final String URL = "asientoEditLoad.htm";
	private static final String NUMERO_TOMO = "tomo";
	private static final String NUMERO_FOLIO = "folio";
	private static final String NUMERO_INSCRIPCION = "numeroInscripcion";
	private static final String NUMERO_ASIENTO = "numeroAsiento";
	private static final String ASIENTO = "asiento";
	private static final String NOTA_MARGINAL = "notaMarginal";
	private static final String DATA_ID_PROCEDIMIENTO = "subtipoTramite";
	private static final String FECHA_ASIENTO = "fecha";
	
//	private static final String MSG_ALERT_SUCCESS = "alert-success";
	private static final String MSG_ALERT_ERROR = "alert-danger-global";
	//private static final String BOTON_ATRAS = "botonAtras";
	private static final String BOTON_ACEPTAR = "aceptar";
	
	/**
	 * Da de alta un asiento para una cooperativa.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void alta(WebDriver driver,VOAsiento vo) throws InterruptedException{
		
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_ALTA);
		
		UtilDriver.setCampoById(driver, NUMERO_TOMO,vo.getTomo());
		UtilDriver.setCampoById(driver, NUMERO_FOLIO,vo.getFolio());
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION,vo.getNumeroInscripcionCooper());
		UtilDriver.setCampoById(driver, NUMERO_ASIENTO,vo.getNumeroAsiento());
		UtilDriver.setCampoById(driver, ASIENTO,vo.getAsiento());
		UtilDriver.setCampoById(driver, NOTA_MARGINAL,vo.getNotaMarginal());
		
		// SELECCION DE PROCEDIMIENTO
		UtilDriver.clickSeleccionCombo(driver, vo.getProcedimiento(),DATA_ID_PROCEDIMIENTO,"form-group form-group-sm");
		
		// seleccion de checkbox
		WebElement elementoWebDivChecks = driver.findElement(By.className("checkbox-meyss"));
		elementoWebDivChecks.findElement(By.xpath("//span[@class='separatorCheckboxLabel'  and contains(., 'Inscripci')]")).click();
		Thread.sleep(2000);

		UtilDriver.setCampoById(driver, FECHA_ASIENTO,vo.getFecha());
		
		UtilDriver.clickBoton(driver, null, BOTON_ACEPTAR);

		// buscar mensaje de alta correcta
		UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS);
		
		//volver.
		UtilDriver.clickBoton(driver, null, null,BOTON_VOLVER);
		
		System.out.println("Alta de asiento correcta");
		
	}


	
	/**
	 * Alta de asiento. Como tiene error el mensaje a comprobar es de error.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void altaConError(WebDriver driver,VOAsiento vo) throws InterruptedException{
		
		//driver.get(OPAccesoBase.URL_PRIV+OPAsientosBase.URL+URL);
		//Thread.sleep(2000);
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_ALTA);
		
		WebElement elementoWeb = driver.findElement(By.id(NUMERO_TOMO));
		elementoWeb.sendKeys(vo.getTomo());
		
		elementoWeb = driver.findElement(By.id(NUMERO_FOLIO));
		elementoWeb.sendKeys(vo.getFolio());
		
		elementoWeb = driver.findElement(By.id(NUMERO_INSCRIPCION));
		elementoWeb.sendKeys(vo.getNumeroInscripcionCooper());
		
		
		elementoWeb = driver.findElement(By.id(NUMERO_ASIENTO));
		elementoWeb.sendKeys(vo.getNumeroAsiento());
		
		elementoWeb = driver.findElement(By.id(ASIENTO));
		elementoWeb.sendKeys(vo.getAsiento());
		
		elementoWeb = driver.findElement(By.id(NOTA_MARGINAL));
		elementoWeb.sendKeys(vo.getNotaMarginal());
		
		// SELECCION DE PROCEDIMEITNO
		// selecion de div de procedimiento
		WebElement elementoWebDivProc = driver.findElement(By.xpath("//div[@class='form-group form-group-sm']"));
		elementoWebDivProc.findElement(By.xpath("//button[@data-id='subtipoTramite']")).click();
		Thread.sleep(2000);
		elementoWebDivProc.findElement(By.xpath("//a[@data-normalized-text='"+vo.getProcedimiento()+"']")).click();
		Thread.sleep(2000);
		
		WebElement elementoWebDivChecks = driver.findElement(By.className("checkbox-meyss"));
		elementoWebDivChecks.findElement(By.xpath("//span[@class='separatorCheckboxLabel'  and contains(., 'Inscripci')]")).click();
		Thread.sleep(2000);
		//elementoWebDivChecks.findElement(By.id("claseAsientoI")).click();
		//driver.findElement(By.id("claseAsientoI")).
		
		elementoWeb = driver.findElement(By.id(FECHA_ASIENTO));
		elementoWeb.sendKeys(vo.getFecha());
		
		elementoWeb = driver.findElement(By.name(BOTON_ACEPTAR));
		elementoWeb.click();
		Thread.sleep(3000);

		// buscar mensaje de alta correcta
		driver.findElement(By.id(MSG_ALERT_ERROR));
		Thread.sleep(3000);
		
		System.out.println("Alta de asiento correcta");
		
	}
	
	
}
