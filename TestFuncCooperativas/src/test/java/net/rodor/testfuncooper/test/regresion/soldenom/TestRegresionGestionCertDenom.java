package net.rodor.testfuncooper.test.regresion.soldenom;

import static org.junit.Assert.assertNotNull;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.menu.OPMenu;
import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionGestionCertDenom extends TestRegresionBase {

	
	
	VOSolDenomOnline soldenom = null;
	
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionGestionCertDenom....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/soldenom/data_set_soldenomonline_sp_config.xml");
		soldenom = (VOSolDenomOnline) context.getBean("soldenomgest");
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
	}
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionGestionCertDenom....\n");

		// obtenemos la solicitud de denominacion para la que vamos a generar certificado negativo.
		soldenom = serv.getExpeDeno(soldenom.getDenominacionUno());
		
		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_DENOMINACION, OPMenu.MENU_DENOMINACION_BUSQ_EXPEDIENTES);
		
		// buscar expediente de solicitud
		UtilDriver.setCampoById(driver, "numExpediente", soldenom.getNumexpediente());
		UtilDriver.clickBoton(driver, "botonSearch", null, null);
		
		//ir detalle de expediente
		UtilDriver.clickAnchor(driver, "href", "idExpediente");
		
		// anadimos observaciones al expediente
		UtilDriver.setCampoById(driver, "observacionExpediente", "Obsevaciones automaticas al expediente:"+soldenom.getNumexpediente());
		UtilDriver.clickByTextoBoton(driver, "dir", "button");
		
		// ir al denominacion para generar certificado negativo.
		UtilDriver.clickAnchor(driver, "href", "idDenominacion");
		
		// anadimos observaciones la denominacion
		UtilDriver.setCampoById(driver, "observacionDenominacion", "Obsevaciones automÁticas a la denominación-");
		UtilDriver.clickByTextoBoton(driver, "dir", "button");
		assertNotNull(UtilDriver.buscarTexto(driver,"td", "Obsevaciones automÁticas a la denominación-"));
				
				
		// buscamos una denominacion para ver si exite
		UtilDriver.clearCampoById(driver, "textoBuscar");
		UtilDriver.setCampoById(driver, "textoBuscar", "BERGANTIÑOS");
		UtilDriver.clickByTextoBoton(driver, "Buscar", "submit");
		
		// accedemos al detalle de denominacion y lo cerramos
		UtilDriver.clickAnchor(driver, "onclick", "5848");
		UtilDriver.clickByTextoClassBoton(driver,"Cerrar","btn btn-sm btn-default");
		
		// generamos certificado negativo por tiempo de reserva por defecto.
		UtilDriver.clickByTextoBoton(driver,"Negativo","button");
		UtilDriver.clickByTextoBoton(driver,"Aceptar","button");
		
		// consultar el certficado generado y volver
		UtilDriver.clickAnchor(driver, "href", "idCertificado");
		UtilDriver.clickBoton(driver, "botonAtras", null, null);
		
		
		
		System.out.println("Fin TestRegresionGestionCertDenom\n");
	}
	
}
