package net.rodor.testfuncooper;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.asientos.OPAltaAsiento;
import net.rodor.testfuncooper.asientos.OPAsientosBase;
import net.rodor.testfuncooper.asientos.OPDetalleAsiento;
import net.rodor.testfuncooper.asientos.OPListadoAsiento;
import net.rodor.testfuncooper.asientos.VOAsiento;
import net.rodor.testfuncooper.legajos.VODocumento;



public class TestRegresionGrabacionAsientos {

	WebDriver driver = null;
	VODocumento doc = null;
	VOAsiento asiento = null;
	VOAsiento asientoOtro = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando Test Grabacion Asientos....\n");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_asientos_sp_config.xml");
		
		asiento = (VOAsiento) context.getBean("asiento");
		asientoOtro= (VOAsiento) context.getBean("asientoOtro");
		//doc = (VODocumento) context.getBean("documento");
		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");
		
		Env env = (Env) contextEnv.getBean("env");
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
	}
	
	@Test
	public void testRegresion() throws InterruptedException{
		/***/
		System.out.println("Lanzando Test Regresion Grabacion Asientos....\n");
		
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_ALTA);
		
		OPAltaAsiento.altaAsientoOK(driver,asiento);
		
		OPAltaAsiento.altaAsientoOK(driver,asientoOtro);
		
		OPAltaAsiento.altaAsientoKO(driver,asientoOtro);
		
		
		// voy a mandarlo a revision
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		OPListadoAsiento.consultarAsiento(driver, asiento);
		
		OPDetalleAsiento.enviarRevision(driver, asiento);
		
		// ups voy a recuperarlo que me he equivocado, lo cambio y lo envio de nuevo
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		OPListadoAsiento.consultarAsiento(driver, asiento);
		
		OPDetalleAsiento.recuperar(driver, asiento);
		
		OPDetalleAsiento.modificaAsiento(driver, asiento);
		
		OPDetalleAsiento.enviarRevision(driver, asiento);
		/***/
		
		// el revisor lo consulta y lo rechaza.
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		OPListadoAsiento.consultarAsiento(driver, asiento);
		
		OPDetalleAsiento.rechazar(driver, asiento);
		
		
		// Lel grabador le actualiza y le manda de nuevo a revision
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		OPListadoAsiento.consultarAsiento(driver, asiento);
		
		OPDetalleAsiento.enviarRevisionTrasModificar(driver, asiento);
		
		// el revisor lo da por bueno
		UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		OPListadoAsiento.consultarAsiento(driver, asiento);
		
		OPDetalleAsiento.marcarRevisado(driver, asiento);
		
		
	}
	@After
	public void finaliza(){
		System.out.println("Fin Test Regresion Grabacion Asientos");
		driver.close();
	}
}
