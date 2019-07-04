package net.rodor.testfuncooper.test.regresion.bandejafirma;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.expediente.VOExpediente;
import net.rodor.testfuncooper.menu.OPMenu;
import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionFirmarExpediente  extends TestRegresionBase {

	VOExpediente expediente = null;
	VOSolDenomOnline soldenom = null;

	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionFirmarExpediente....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/bandejafirma/data_set_bandejafirma_sp_config.xml");
		soldenom = (VOSolDenomOnline) context.getBean("soldenom");
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
		
	}
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionFirmarExpediente....\n");

		// obtenemos la solicitud para firmar
		soldenom = serv.getExpeDeno(soldenom.getDenominacionUno());
		expediente = serv.getGrupoFirmaExpediente(soldenom.getNumexpediente());
		
		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_DOCFIRMA, OPMenu.MENU_DOCFIRMA_BANDEJAFIRMA);
		
		// seleccionar pdte de firma
		UtilDriver.clickSeleccionCombo(driver, "2", "idEstadoGrupoFirma");
		UtilDriver.clickBoton(driver, "botonSearch", null, null);
		
		//seleccionar para firmar todos - cambiar
		UtilDriver.clickById(driver, "seleccionarTodos");
		
		// firmar - revisar que no parece que este bien.
		UtilDriver.clickBoton(driver, "botonFirmarSeleccionados", null, null);
		UtilDriver.clickAnchorByText(driver,"Con certificado digital");
		OPAccesoChrome.firmarConCertificado(driver);
		
		System.out.println("Fin TestRegresionFirmarExpediente\n");
	}
	
}