package net.rodor.testfuncooper.test.regresion.legajos;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.asientos.VOAsiento;
import net.rodor.testfuncooper.legajos.OPAltaLegajo;
import net.rodor.testfuncooper.legajos.OPAsociacionLegajoAsiento;
import net.rodor.testfuncooper.legajos.OPDetalleLegajo;
import net.rodor.testfuncooper.legajos.VODocumento;
import net.rodor.testfuncooper.legajos.VOLegajo;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionGrabarLegajo extends TestRegresionBase {

	
	VOLegajo legajo = null;
	VODocumento doc = null;
	VOAsiento asiento = null;
	
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionGrabarLegajo....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/legajos/data_set_legajos_sp_config.xml");
		
		legajo = (VOLegajo) context.getBean("legajo");
		doc = (VODocumento) context.getBean("documento");
		asiento = (VOAsiento) context.getBean("asiento");
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
	}
	
	@Test
	public void testRegresion() throws InterruptedException{
		
		System.out.println("Lanzando TestRegresionGrabarLegajo....\n");
		
		OPAltaLegajo.alta(driver,legajo);
		
		OPDetalleLegajo.modificarLegajo(driver,legajo,asiento);
		
		OPDetalleLegajo.addDocALegajo(driver,legajo, doc);
		
		OPDetalleLegajo.visualizarDocLegajo(driver,legajo, doc);
		
		OPDetalleLegajo.modificaDescripcionDocLegajo(driver,legajo, doc);
		
		OPAsociacionLegajoAsiento.addAsientoALegajo(driver, legajo, asiento);
		
	}
	
	@After
	public void finaliza(){
		//finalizaEntorno();
	}
	
	
}