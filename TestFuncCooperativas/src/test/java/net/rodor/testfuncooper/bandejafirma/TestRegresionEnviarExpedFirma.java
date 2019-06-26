package net.rodor.testfuncooper.bandejafirma;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.Env;
import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.UtilServiceImpl;
import net.rodor.testfuncooper.expediente.VOExpediente;
import net.rodor.testfuncooper.menu.OPMenu;
import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionEnviarExpedFirma extends TestRegresionBase {

	VOSolDenomOnline soldenom = null;
	VOExpediente expediente = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionEnviarExpedFirma....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/bandejafirma/data_set_bandejafirma_sp_config.xml");
		soldenom = (VOSolDenomOnline) context.getBean("soldenom");
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
		
	}
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionEnviarExpedFirma....\n");

		// obtenemos la solicitud de denominacion para la que vamos a generar certificado negativo.
		soldenom = serv.getExpeDeno(soldenom.getDenominacionUno());
		expediente = serv.getGrupoFirmaExpediente(soldenom.getNumexpediente());
		
		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_DOCFIRMA, OPMenu.MENU_DOCFIRMA_BANDEJAFIRMA);
		
		// seleccionar en elaboracion
		UtilDriver.clickSeleccionCombo(driver, "1", "idEstadoGrupoFirma");
		UtilDriver.clickBoton(driver, "botonSearch", null, null);
		
		// seleccionar expediente a enviar a firma
		UtilDriver.clickCheckBox(driver, "checkbox", expediente.getIdGrupoFirma());

		/***
		UtilDriver.clickAnchor(driver, "onclick", "navegarReordenacionGrupoFirma("+expediente.getIdGrupoFirma());
		***/
		// enviar a firma
		UtilDriver.clickBoton(driver, "idBotonEnviarAFirma", null, null);
			
		System.out.println("Fin TestRegresionEnviarExpedFirma\n");
	}
	
}