package net.rodor.testfuncooper;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.soldenommanual.OPAltaSolicitudManual;
import net.rodor.testfuncooper.soldenomonline.VOSolDenomOnline;

public class TestRegresionSolDenomManual {

	WebDriver driver = null;
	VOSolDenomOnline soldenom = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionSolDenomManual....\n");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_soldenomonline_sp_config.xml");
		soldenom = (VOSolDenomOnline) context.getBean("soldenomonline");
		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");
		
		
		Env env = (Env) contextEnv.getBean("env");
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando testRegresion....\n");
		
		OPAltaSolicitudManual.alta(driver, soldenom);
		
		System.out.println("Fin Solicitud Denominacion Manual....\n");
		
		
	}
	
	@After
	public void finaliza(){
		System.out.println("Finalizado Correctamente\n");
		driver.close();
	}
	
	
}
