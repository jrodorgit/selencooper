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



public class TestRegresionGrabacionAsientos extends TestRegresionBase {

	
	VODocumento doc = null;
	VOAsiento asiento1 = null;
	VOAsiento asiento2 = null;
	VOAsiento asientoA = null;
	VOAsiento asientoB = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionGrabacionAsientos....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/asientos/data_set_asientos_sp_config.xml");
		
		asiento1 = (VOAsiento) context.getBean("asiento1");
		asiento2 = (VOAsiento) context.getBean("asiento2");
		asientoA = (VOAsiento) context.getBean("asientoA");
		asientoB = (VOAsiento) context.getBean("asientoB");
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
	}
	
	@Test
	public void testRegresion() throws InterruptedException{
		/***/
		System.out.println("Lanzando TestRegresionGrabacionAsientos....\n");
		
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_ALTA);
		
		OPAltaAsiento.altaAsientoOK(driver,asiento1);
		
		//OPAltaAsiento.altaAsientoOK(driver,asiento2);
		//OPAltaAsiento.altaAsientoOK(driver,asientoA);
		//OPAltaAsiento.altaAsientoOK(driver,asientoB);
		//OPAltaAsiento.altaAsientoKO(driver,asiento1);
		
		
		// voy a mandarlo a revision
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		OPListadoAsiento.consultarAsiento(driver, asiento1);
		
		OPDetalleAsiento.enviarRevision(driver, asiento1);
		
		// ups voy a recuperarlo que me he equivocado, lo cambio y lo envio de nuevo
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		OPListadoAsiento.consultarAsiento(driver, asiento1);
		
		OPDetalleAsiento.recuperar(driver, asiento1);
		
		OPDetalleAsiento.modificaAsiento(driver, asiento1);
		
		OPDetalleAsiento.enviarRevision(driver, asiento1);
		/***/
		
		// el revisor lo consulta y lo rechaza.
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		OPListadoAsiento.consultarAsiento(driver, asiento1);
		
		OPDetalleAsiento.rechazar(driver, asiento1);
		
		
		// Lel grabador le actualiza y le manda de nuevo a revision
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		OPListadoAsiento.consultarAsiento(driver, asiento1);
		
		OPDetalleAsiento.enviarRevisionTrasModificar(driver, asiento1);
		
		// el revisor lo da por bueno
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		OPListadoAsiento.consultarAsiento(driver, asiento1);
		
		OPDetalleAsiento.marcarRevisado(driver, asiento1);
		
		System.out.println("Fin TestRegresionGrabacionAsientos\n");
	}
	@After
	public void finaliza(){
		//finalizaEntorno();
	}
}
