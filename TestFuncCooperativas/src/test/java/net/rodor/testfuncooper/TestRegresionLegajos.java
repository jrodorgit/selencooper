package net.rodor.testfuncooper;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.asientos.VOAsiento;
import net.rodor.testfuncooper.legajos.OPAltaLegajo;
import net.rodor.testfuncooper.legajos.OPAsociacionLegajoAsiento;
import net.rodor.testfuncooper.legajos.OPDetalleLegajo;
import net.rodor.testfuncooper.legajos.VODocumento;
import net.rodor.testfuncooper.legajos.VOLegajo;

public class TestRegresionLegajos {

	WebDriver driver = null;
	VOLegajo legajo = null;
	VODocumento doc = null;
	VOAsiento asiento = null;
	
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando Test Legajos....\n");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_legajos_sp_config.xml");
		
		legajo = (VOLegajo) context.getBean("legajo");
		doc = (VODocumento) context.getBean("documento");
		asiento = (VOAsiento) context.getBean("asiento");

		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");
		
		Env env = (Env) contextEnv.getBean("env");
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
	}
	
	@Test
	public void testRegresion() throws InterruptedException{
		
		System.out.println("Lanzando Test Regresion Legajos....\n");
		
		OPAltaLegajo.alta(driver,legajo);
		
		OPDetalleLegajo.modificarLegajo(driver,legajo);
		
		OPDetalleLegajo.addDocALegajo(driver,legajo, doc);
		
		OPDetalleLegajo.visualizarDocLegajo(driver,legajo, doc);
		
		OPDetalleLegajo.modificaDescripcionDocLegajo(driver,legajo, doc);
		
		OPDetalleLegajo.delDocLegajo(driver,legajo);
		/**/
		OPAsociacionLegajoAsiento.addAsientoALegajo(driver, legajo,asiento);
		
		OPDetalleLegajo.delAsientoLegajo(driver, legajo);
		OPDetalleLegajo.delAsientoLegajo(driver, legajo);
		
		OPDetalleLegajo.deleteLegajo(driver, legajo);
		
		
		
	}
	
	@After
	public void finaliza(){
		System.out.println("Fin Test Regresion Legajos");
		driver.close();
	}
	
	
}
