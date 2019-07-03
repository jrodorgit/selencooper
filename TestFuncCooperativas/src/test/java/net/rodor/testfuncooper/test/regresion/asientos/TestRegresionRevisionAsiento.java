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
import net.rodor.testfuncooper.asientos.OPDetalleAsiento;
import net.rodor.testfuncooper.asientos.OPListadoAsiento;
import net.rodor.testfuncooper.asientos.VOAsiento;
import net.rodor.testfuncooper.legajos.VODocumento;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionRevisionAsiento extends TestRegresionBase {

	
	VODocumento doc = null;
	VOAsiento asiento1 = null;
	VOAsiento asiento2 = null;
	VOAsiento asiento3 = null;
	VOAsiento asientoA = null;
	VOAsiento asientoB = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionRevisionAsiento....\n");
		
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
		
		System.out.println("Lanzando TestRegresionRevisionAsiento....\n");

		// modificamos el asiento1
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		OPListadoAsiento.consultarAsiento(driver, asiento1);
		OPDetalleAsiento.modificaAsiento(driver, asiento1);
		
		// marcamos como revisado el asiento2
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		OPListadoAsiento.consultarAsiento(driver, asiento2);
		OPDetalleAsiento.marcarRevisado(driver, asiento2);
		
		// rechazamos el asiento A.
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		OPListadoAsiento.consultarAsiento(driver, asientoA);
		OPDetalleAsiento.rechazar(driver, asientoA);
		
		// anulamos el asiento B.
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		OPListadoAsiento.consultarAsiento(driver, asientoB);
		OPDetalleAsiento.anular(driver, asientoB);
		// y lo volvemos a dar de alta
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_ALTA);
		OPAltaAsiento.envioARevisionAsiento(driver,asientoB);
		
		// recuperamos el asiento 3
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		OPListadoAsiento.consultarAsiento(driver, asiento3);
		OPDetalleAsiento.recuperar(driver, asiento3);

		
		System.out.println("Fin TestRegresionRevisionAsiento\n");
	}

}
