package net.rodor.testfuncooper.asientos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.rodor.testfuncooper.UtilDriver;
import static org.junit.Assert.*;

public class OPDetalleAsiento extends OPAsientosBase {

	/**
	 * Modificar el texto y la nota marginal del asiento
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void modificaAsiento(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("Modificacion de asiento"+vo.toString());
		
		//OPListadoAsiento.consultarAsiento( driver, vo);

		UtilDriver.setCampoById(driver, ASIENTO,"-updated bis");
		UtilDriver.setCampoById(driver, NOTA_MARGINAL,"-updated bis");
		
		// guardar
		UtilDriver.clickBoton(driver, null, BOTON_ACEPTAR);
		
		// buscar mensaje de modificacio correcta
		assertNotNull( UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));
		
		
		
	}
	
	public static void enviarRevision(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("Enviar  Asiento a Revision"+vo.toString());
		
		// enviar revision
		UtilDriver.clickBoton(driver, null, BOTON_ENVIAR_REVISION);
		
		// buscar mensaje de envio  correcto
		assertNotNull( UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));
		
		
		
	}
	public static void recuperar(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("Recuperar Asiento"+vo.toString());
		
		// enviar revision
		UtilDriver.clickBoton(driver, null, BOTON_RECUPERAR);
		
		// buscar mensaje de envio  correcto
		assertNotNull( UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));
		
		
		
	}
}
