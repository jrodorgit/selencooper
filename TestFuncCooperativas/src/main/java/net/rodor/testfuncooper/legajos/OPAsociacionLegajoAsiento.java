package net.rodor.testfuncooper.legajos;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.UtilWE;
import net.rodor.testfuncooper.asientos.VOAsiento;

public class OPAsociacionLegajoAsiento {
	
	private static final String TABLA_ASIENTOS_LEGAJOS_ASOCIADOS = "tablaAsientosLegajosAsociados_wrapper";
	private static final String CHECKBOX_SELECCION_MASIVA = "checkboxSeleccionMasiva";
	private static final String TABLA_ASIENTOS_LEGAJOS_NO_ASOCIADOS = "tablaAsientosLegajosNoAsociados";
	private static final String BOTON_SEARCH = "botonSearch";
	private static final String NUMERO_ASIENTO = "numeroAsiento";
	private static final String BOTON_AGREGAR_RELACION = "agregar";
	private static final String BOTON_ATRAS = "botonAtras";

	/**
	 * Relacion un legajo con un asiento. Es necesario que exista el asiento y haber ejecutado la prueba de busqueda de legajo para situar ahi la prueba.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void addAsientoALegajo(WebDriver driver,VOLegajo vo, VOAsiento asiento) throws InterruptedException{
		
		//clic en +Relacion
		UtilDriver.clickByName(driver, BOTON_AGREGAR_RELACION);
		
		// buscar asiento para asociar.
		UtilDriver.setCampoById(driver, NUMERO_ASIENTO, asiento.getNumeroAsiento());
		UtilDriver.clickBoton(driver, BOTON_SEARCH, null);
		
		// seleccionar asiento deseado del lsitado de no relacionados
		UtilWE.clickByClassName( UtilDriver.buscarById(driver, TABLA_ASIENTOS_LEGAJOS_NO_ASOCIADOS), CHECKBOX_SELECCION_MASIVA);
		
		//click en agregar asiento
		UtilDriver.clickByName(driver, BOTON_AGREGAR_RELACION);
		
		//comprobamos que esta dadao de alta la asociacion
		UtilDriver.exiteRegistroEnTabla(driver, TABLA_ASIENTOS_LEGAJOS_ASOCIADOS, asiento.getNumeroAsiento());
		
		//volvemos a detalle legajo
		UtilDriver.clickBoton(driver, BOTON_ATRAS, null);
		
		System.out.println("Relacion asiento-legajo correcto");		
		
	}
}
