package net.rodor.testfuncooper.asientos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.rodor.testfuncooper.OPAccesoBase;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.legajos.OPLegajosBase;

public class OPListadoAsiento  extends OPAsientosBase {
	
	public static final String URL = "asientoSearchLoad.htm";
	private static final String NUMERO_INSCRIPCION = "numeroInscripcion";
	private static final String NUMERO_ASIENTO = "numeroAsiento";
	private static final String BOTON_BUSCAR = "buscar";
	private static final String TABLA_ASIENTOS = "tablaAsientoSearch";
	private static final String BOTON_OK = "botonOK";
	
	/**
	 * busca un asiento de cooperativa por numero asiento y lo consulta
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void consultarAsiento(WebDriver driver,VOAsiento vo) throws InterruptedException{
		/***
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		//WebElement elementoWeb = driver.findElement(By.id(NUMERO_INSCRIPCION));
		//elementoWeb.sendKeys(vo.getNumeroInscripcionCooper());
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION,vo.getNumeroInscripcionCooper());
		
		//elementoWeb = driver.findElement(By.id(NUMERO_ASIENTO));
		//elementoWeb.sendKeys(vo.getNumeroAsiento());
		UtilDriver.setCampoById(driver, NUMERO_ASIENTO,vo.getNumeroAsiento());
		
		//driver.findElement(By.name(BOTON_BUSCAR)).click();
		//Thread.sleep(2000);
		UtilDriver.clickBoton( driver,null,  BOTON_BUSCAR );
		***/
		buscarAsiento( driver, vo);
		
		String result = driver.findElement(By.xpath(".//*[@id='"+TABLA_ASIENTOS+"']//td[contains(.,'"+vo.getNumeroAsiento()+"')]")).getText();
		driver.findElement(By.xpath(".//a[contains(@href,'idRegistroAsiento')]")).click();
		Thread.sleep(2000);
		
	}
	
	public static void buscarAsiento(WebDriver driver,VOAsiento vo) throws InterruptedException{
		
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION,vo.getNumeroInscripcionCooper());
		UtilDriver.setCampoById(driver, NUMERO_ASIENTO,vo.getNumeroAsiento());
		
		UtilDriver.clickBoton( driver,null,  BOTON_BUSCAR );
		
		
	}
	
	/**
	 * Elimina un asiento de una cooperativa
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void buscarAsientoEliminar(WebDriver driver,VOAsiento vo) throws InterruptedException{
		
		
		buscarAsiento( driver, vo);
		
		String result = driver.findElement(By.xpath(".//*[@id='"+TABLA_ASIENTOS+"']//td[contains(.,'"+vo.getNumeroAsiento()+"')]")).getText();
		driver.findElement(By.xpath(".//a[contains(@data-href,'RegistroAsientoDelete')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id(BOTON_OK)).click();
		Thread.sleep(3000);
		
		// buscar mensaje de borrado correcto
		driver.findElement(By.id(MSG_ALERT_SUCCESS));
				
				
		System.out.println("Delete asiento correcto");
	}
}
