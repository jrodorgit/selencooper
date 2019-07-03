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
import net.rodor.testfuncooper.legajos.OPDetalleLegajo;
import net.rodor.testfuncooper.legajos.OPListadoLegajo;
import net.rodor.testfuncooper.legajos.VOLegajo;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionEliminarLegajo extends TestRegresionBase {

	
	VOLegajo legajo = null;
	VOAsiento asiento = null;
	
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionEliminarLegajo....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/legajos/data_set_legajos_sp_config.xml");
		
		legajo = (VOLegajo) context.getBean("legajoEliminar");
		asiento = (VOAsiento) context.getBean("asiento");
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
	}
	
	@Test
	public void testRegresion() throws InterruptedException{
		
		System.out.println("Lanzando TestRegresionEliminarLegajo....\n");
		
		OPAltaLegajo.alta(driver,legajo);
		
		OPListadoLegajo.consultarLegajo(driver, legajo, asiento);
		
		OPDetalleLegajo.delAsientoLegajo(driver, legajo);
		
		OPDetalleLegajo.deleteLegajo(driver, legajo);
	}
	
	@After
	public void finaliza(){
		finalizaEntorno();
	}
}