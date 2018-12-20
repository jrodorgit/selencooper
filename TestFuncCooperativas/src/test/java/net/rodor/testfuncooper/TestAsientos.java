package net.rodor.testfuncooper;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.asientos.OPAltaAsiento;
import net.rodor.testfuncooper.asientos.OPDetalleAsiento;
import net.rodor.testfuncooper.asientos.OPListadoAsiento;
import net.rodor.testfuncooper.asientos.OPRelacionAsientos;
import net.rodor.testfuncooper.asientos.VOAsiento;

public class TestAsientos {

	@Test
	public void test() throws InterruptedException, AWTException {
		
		//WebDriver driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_PRE_LOGIN_PRIV);
		WebDriver driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_LOCAL_LOGIN_PRIV);
		System.out.println("Test Asientos.\n");
		
		// preparando Asiento con el que trabajaremos.
		VOAsiento asiento = new VOAsiento("11080", "001", "1","1", "Estó es un asiento 9 > 4 de 11080@.com \n kdodk", 
				"esto es una nota marginal 11080", "20/12/2018","Otorgamiento de Poderes");
		
		//Asiento que produce un null pointer al consultarlo tras darlo de alta.
		//VOAsiento asiento = new VOAsiento("11074", "001", "1","1", "Estó es un asiento 9 > 4 de 11074@.com \n kdodk", 
		//"esto es una nota marginal 11074", "20/12/2018","Constitucion");
		
		
		// alta de asiento
		OPAltaAsiento.altaAsientoOK(driver,asiento);
		
		/***
		// alta con error por numero de asiento repetido para la cooperativa.
		OPAltaAsiento.altaAsientoKO(driver,asiento);
		
		
		// busqueda de asiento para eliminarlo
		OPListadoAsiento.buscarAsientoEliminar(driver, asiento);
		
		
		// alta de asiento
		OPAltaAsiento.altaAsientoOK(driver,asiento);
		***/

		
		// buscar asiento para edicion.
		OPListadoAsiento.consultarAsiento(driver, asiento);
		
		// modificar asiento
		asiento.setAsiento("Nuevo texto del asiento tras modificarlo");
		asiento.setNotaMarginal("nueva nota marginal");
		OPDetalleAsiento.modificaAsiento(driver, asiento);
		
		/***
		// relacionar asiento y asientoB
		VOAsiento asientoB = new VOAsiento("11010","001");
		OPRelacionAsientos.addRelacionAsientos(driver, asiento, asientoB,"mi texto relación@<9");
		***/
		
		//driver.close();
		
		assertTrue(true);
	}
		
}
