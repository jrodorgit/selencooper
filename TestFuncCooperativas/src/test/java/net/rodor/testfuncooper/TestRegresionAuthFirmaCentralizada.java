package net.rodor.testfuncooper;

import static org.junit.Assert.assertNotNull;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRegresionAuthFirmaCentralizada {

	WebDriver driver = null;
	
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionAuthFirmaCentralizada....\n");
		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");
		Env env = (Env) contextEnv.getBean("env");
		driver = OPAccesoChrome.autenticacionCentralizada(env.getProps().get("URL_PRIV"));
		
		
	}
	
	@After
	public void finaliza(){
		System.out.println("Finalizado Correctamente\n");
		driver.close();
	}
	@Test
	public void testRegresion() throws InterruptedException{
		
		System.out.println("Lanzando TestRegresionAuthFirmaCentralizada....\n");
		
		// comprobamos que estamos en la pagina de Bienvenida
		assertNotNull(UtilDriver.buscarTexto(driver,"h4", "Bienvenidos"));
		
		System.out.println("Fin TestRegresionAuthFirmaCentralizada\n");
		
	}
}
