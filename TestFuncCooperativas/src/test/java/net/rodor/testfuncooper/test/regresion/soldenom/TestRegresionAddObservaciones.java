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

public class TestRegresionAddObservaciones extends TestRegresionBase {

	
	
	VOSolDenomOnline soldenom = null;
	VOSolDenomOnline soldenomAux = null;
	
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionAddObservaciones....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/soldenom/data_set_soldenomonline_sp_config.xml");
		soldenom = (VOSolDenomOnline) context.getBean("soldenomonlineprorroga");
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
	}
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionAddObservaciones....\n");

		// obtenemos la solicitud de denominacion para la que vamos a generar certificado negativo.
		soldenomAux = serv.getExpeDeno(soldenom.getDenominacionUno());
		
		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_DENOMINACION, OPMenu.MENU_DENOMINACION_BUSQ_EXPEDIENTES);
		
		// buscar expediente de solicitud
		UtilDriver.setCampoById(driver, "numExpediente", soldenomAux.getNumexpediente());
		UtilDriver.clickBoton(driver, "botonSearch", null, null);
		
		//ir detalle de expediente
		UtilDriver.clickAnchor(driver, "href", "idExpediente");
		
		// comprobamos que se ha grabado al menos una denominacion
		assertNotNull(UtilDriver.buscarTexto(driver,"td", soldenom.getDenominacionUno()));
		
		// anadimos observaciones al expediente
		UtilDriver.setCampoById(driver, "observacionExpediente", "Obsevaciones automaticas al expediente:"+soldenomAux.getNumexpediente());
		UtilDriver.clickByTextoBoton(driver, "dir", "button");
		assertNotNull(UtilDriver.buscarTexto(driver,"td", "Obsevaciones automaticas al expediente:"+soldenomAux.getNumexpediente()));
		
		UtilDriver.setCampoById(driver, "observacionExpediente", "Más Obsevaciones automaticas al expediente:"+soldenomAux.getNumexpediente());
		UtilDriver.clickByTextoBoton(driver, "dir", "button");
		assertNotNull(UtilDriver.buscarTexto(driver,"td", "Más Obsevaciones automaticas al expediente:"+soldenomAux.getNumexpediente()));
		
		// eliminamos una observacion del expediente
		UtilDriver.clickIcon(driver,"class","glyphicon glyphicon-trash");
		UtilDriver.clickAnchorByText(driver, "Sí");
		
		System.out.println("Fin TestRegresionAddObservaciones\n");
	}
	
}