package net.rodor.testfuncooper.asientos;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.UtilDriver;

public class OPDetalleAsiento extends OPAsientosBase {

	/**
	 * Modificar el texto y la nota marginal del asiento
	 * Es necesario estar situado en la pantalla de detalle del asiento.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void modificaAsiento(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("Modificacion de asiento"+vo.toString());
		

		UtilDriver.setCampoById(driver, ASIENTO,vo.getAsiento());
		UtilDriver.setCampoById(driver, NOTA_MARGINAL,vo.getNotaMarginal());
		
		// guardar
		UtilDriver.clickBoton(driver, null, BOTON_ACEPTAR);
		
		// buscar mensaje de modificacio correcta
		UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null);
		
		System.out.println("Correcto.\n");
		
	}
}
