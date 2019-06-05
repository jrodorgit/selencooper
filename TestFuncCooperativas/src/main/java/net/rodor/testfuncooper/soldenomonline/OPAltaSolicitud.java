package net.rodor.testfuncooper.soldenomonline;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.OPBase;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.UtilWE;
import net.rodor.testfuncooper.legajos.OPLegajosBase;


public class OPAltaSolicitud extends OPBase{
	
	public static final String MENU = "Solicitud ";
	public static final String SUB_MENU_CERTIFICACION_DENOMINACION = "Certificación Denominación";
	public static final String SUB_MENU_CERTIFICACION_DENOMINACION_ALTA = "Alta Solicitud";
	
	@Test
	public static void alta(WebDriver driver, VOSolDenomOnline vo) throws InterruptedException, AWTException {
		
		System.out.println("Alta de Solicitud Denominacion on Line-" + vo.toString());
		UtilDriver.goMenuBis(driver, OPAltaSolicitud.MENU, OPAltaSolicitud.SUB_MENU_CERTIFICACION_DENOMINACION, OPAltaSolicitud.SUB_MENU_CERTIFICACION_DENOMINACION_ALTA);
		OPAccesoChrome.autenticacionPublica(driver);
		
		//Datos Solicitante.
		//UtilDriver.buscarById(driver, "activateDatosNotificacion",null,null).sendKeys(Keys.SPACE);;
		// provincia
		UtilDriver.clickSeleccionCombo(driver, "1","solicitudCreacionCertDenominacionPubFillFormDatosSolicitanteCommand.datosSolicitanteProvincia");
		//localidad
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosSolicitanteCommand.datosSolicitanteLocalidad", "Gasteiz");
		// tipo via
		//UtilDriver.clickSeleccionCombo(driver, "5","solicitudCreacionCertDenominacionPubFillFormDatosSolicitanteCommand.datosSolicitanteTipoVia");
		UtilWE.selectOption(UtilDriver.buscarById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosSolicitanteCommand.datosSolicitanteTipoVia", null, null),"5");
		// nombre
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosSolicitanteCommand.datosSolicitanteNombreVia", "del puerto");
		//numero
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosSolicitanteCommand.datosSolicitanteNumero", "89");
		//codigo postal
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosSolicitanteCommand.datosSolicitanteCodigoPostal", "01001");
		// telefono
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosSolicitanteCommand.datosSolicitanteTelefono", "666888999");
		//email
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosSolicitanteCommand.datosSolicitanteEmail", "fulanito@gmail.com");
		
		// siguiente
		UtilDriver.clickBoton(driver, null, null, " Siguiente");
		
		// denominaciones
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosDenominacionCommand.datosDenominacionDenominaciones0", "DENOMINACION AUTOMATICA 1");
		UtilDriver.clickBoton(driver, null, null, "");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosDenominacionCommand.datosDenominacionDenominaciones1", "DENOMINACION AUTOMATICA 2");
		
		// finalizar
		UtilDriver.clickBoton(driver, null, null, " Finalizar");
		
		// firmar solicitud
		UtilDriver.clickBoton(driver, "botonSignDocumento", null, null);
		OPAccesoChrome.firmarConCertificado(driver);
		UtilDriver.clickBoton(driver, "descargarJustificanteGEISER", null, null);
		UtilDriver.clickBoton(driver, "descargarSolicitud", null, null);
		
		
		
	}

}
