package net.rodor.testfuncooper.legajos;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.UtilWE;

import static org.junit.Assert.*;

import org.junit.Test;

public class OPAltaLegajo extends OPLegajosBase {
	
	private static final String TIPO_EXPEDIENTE_2 = "2";
	private static final String ID_TIPO_EXPEDIENTE = "idTipoExpediente";
	private static final String MSG_ALERT_SUCCESS = "alert-success";
	private static final String BOTON_ATRAS = "botonAtras";
	private static final String BOTON_ACEPTAR = "aceptar";
	private static final String NUMERO_REGISTRO = "numeroRegistro";
	private static final String NUMERO_INSCRIPCION = "numeroInscripcion";
	private static final String DESCRIPCION = "descripcion";
	private static final String ASIENTOS_RELACIONADOS = "asientosRelacionados";
	
	@Test
	public static void alta(WebDriver driver,VOLegajo vo) throws InterruptedException{
		
		System.out.println("Alta de legajo-"+vo.toString());
		
		UtilDriver.goMenu(driver, OPLegajosBase.MENU,OPLegajosBase.SUB_MENU_ALTA);
		
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION, vo.getNumeroInscripcion());
		
		UtilDriver.setCampoById(driver, DESCRIPCION, vo.getDescripcion());
		
		//UtilWE.selectOption(UtilDriver.buscarById(driver, ID_TIPO_EXPEDIENTE, null, null),TIPO_EXPEDIENTE_2);
		
		UtilDriver.setCampoById(driver, NUMERO_REGISTRO, vo.getNumeroRegistro());
		
		UtilDriver.setCampoById(driver, ASIENTOS_RELACIONADOS, vo.getAsientosRel());
		
		
		UtilDriver.clickBoton(driver, null, BOTON_ACEPTAR);
		
		assertNotNull(UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));
		
		UtilDriver.clickBoton(driver, BOTON_ATRAS, null);
		
		
		System.out.println("Correcto.\n");
		
	}
	
}
