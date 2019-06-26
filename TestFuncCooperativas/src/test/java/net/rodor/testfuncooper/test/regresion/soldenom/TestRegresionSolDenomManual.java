package net.rodor.testfuncooper.test.regresion.soldenom;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;
import net.rodor.testfuncooper.soldenommanual.OPAltaSolicitudManual;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionSolDenomManual extends TestRegresionBase {

	
	VOSolDenomOnline soldenom = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionSolDenomManual....\n");
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/soldenom/data_set_soldenomonline_sp_config.xml");
		soldenom = (VOSolDenomOnline) context.getBean("soldenomonlinemanual");
		
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionSolDenomManual....\n");
		
		OPAltaSolicitudManual.alta(driver, soldenom);
		
		
		System.out.println("Fin TestRegresionSolDenomManual....\n");
		
		
	}
	
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	
	
}
