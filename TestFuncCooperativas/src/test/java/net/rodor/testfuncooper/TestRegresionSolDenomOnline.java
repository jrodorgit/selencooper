package net.rodor.testfuncooper;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.legajos.OPAltaLegajo;
import net.rodor.testfuncooper.legajos.OPLegajosBase;
import net.rodor.testfuncooper.legajos.VOLegajo;
import net.rodor.testfuncooper.soldenomonline.OPAltaSolicitud;
import net.rodor.testfuncooper.soldenomonline.VOSolDenomOnline;



public class TestRegresionSolDenomOnline {

	WebDriver driver = null;
	VOSolDenomOnline soldenom = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando Test Solicitud Denominacion On-Line....\n");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_soldenomonline_sp_config.xml");
		soldenom = (VOSolDenomOnline) context.getBean("soldenomonline");
		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");
		
		Env env = (Env) contextEnv.getBean("env");
		driver = OPAccesoChrome.accesoPublico(env.getProps().get("URL_PUB"));
		
	}
	
	@After
	public void finaliza(){
		//driver.close();
	}
	@Test
	public void testRegresion() throws InterruptedException{
		
		System.out.println("Lanzando Test Regresion Solicitud Denominacion On-Line....\n");
		
		OPAltaSolicitud.alta(driver,soldenom);
		
		
	}
	
}
