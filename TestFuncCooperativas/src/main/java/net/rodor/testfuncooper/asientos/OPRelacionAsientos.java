package net.rodor.testfuncooper.asientos;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.UtilWE;

public class OPRelacionAsientos extends OPAsientosBase {

	private static final String BOTON_ADD_RELACION = "botonAnnadirRegistroAsiento";
	public final static String BOTON_RELACION = " Relación";
	public final static String BOTON_ACEPTAR_REL = "Aceptar";
	public final static String BOTON_CERRAR_VENTANA_OK = "close closeCorrect";
	public final static String BOTON_VOLVER = "Volver";
	
	private static final String NUMERO_ASIENTO = "numeroAsiento";
	private static final String OBS_RELACION = "observacionesRelacionAsientos";
	private static final String BOTON_SEARCH = "botonSearch";
	private static final String TABLA_ASIENTOS_NO_ASOCIADOS = "tablaAsientoNoRelacionado";
	private static final String CHECKBOX_SELECCION_MASIVA = "seleccionarTodos";
	/**
	 * Relaciona los asientos A y B para la cooperativa. 
	 * @param driver
	 * @param asientoA
	 * @param asientoB
	 * @throws InterruptedException 
	 */
	public static void addRelacionAsientos(WebDriver driver,VOAsiento asientoA, VOAsiento asientoB, String textoRelacion) throws InterruptedException{
		
		System.out.println("Alta de relacion entre asientos A\n"+ asientoA.toString());
		
		System.out.println("y B\n"+ asientoB.toString());
		
		// ir a detalle de asiento
		OPListadoAsiento.consultarAsiento( driver, asientoA);
		
		//clic en +Relacion
		UtilDriver.clickByTextoBoton(driver,BOTON_RELACION, null);
		
		// buscar asiento B
		UtilDriver.setCampoById(driver, NUMERO_ASIENTO, asientoB.getNumeroAsiento());
		UtilDriver.clickBoton(driver, BOTON_SEARCH, null);
		
		// seleccionar asientoB deseado del lsitado de no relacionados
		UtilWE.clickById(UtilDriver.buscarById(driver, TABLA_ASIENTOS_NO_ASOCIADOS, null, null),CHECKBOX_SELECCION_MASIVA);
		
		//click en agregar asiento
		UtilDriver.clickBoton(driver, BOTON_ADD_RELACION, null);
		
		// rellenar observaciones a la relacion
		UtilDriver.setCampoById(driver, OBS_RELACION, textoRelacion);
		
		// click en aceptar observacion
		UtilDriver.clickByTextoBoton(driver,BOTON_ACEPTAR_REL, null);
		
		// cerrar pantalla de aviso de relacion alta correcta.
		UtilDriver.clickBoton(driver, null, null,BOTON_CERRAR_VENTANA_OK);
		
		//volver a detalle de Asiento
		UtilDriver.clickBoton( driver,null,  null, BOTON_VOLVER );
		
		System.out.println("Correcta");
		
	}
	
	
}
