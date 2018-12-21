package net.rodor.testfuncooper;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.asientos.OPAltaAsiento;
import net.rodor.testfuncooper.asientos.OPDetalleAsiento;
import net.rodor.testfuncooper.asientos.OPListadoAsiento;
import net.rodor.testfuncooper.asientos.OPRelacionAsientos;
import net.rodor.testfuncooper.asientos.VOAsiento;

public class TestRegresionAsientos {

	WebDriver driver = null;
	VOAsiento asiento = null;
	VOAsiento asientoB = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{
		
		System.out.println("Inicializando Test Asientos....\n");
		asiento =   new VOAsiento("11087", "001", "1","1", "Est� es un asiento 9 > 4 de 11087@.com \n kdodk", 
		"esto es una nota marginal 11087", "21/12/2018","Otorgamiento de Poderes");
		//Asiento que produce un null pointer al consultarlo tras darlo de alta.
				//VOAsiento asiento = new VOAsiento("11074", "001", "1","1", "Est� es un asiento 9 > 4 de 11074@.com \n kdodk", 
				//"esto es una nota marginal 11074", "20/12/2018","Constitucion");
		
		asientoB = new VOAsiento("11010","001");
		
		driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_LOCAL_LOGIN_PRIV);
		//WebDriver driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_PRE_LOGIN_PRIV);
	}
	
	@Test
	public void testRegresion() throws InterruptedException{
		
		System.out.println("Lanzando Test Regresion Asientos....\n");
		
		OPAltaAsiento.altaAsientoOK(driver,asiento);
		
		OPAltaAsiento.altaAsientoKO(driver,asiento);
		
		OPListadoAsiento.eliminarAsiento(driver, asiento);
		
		OPAltaAsiento.altaAsientoOK(driver,asiento);
		
		asiento.setAsiento("Anadimos nuevo texto del asiento tras modificarlo");
		asiento.setNotaMarginal("Anadimos texto a nota marginal");
		OPDetalleAsiento.modificaAsiento(driver, asiento);
		
		OPRelacionAsientos.addRelacionAsientos(driver, asiento, asientoB, "mi texto relaci�n@<9");
		
	}
	
	@After
	public void finaliza(){
		driver.close();
	}
	
	/***
	@Test
	public void test() throws InterruptedException, AWTException {
		
		//WebDriver driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_PRE_LOGIN_PRIV);
		WebDriver driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_LOCAL_LOGIN_PRIV);
		System.out.println("Test Asientos.\n");
		
		// preparando Asiento con el que trabajaremos.
		VOAsiento asiento = new VOAsiento("11084", "001", "1","1", "Est� es un asiento 9 > 4 de 11084@.com \n kdodk", 
				"esto es una nota marginal 11084", "21/12/2018","Otorgamiento de Poderes");
		
		//Asiento que produce un null pointer al consultarlo tras darlo de alta.
		//VOAsiento asiento = new VOAsiento("11074", "001", "1","1", "Est� es un asiento 9 > 4 de 11074@.com \n kdodk", 
		//"esto es una nota marginal 11074", "20/12/2018","Constitucion");
		
		/ *** /
		// alta de asiento
		OPAltaAsiento.altaAsientoOK(driver,asiento);
		/ *** /
		/ *** /
		// alta con error por numero de asiento repetido para la cooperativa.
		OPAltaAsiento.altaAsientoKO(driver,asiento);
		/*** /
		/*** /
		// busqueda de asiento para eliminarlo
		OPListadoAsiento.eliminarAsiento(driver, asiento);
		/*** /
		/*** /
		// alta de asiento
		OPAltaAsiento.altaAsientoOK(driver,asiento);
		/*** /
		/** /
		// ir detalle de asiento
		OPListadoAsiento.consultarAsiento(driver, asiento);
		/***/
		/*** /
		// modificar asiento
		asiento.setAsiento("Anadimos nuevo texto del asiento tras modificarlo");
		asiento.setNotaMarginal("Anadimos texto a nota marginal");
		OPDetalleAsiento.modificaAsiento(driver, asiento);
		/*** /
		/*** /
		// relacionar asiento  y asiento B
		VOAsiento asientoB = new VOAsiento("11010","001");
		OPRelacionAsientos.addRelacionAsientos(driver, asiento, asientoB, "mi texto relaci�n@<9");
		/*** /
		
		driver.close();
		
		assertTrue(true);
	}
		**/
}
