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
		
		OPListadoAsiento.consultarAsiento( driver, vo);

		UtilDriver.setCampoById(driver, ASIENTO,vo.getAsiento());
		UtilDriver.setCampoById(driver, NOTA_MARGINAL,vo.getNotaMarginal());
		
		// guardar
		UtilDriver.clickBoton(driver, null, BOTON_ACEPTAR);
		
		// buscar mensaje de modificacio correcta
		assertNotNull( UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));
		
		
		
	}
}
