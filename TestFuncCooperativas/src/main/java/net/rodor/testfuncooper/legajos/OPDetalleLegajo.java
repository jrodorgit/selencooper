package net.rodor.testfuncooper.legajos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OPModificarLegajo extends OPLegajosBase {

	private static final String BOTON_OK = "botonOK";
	private static final String DOCUMENTO_LEGAJO = "documentoLegajo";
	private static final String ALERT_SUCCESS = "alert-success";
	private static final String EXPEDIENTE2 = "expediente";
	private static final String BOTON_ACEPTAR = "aceptar";
	private static final String BOTON_ATRAS = "botonAtras";
	private static final String BOTON_DOCUMENTO = "Documento";
	private static final String ID_RELACION_LEGAJO_FICHEROBD = "idRelacionLegajoFicheroBD";
	private static final String ID_FICHEROBD = "idFicheBD";
	
	
	

	/**
	 * Modifica el expediente de un legajo. Es necesario ejecutar su busqueda primero para situar ahi la prueba.
	 */
	public static void modificarLegajo(WebDriver driver,VOLegajo vo) throws InterruptedException{
		
		//OPBusquedaLegajo.buscarLegajo(driver,numeroInscripcion,numeroRegistro);
		WebElement elementoWeb = driver.findElement(By.id(EXPEDIENTE2));
		elementoWeb.sendKeys(vo.getExpediente());
		
		elementoWeb = driver.findElement(By.name(BOTON_ACEPTAR));
		elementoWeb.click();
		Thread.sleep(3000);
		
		// buscar mensaje de modificacion correcta
		driver.findElement(By.id(ALERT_SUCCESS));
		
		System.out.println("Legajo modificado correcto.");
	}
	
	/**
	 * anade un documento a un legajo.
	 *  Es necesario ejecutar su busqueda primero para situar ahi la prueba.
	 * @param driver
	 * @param numeroInscripcion
	 * @param numeroRegistro
	 * @param fileName
	 * @throws InterruptedException
	 */
	public static void addDocALegajo(WebDriver driver,VOLegajo vo, VODocumento doc) throws InterruptedException{
		
		WebElement elementoWeb = driver.findElement(By.id(DOCUMENTO_LEGAJO));
		elementoWeb.sendKeys(doc.getRuta()+doc.getNombreFichero());
		driver.findElement(By.xpath("//button[@type='submit' and contains(., '"+BOTON_DOCUMENTO+"')]")).click();
		
		Thread.sleep(5000);
		
		// buscar mensaje de documento dado de alta correctamente
		System.out.println("Add documento a legajo correcto?");
		List<WebElement> msgOK = driver.findElements(By.id(ALERT_SUCCESS));
		for(WebElement we : msgOK){
			System.out.println(we.getText());
		}
		
	}
	
	/**
	 *  Desasocia un documento de un legajo. Es necesario que le legajo tenga al menos un documento, que es el que se a a desasociar.
	 * @param driver
	 * @param vo
	 * @param asiento
	 * @throws InterruptedException 
	 */
	public static void delDocLegajo(WebDriver driver,VOLegajo vo) throws InterruptedException{
		
		driver.findElement(By.xpath(".//a[contains(@data-href,'"+ID_RELACION_LEGAJO_FICHEROBD+"')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id(BOTON_OK)).click();
		Thread.sleep(3000);
		System.out.println("Delete documento legajo correcto");
	}
	
	/**
	 * Visualiza un documento de un legajo.Es necesario que le legajo tenga al menos un documento asociado. Tras visualizarlo vuelve al detalle del legajo.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void visualizarDocLegajo(WebDriver driver,VOLegajo vo,VODocumento doc) throws InterruptedException{
		
		driver.findElement(By.xpath(".//a[contains(@href,'"+ID_FICHEROBD+"')]")).click();
		Thread.sleep(3000);
		
		// comprobamos que estamos en la pagina.
		driver.findElement(By.xpath("//input[@value='"+doc.getNombreFichero()+"']"));
		
		//volvemos a detalle del legajo.
		driver.findElement(By.id(BOTON_ATRAS)).click();
		Thread.sleep(2000);
		System.out.println("Visualizacion documento legajo correcto");				
	}
	
	/**
	 * Desasocia un asiento del legajo. Es necesario que el legajo tenga asociado un asiento.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void delAsientoLegajo(WebDriver driver,VOLegajo vo) throws InterruptedException{
		
		driver.findElement(By.xpath(".//a[contains(@data-href,'idRelLegajoAsiento')]")).click();
		Thread.sleep(3000);
		WebElement elementoWeb = driver.findElement(By.id("dialogConfirmDeleteAsientoLegajo"));
		elementoWeb.findElement(By.xpath(".//a[contains(@href,'idRelLegajoAsiento')]")).click();
		//driver.findElement(By.xpath(".//a[contains(@data-href,'idRelLegajoAsiento')]")).click();
		//driver.findElement(By.className("btn btn-sm btn-primary btn-ok")).click();
		//driver.findElement(By.id("botonOK")).click();
		Thread.sleep(3000);
		System.out.println("Delete relacion legajo-asiento correcto");
	}
}
