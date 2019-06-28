package net.rodor.testfuncooper.test.regresion.asientos;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.asientos.OPAltaAsiento;
import net.rodor.testfuncooper.asientos.OPAsientosBase;
import net.rodor.testfuncooper.asientos.VOAsiento;
import net.rodor.testfuncooper.legajos.VODocumento;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionRegistroAsiento extends TestRegresionBase {

	
	VODocumento doc = null;
	VOAsiento asiento1 = null;
	VOAsiento asiento2 = null;
	VOAsiento asiento3 = null;
	VOAsiento asientoA = null;
	VOAsiento asientoB = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionRegistroAsiento....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/asientos/data_set_asientos_sp_config.xml");
		
		asiento1 = (VOAsiento) context.getBean("asiento1");
		asiento2 = (VOAsiento) context.getBean("asiento2");
		asiento3 = (VOAsiento) context.getBean("asiento3");
		asientoA = (VOAsiento) context.getBean("asientoA");
		asientoB = (VOAsiento) context.getBean("asientoB");
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
	}
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	
	@Test
	public void testRegresion() throws InterruptedException{
		
		System.out.println("Lanzando TestRegresionRegistroAsiento....\n");
		
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_ALTA);
		OPAltaAsiento.altaAsientoOK(driver,asiento1);
		
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_ALTA);
		OPAltaAsiento.envioARevisionAsiento(driver,asiento2);
		
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_ALTA);
		OPAltaAsiento.envioARevisionAsiento(driver,asientoA);
	
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_ALTA);
		OPAltaAsiento.envioARevisionAsiento(driver,asientoB);
		
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_ALTA);
		OPAltaAsiento.envioARevisionAsiento(driver,asiento3);

		
		System.out.println("Fin TestRegresionRegistroAsiento\n");
	}
}
