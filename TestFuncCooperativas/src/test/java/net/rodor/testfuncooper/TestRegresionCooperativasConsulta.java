package net.rodor.testfuncooper;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.cooperativas.OPListadoCooperativas;
import net.rodor.testfuncooper.menu.OPMenu;

public class TestRegresionCooperativasConsulta {

	WebDriver driver = null;
	
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionCooperativasConsulta....\n");
		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");
		Env env = (Env) contextEnv.getBean("env");
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
		
	}
	@After
	public void finaliza(){
		System.out.println("Finalizado Correctamente\n");
		//driver.close();
	}
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionCooperativasConsulta....\n");
		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_COOPERATIVAS, OPMenu.MENU_COOPERATIVAS_LISTADO);
		
		// consultar cooperativa
		OPListadoCooperativas listado = new OPListadoCooperativas(driver);
		listado.setCampo(OPListadoCooperativas.CAMPO_NUMERO_INSCRIPCION, "AL-110");
		listado.runEvt(OPListadoCooperativas.EVT_BUSCAR);
		listado.goEnlace("idCooperativa");
		
				
		System.out.println("Fin TestRegresionCooperativasConsulta\n");
		
		
	}
}
