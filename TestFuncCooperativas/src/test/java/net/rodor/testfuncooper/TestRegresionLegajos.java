package net.rodor.testfuncooper;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.asientos.VOAsiento;
import net.rodor.testfuncooper.legajos.OPAltaLegajo;
import net.rodor.testfuncooper.legajos.OPAsociacionLegajoAsiento;
import net.rodor.testfuncooper.legajos.OPDetalleLegajo;
import net.rodor.testfuncooper.legajos.VODocumento;
import net.rodor.testfuncooper.legajos.VOLegajo;

public class TestRegresionLegajos {

	WebDriver driver = null;
	VOLegajo legajo = null;
	VODocumento doc = null;
	VOAsiento asiento = null;
	
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando Test Legajos....\n");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_legajos_sp_config.xml");
		
		legajo = (VOLegajo) context.getBean("legajo");
		doc = (VODocumento) context.getBean("documento");
		asiento = (VOAsiento) context.getBean("asiento");

		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");
		
		Env env = (Env) contextEnv.getBean("env");
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
	}
	
	@Test
	public void testRegresion() throws InterruptedException{
		
		System.out.println("Lanzando Test Regresion Legajos....\n");
		
		OPAltaLegajo.alta(driver,legajo);
		
		OPDetalleLegajo.modificarLegajo(driver,legajo);
		
		OPDetalleLegajo.addDocALegajo(driver,legajo, doc);
		
		OPDetalleLegajo.visualizarDocLegajo(driver,legajo, doc);
		
		OPDetalleLegajo.delDocLegajo(driver,legajo);
		
		OPAsociacionLegajoAsiento.addAsientoALegajo(driver, legajo,asiento);
		
		OPDetalleLegajo.delAsientoLegajo(driver, legajo);
		
		
	}
	
	@After
	public void finaliza(){
		driver.close();
	}
	/***
	public void testAltaLegajo()  {
		
		try {
			OPAltaLegajo.alta(driver,legajo);
			assertTrue(true);
		} catch (Exception e) {
			fail("Se ha producido un error no contralado en alta de legajo.");
			e.printStackTrace();
		}finally{
			//driver.close();
		}
		

	}
	**/
	/***
	public void testModificarLegajo()  {
		
		try {
			
			OPDetalleLegajo.modificarLegajo(driver,legajo);
			assertTrue(true);
			
		} catch (Exception e) {
			
			fail("Se ha producido un error no contralado en modificacion de legajo.");
			e.printStackTrace();
			
		}finally{
			//driver.close();
		}
		

	}
	***/
	/***
	public void testAddDocALegajo()  {
		
		try {
			
			OPDetalleLegajo.addDocALegajo(driver,legajo, doc);
			assertTrue(true);
			
		} catch (Exception e) {
			
			fail("Se ha producido un error no contralado en add documento a legajo.");
			e.printStackTrace();
			
		}finally{
			//driver.close();
		}
		

	}
	
	public void testVisualizarDocdeLegajo()  {
		
		try {
			
			OPDetalleLegajo.visualizarDocLegajo(driver,legajo, doc);
			assertTrue(true);
			
		} catch (Exception e) {
			
			fail("Se ha producido un error no contralado en visualizacion documento a legajo.");
			e.printStackTrace();
			
		}finally{
			//driver.close();
		}
		

	}
	public void testDeleteDocdeLegajo()  {
		
		try {
			
			OPDetalleLegajo.delDocLegajo(driver,legajo);
			assertTrue(true);
			
		} catch (Exception e) {
			
			fail("Se ha producido un error no contralado en eliminacion documento a legajo.");
			e.printStackTrace();
			
		}finally{
			//driver.close();
		}
		

	}
	
	public void testAsociarAsientoALegajo()  {
		
		try {
			
			OPAsociacionLegajoAsiento.addAsientoALegajo(driver, legajo,asiento);
			assertTrue(true);
			
		} catch (Exception e) {
			
			fail("Se ha producido un error no contralado en asociar asiento a legajo.");
			e.printStackTrace();
			
		}finally{
			//driver.close();
		}
		

	}
	
	public void testDeleteAsientoDeLegajo()  {
		
		try {
			
			OPDetalleLegajo.delAsientoLegajo(driver, legajo);
			assertTrue(true);
			
		} catch (Exception e) {
			
			fail("Se ha producido un error no contralado en dessociar asiento de legajo.");
			e.printStackTrace();
			
		}finally{
			//driver.close();
		}
		

	}
	***/
	/***
	public void test() throws InterruptedException, AWTException {
		

		//WebDriver driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_LOCAL_LOGIN_PRIV);
		//WebDriver driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_PRE_LOGIN_PRIV);
		//System.out.println("Test Legajos.\n");
		/***
		// preparando legajo con el que trabajaremos.
		VOLegajo legajo = new VOLegajo("001","10069","exp-001-1069-069","20/12/2018","2");
		VODocumento doc = new VODocumento("C:\\Java\\","AngularJSCheatSheet.pdf");
		VOAsiento asiento = new VOAsiento("11067", "001");
		***/
		/**
		// alta de legajo
		OPAltaLegajo.alta(driver,legajo);
		**/
		/***
		//busqueda
		OPListadoLegajo.consultarLegajo(driver,legajo);
		/***
		//modificacion del expediente de legajo
		OPDetalleLegajo.modificarLegajo(driver,legajo);
		
		// add documento a legajo
		OPDetalleLegajo.addDocALegajo(driver,legajo, doc);
		
		// visualizacion del documento
		OPDetalleLegajo.visualizarDocLegajo(driver, legajo, doc);
		
		// del documento legajo
		OPDetalleLegajo.delDocLegajo(driver,legajo);
		
		// anadimos relacion con asiento
		OPAsociacionLegajoAsiento.addAsientoALegajo(driver, legajo,asiento);
		
		// borramos la relacion legajo-asiento
		OPDetalleLegajo.delAsientoLegajo(driver, legajo);
		*** /
		
		//driver.close();
		
		//assertTrue(true);
	}

	***/
	
}
