package net.rodor.testfuncooper.legajos;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.UtilWE;

public class OPDetalleLegajo extends OPLegajosBase {

	private static final String BOTON_CERRAR_VENTANA_MODADL = "idBotonCerrar";
	private static final String PULSE_PARA_VER_EL_LEGAJO = "Pulse para ver el Legajo";
	private static final String PULSE_PARA_EDITAR_EL_LEGAJO = "Pulse para editar el Documento asociado al Legajo";
	private static final String TITLE = "title";
	private static final String DIALOG_CONFIRM_DELETE_ASIENTO_LEGAJO = "dialogConfirmDeleteAsientoLegajo";
	private static final String ID_REL_LEGAJO_ASIENTO = "idRelLegajoAsiento";
	private static final String BOTON_OK = "botonOK";
	private static final String DOCUMENTO_LEGAJO = "documentoLegajo";
	private static final String ALERT_SUCCESS = "alert-success";
	private static final String BOTON_ACEPTAR = "aceptar";
	private static final String BOTON_ADJUNTAR = "Adjuntar";
	private static final String ID_RELACION_LEGAJO_FICHEROBD = "idRelacionLegajoFicheroBD";
	private static final String DESCRIPCION = "descripcion";

	/**
	 * Modifica el numero expediente de un legajo. Para que funcione tiene que
	 * encontrarse en la pantalla de detalle de legajo.
	 * 
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	@Test
	public static void modificarLegajo(WebDriver driver, VOLegajo vo) throws InterruptedException {

		System.out.println("Modificar Legajo -" + vo.toString());

		OPListadoLegajo.consultarLegajo(driver, vo);

		
		UtilDriver.setCampoById(driver, DESCRIPCION, vo.getDescripcion()+" - UPDATED");
		
		
		UtilDriver.clickBoton(driver, null, BOTON_ACEPTAR);

		assertNotNull(UtilDriver.buscarById(driver, ALERT_SUCCESS, null, null));

		System.out.println("Correcto.\n");
	}

	/**
	 * Anade un documento a un legajo. Es necesario ejecutar su busqueda primero
	 * para situar ahi la prueba.
	 * 
	 * @param driver
	 * @param numeroInscripcion
	 * @param numeroRegistro
	 * @param fileName
	 * @throws InterruptedException
	 */
	public static void addDocALegajo(WebDriver driver, VOLegajo vo, VODocumento doc) throws InterruptedException {

		System.out.println("Add documento a legajo-" + vo.toString() + doc.toString());

		UtilDriver.clickBoton(driver, null, "anadirDocumento");

		UtilDriver.setCampoById(driver, DOCUMENTO_LEGAJO, doc.getRuta() + doc.getNombreFichero());
		UtilDriver.setCampoById(driver, "descripcionFicheroBD", doc.getDescFichero());

		UtilDriver.clickByTextoBoton(driver, BOTON_ADJUNTAR, BOTON_TIPO_SUBMIT);

		System.out.println("Correcto.\n");

	}

	/**
	 * Desasocia un documento de un legajo. Es necesario que le legajo tenga al
	 * menos un documento, que es el que se a a desasociar. Es necesario
	 * encontrarse en la pantalla de detalle de legajo.
	 * 
	 * @param driver
	 * @param vo
	 * @param asiento
	 * @throws InterruptedException
	 */
	public static void delDocLegajo(WebDriver driver, VOLegajo vo) throws InterruptedException {

		System.out.println("Delete documento legajo" + vo.toString());
		// clic en boton eliminar doc-legajo
		UtilDriver.clickAnchor(driver, "data-href", ID_RELACION_LEGAJO_FICHEROBD);

		// clic en boton aceptar eliminacion
		UtilDriver.clickBoton(driver, BOTON_OK, null);

		System.out.println("Correcto.\n");

	}

	/**
	 * Visualiza un documento de un legajo. Es necesario que le legajo tenga al
	 * menos un documento asociado y estar situado en la pantalla de detalla del
	 * legajo Tras visualizarlo vuelve al detalle del legajo.
	 * 
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void visualizarDocLegajo(WebDriver driver, VOLegajo vo, VODocumento doc) throws InterruptedException {

		System.out.println("Visualizacion documento legajo." + vo.toString() + doc.toString());

		// UtilDriver.clickAnchor(driver,ATR_HREF, ID_FICHEROBD);
		UtilDriver.clickAnchor(driver, TITLE, PULSE_PARA_VER_EL_LEGAJO);

		// comprobamos que estamos en la pagina.
		// assertNotNull(driver.findElement(By.xpath("//input[@value='"+doc.getNombreFichero()+"']")));
		UtilDriver.clickBoton(driver, BOTON_CERRAR_VENTANA_MODADL, null);

		// volvemos a detalle del legajo.
		// UtilDriver.clickBoton(driver, BOTON_ATRAS, null);

		System.out.println("Correcto\n");
	}
	
	public static void modificaDescripcionDocLegajo(WebDriver driver, VOLegajo vo, VODocumento doc) throws InterruptedException {

		System.out.println("Actualizando descripcion documento legajo." + vo.toString() + doc.toString());

		// UtilDriver.clickAnchor(driver,ATR_HREF, ID_FICHEROBD);
		UtilDriver.clickAnchor(driver, TITLE, PULSE_PARA_EDITAR_EL_LEGAJO);

		UtilDriver.setCampoById(driver, "idDescripcionFicheroBD", " - ACTUALIZADO");

		UtilDriver.clickBoton(driver, "idBotonGuardarEdit", null);

		System.out.println("Correcto\n");
	}

	/**
	 * Desasocia un asiento del legajo. Es necesario que el legajo tenga
	 * asociado un asiento. Es necesario encontrarse en la pantalla de detalle
	 * de legajo.
	 * 
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void delAsientoLegajo(WebDriver driver, VOLegajo vo) throws InterruptedException {

		System.out.println("Delete relacion legajo-asiento-" + vo.toString());

		// ELIMINAR ASOCIACION
		UtilDriver.clickAnchor(driver, ATR_DATA_HREF, ID_REL_LEGAJO_ASIENTO);

		// CONFIRMAR BORRADO RELACION
		UtilWE.clickAnchor(UtilDriver.buscarById(driver, DIALOG_CONFIRM_DELETE_ASIENTO_LEGAJO, null, null), ATR_HREF,
				ID_REL_LEGAJO_ASIENTO);

		System.out.println("Correcto.\n");
	}
}
