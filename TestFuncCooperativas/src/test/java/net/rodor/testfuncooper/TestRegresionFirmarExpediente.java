package net.rodor.testfuncooper;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.expediente.VOExpediente;
import net.rodor.testfuncooper.menu.OPMenu;
import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;

public class TestRegresionFirmarExpediente {

	
	private  UtilServiceImpl serv;
	VOExpediente expediente = null;
	VOSolDenomOnline soldenom = null;
	WebDriver driver = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionFirmarExpediente....\n");
		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");

		serv = contextEnv.getBean(UtilServiceImpl.class);
		
		ApplicationContext contextEnvBis = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");
		
		Env env = (Env) contextEnvBis.getBean("env");
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
		
	}
	@After
	public void finaliza(){
		System.out.println("Finalizacion \n");
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionFirmarExpediente....\n");

		// obtenemos la solicitud para firmar
		soldenom = serv.getUltimaSolDenominacion();
		expediente = serv.getGrupoFirmaExpediente(soldenom.getNumexpediente());
		
		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_DOCFIRMA, OPMenu.MENU_DOCFIRMA_BANDEJAFIRMA);
		
		// seleccionar en elaboracion
		UtilDriver.clickSeleccionCombo(driver, "2", "idEstadoGrupoFirma");
		UtilDriver.clickBoton(driver, "botonSearch", null, null);
		
		//seleccionar expediente a firma
		UtilDriver.clickCheckBox(driver, "checkboxFirmaMasiva","6");
		
		// firmar
		
		
		
		
		
		
		System.out.println("Fin TestRegresionFirmarExpediente\n");
	}
	
}