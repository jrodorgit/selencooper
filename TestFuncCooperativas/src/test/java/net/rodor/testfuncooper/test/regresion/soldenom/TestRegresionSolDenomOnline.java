package net.rodor.testfuncooper.test.regresion.soldenom;

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



public class TestRegresionSolDenomOnline extends TestRegresionBase {

	
	VOSolDenomOnline soldenom = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionSolDenomOnline....\n");
		
		inicializaEntorno();

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/soldenom/data_set_soldenomonline_sp_config.xml");
		
		soldenom = (VOSolDenomOnline) context.getBean("soldenomonline");
		

		driver = OPAccesoChrome.accesoPublico(env.getProps().get("URL_PUB"));

	}
	
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionSolDenomOnline....\n");
		
		OPAltaSolicitud.alta(driver,soldenom);
		
		System.out.println("Fin TestRegresionSolDenomOnline....\n");
	}
	
	
}
