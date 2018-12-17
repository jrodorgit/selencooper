package net.rodor.testfuncooper;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.asientos.OPAltaAsiento;
import net.rodor.testfuncooper.asientos.OPListadoAsiento;
import net.rodor.testfuncooper.asientos.VOAsiento;

public class TestAsientos {

	@Test
	public void test() throws InterruptedException, AWTException {
		
		System.out.println("Test Asientos e entorno:" +OPAccesoBase.URL_LOGIN_PRIV);
		WebDriver driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_LOGIN_PRIV);
		
		// preparando Asiento con el que trabajaremos.
		VOAsiento asiento = new VOAsiento("11021", "001", "1","1", "Estó es un asiento 9 > 4 de 11021@.com \n kdodk", 
				"esto es una nota marginal 11021", "17/12/2018","Constitucion");
		
		//VOAsiento asientoError = new VOAsiento("11013", "001", "1","1", "Estó es un asiento 9 > 4 de 11013@.com", 
		//		"esto es una nota marginal 11013", "17/12/2018","Constitucion");
		
		
		// alta de asiento
		OPAltaAsiento.alta(driver,asiento);
		
		// alta con error por numero de asiento repetido para la cooperativa.
		OPAltaAsiento.altaConError(driver,asiento);
		
		
		// busqueda de asiento para eliminarlo
		OPListadoAsiento.buscarAsientoEliminar(driver, asiento);
		
		// alta de asiento
		OPAltaAsiento.alta(driver,asiento);
		
		// buscar asiento para edicion.
		OPListadoAsiento.buscarAsiento(driver, asiento);
		
		driver.close();
		
		assertTrue(true);
	}
		
}
