package net.rodor.testfuncooper.asientos;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.UtilWE;
import static org.junit.Assert.*;

public class OPAltaAsiento extends OPAsientosBase {

	private static final String SEPARATOR_CHECKBOX_LABEL = "separatorCheckboxLabel";
	private static final String TIPO_ASIENTO_INSCRIPCION = "Inscripci";
	private static final String CHECKBOX_TIPO_ASIENTO = "checkbox-meyss";
	private static final String BOTON_VOLVER = " Volver";
	public static final String URL = "asientoEditLoad.htm";
	private static final String NUMERO_TOMO = "tomo";
	private static final String NUMERO_FOLIO = "folio";
	private static final String NUMERO_INSCRIPCION = "asiento.cooperativa.numeroRegistro";
	private static final String NUMERO_ASIENTO = "numeroAsiento";
	private static final String DATA_ID_PROCEDIMIENTO = "listaPre";
	private static final String FECHA_ASIENTO = "asiento.fechaAsiento";
	

	private static final String MSG_ALERT_ERROR = "alert-danger";

	
	
	/**
	 * Da de alta un asiento para una cooperativa.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void altaAsientoOK(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("Alta de asiento OK-"+vo.toString());
		
		// alta de asiento OK
		altaAsiento( driver, vo);
		
		// buscar mensaje de alta correcta
		assertNotNull(UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));
		
		//volver.
		//UtilDriver.clickBoton(driver, null, null,BOTON_VOLVER);
		
		System.out.println("Correcto.\n");
		
	}
	public static void envioARevisionAsiento(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("Envio a Revision-"+vo.toString());
		
		// alta de asiento OK
		envioAsientoRevision( driver, vo);
		
		// buscar mensaje de alta correcta
		assertNotNull(UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));
		
		
		
		System.out.println("Correcto.\n");
		
	}

	/**
	 * Da de alta un asiento para una cooperativa.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void altaAsiento(WebDriver driver,VOAsiento vo) throws InterruptedException{
		
		
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION,vo.getNumeroInscripcionCooper());
		UtilDriver.cleanAndSetCampoById(driver, NUMERO_ASIENTO,vo.getNumeroAsiento());
		UtilDriver.setCampoById(driver, ASIENTO,vo.getAsiento());
		UtilDriver.setCampoById(driver, NOTA_MARGINAL,vo.getNotaMarginal());
		UtilDriver.setCampoById(driver, NUMERO_TOMO,vo.getTomo());
		UtilDriver.setCampoById(driver, NUMERO_FOLIO,vo.getFolio());

		// SELECCION DE PROCEDIMIENTO
		UtilDriver.clickSeleccionCombo(driver, vo.getProcedimiento(),DATA_ID_PROCEDIMIENTO,"form-group form-group-sm");

		UtilDriver.setCampoById(driver, FECHA_ASIENTO,vo.getFecha());
		UtilDriver.setCampoById(driver, "listaAsientosRelacionados",vo.getRelacionadoCon());

		UtilDriver.clickBoton(driver, null, BOTON_ACEPTAR);

		
	}
	public static void envioAsientoRevision(WebDriver driver,VOAsiento vo) throws InterruptedException{
		
		
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION,vo.getNumeroInscripcionCooper());
		UtilDriver.cleanAndSetCampoById(driver, NUMERO_ASIENTO,vo.getNumeroAsiento());
		UtilDriver.setCampoById(driver, ASIENTO,vo.getAsiento());
		UtilDriver.setCampoById(driver, NOTA_MARGINAL,vo.getNotaMarginal());
		UtilDriver.setCampoById(driver, NUMERO_TOMO,vo.getTomo());
		UtilDriver.setCampoById(driver, NUMERO_FOLIO,vo.getFolio());

		// SELECCION DE PROCEDIMIENTO
		UtilDriver.clickSeleccionCombo(driver, vo.getProcedimiento(),DATA_ID_PROCEDIMIENTO,"form-group form-group-sm");

		UtilDriver.setCampoById(driver, FECHA_ASIENTO,vo.getFecha());
		UtilDriver.setCampoById(driver, "listaAsientosRelacionados",vo.getRelacionadoCon());

		UtilDriver.clickBoton(driver, null, BOTON_ENVIAR_REVISION);

		
	}


	
	/**
	 * Alta de asiento. Como tiene error el mensaje a comprobar es de error.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void altaAsientoKO(WebDriver driver,VOAsiento vo) throws InterruptedException{
		
		System.out.println("Alta de asiento KO - " + vo.toString());
		
		// alta de asiento que debe de fallar
		altaAsiento( driver, vo);
		
		// buscar mensaje de alta no correcta
		assertNotNull(UtilDriver.buscarById(driver, MSG_ALERT_ERROR,null,null));
		
		System.out.println("Alta de asiento KO correcta");
		
	}
	
	
}
