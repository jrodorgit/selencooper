package net.rodor.testfuncooper;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.asientos.OPAltaAsiento;
import net.rodor.testfuncooper.asientos.VOAsiento;

public class TestAsientos {

	@Test
	public void test() throws InterruptedException, AWTException {
		
		System.out.println("Test Asientos e entorno:" +OPAccesoBase.URL_LOGIN_PRIV);
		WebDriver driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_LOGIN_PRIV);
		
		// preparando Asiento con el que trabajaremos.
		VOAsiento asiento = new VOAsiento("11004", "001", "1","1", "Estó es un asiento 9 > 4 de 11004@.com", 
				"esto es una nota marginal 11004", "17/12/2018");
		
		
		// alta de asiento
		OPAltaAsiento.alta(driver,asiento);
		
		driver.close();
		
		assertTrue(true);
	}
		
}
