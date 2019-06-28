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
	
	public static void enviarRevisionTrasModificar(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("enviarRevisionTrasModificar  Asiento "+vo.toString());
		
		UtilDriver.setCampoById(driver, ASIENTO,"-updated tris");
		UtilDriver.setCampoById(driver, NOTA_MARGINAL,"-updated tris");
		
		// enviar revision
		UtilDriver.clickBoton(driver, null, BOTON_ENVIAR_REVISION);
		
		// buscar mensaje de envio  correcto
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
	public static void rechazar(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("Rechazar Asiento"+vo.toString());
		
		// rechazar
		UtilDriver.clickBoton(driver, null, BOTON_RECHAZAR);
		
		// introducir motivo de rechazo
		UtilDriver.setCampoById(driver, MOTIVO_RECHAZO,"Este asiento no esta bien por bla bla");
		
		UtilDriver.clickBoton(driver, BOTON_OK_MOTIVO,null);
		
		// buscar mensaje de rechazo  correcto
		//assertNotNull( UtilDriver.buscarById(driver, null,null,"panel panel-danger"));
		assertNotNull( UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));
		
		
		System.out.println("Asiento rechazado Correcto");
	}
	public static void marcarRevisado(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("Marcar Asiento como Revisado"+vo.toString());
		
		// rechazar
		UtilDriver.clickBoton(driver, null, BOTON_MARCAR_REVISADO);
		
		
		// buscar mensaje de rechazo  correcto
		assertNotNull( UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));
		
		
		System.out.println("Asiento marcado como revisado Correcto");
	}
	public static void anular(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("Anular Asiento"+vo.toString());
		
		// anular
		UtilDriver.clickBoton(driver, null, BOTON_ANULAR);
		//confirmar anulacion.
		UtilDriver.clickAnchorByText(driver, BOTON_CONFIRMAR_ANULACION);
		
		
		// buscar mensaje correcto
		assertNotNull( UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));
		
		
		System.out.println("Asiento ANULADO");
	}
	
}
