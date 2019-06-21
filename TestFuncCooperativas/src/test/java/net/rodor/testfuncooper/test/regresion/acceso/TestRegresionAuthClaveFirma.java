package net.rodor.testfuncooper.test.regresion.acceso;

import static org.junit.Assert.assertNotNull;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionAuthClaveFirma extends TestRegresionBase {

	
	@Test
	public void testRegresion() throws InterruptedException{
		
		System.out.println("Lanzando TestRegresionAuthClaveFirma....\n");
		
		// comprobamos que estamos en la pagina de Bienvenida
		assertNotNull(UtilDriver.buscarTexto(driver,"h4", "Bienvenidos"));
		
		System.out.println("Fin TestRegresionAuthClaveFirma\n");
		
	}
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionAuthClaveFirma.... !!!! NO FUNCIONA !!!! \n");
		
		inicializaEntorno();
		
		driver = OPAccesoChrome.autenticacionClaveFirma(env.getProps().get("URL_PRIV"));
		
		
	}
	
	@After
	public void finaliza(){
		//finalizaEntorno();
	}
}
