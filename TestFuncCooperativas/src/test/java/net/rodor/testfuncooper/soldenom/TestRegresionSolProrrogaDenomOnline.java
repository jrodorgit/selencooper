package net.rodor.testfuncooper.soldenom;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;
import net.rodor.testfuncooper.soldenomonline.OPAltaSolicitud;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionSolProrrogaDenomOnline extends TestRegresionBase {

	
	VOSolDenomOnline soldenom = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionSolProrrogaDenomOnline....\n");
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/soldenom/data_set_soldenomonline_sp_config.xml");
		soldenom = (VOSolDenomOnline) context.getBean("soldenomonlineprorroga");

		driver = OPAccesoChrome.accesoPublico(env.getProps().get("URL_PUB"));

	}
	
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando Test Regresion Solicitud Prorroga de Denominacion On-Line....\n");
		
		OPAltaSolicitud.altaProrroga(driver,soldenom);
		
		System.out.println("Fin Solicitud Prorroga de Denominacion On-Line....\n");
	}
	
}