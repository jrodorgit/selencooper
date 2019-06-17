package net.rodor.testfuncooper.soldenomonline;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.OPBase;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.UtilWE;
import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;


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
		UtilDriver.clickByClassName(driver,"checkbox-meyss-item-icon glyphicon glyphicon-ok");
		/***/
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
		
		// destinatario
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionDestinatario", "MENGANITO PEREZ");
		UtilWE.selectOption(UtilDriver.buscarById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionTipoVia", null, null),"4");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionNombreVia", "esto es otra calle");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionNumero", "34");
		UtilWE.selectOption(UtilDriver.buscarById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionProvincia", null, null),"1");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionLocalidad", "Vitoria");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionCodigoPostal", "01002");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionTelefono", "777888444");
		
		// siguiente
		UtilDriver.clickBoton(driver, null, null, " Siguiente");
		
		
		/***/
		// denominaciones
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosDenominacionCommand.datosDenominacionDenominaciones0", vo.getDenominacionUno());
		UtilDriver.clickBoton(driver, null, null, "");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosDenominacionCommand.datosDenominacionDenominaciones1", vo.getDenominacionDos());
		
		// finalizar
		UtilDriver.clickBoton(driver, null, null, " Finalizar");
		
		// firmar solicitud
		UtilDriver.clickBoton(driver, "botonSignDocumento", null, null);
		OPAccesoChrome.firmarConCertificado(driver);
		UtilDriver.clickBoton(driver, "descargarJustificanteGEISER", null, null);
		UtilDriver.clickBoton(driver, "descargarSolicitud", null, null);
		/***/
		
		
	}
	
	@Test
	public static void altaProrroga(WebDriver driver, VOSolDenomOnline vo) throws InterruptedException, AWTException {
		
		System.out.println("Alta de Solicitud Prorroga Denominacion on Line-" + vo.toString());
		UtilDriver.goMenuBis(driver, OPAltaSolicitud.MENU, OPAltaSolicitud.SUB_MENU_CERTIFICACION_DENOMINACION, OPAltaSolicitud.SUB_MENU_CERTIFICACION_DENOMINACION_ALTA);
		OPAccesoChrome.autenticacionPublica(driver);
		
		//Datos Solicitante.
		UtilDriver.clickByClassName(driver,"checkbox-meyss-item-icon glyphicon glyphicon-ok");
		/***/
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
		
		// destinatario
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionDestinatario", "MENGANITO PEREZ");
		UtilWE.selectOption(UtilDriver.buscarById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionTipoVia", null, null),"4");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionNombreVia", "esto es otra calle");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionNumero", "34");
		UtilWE.selectOption(UtilDriver.buscarById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionProvincia", null, null),"1");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionLocalidad", "Vitoria");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionCodigoPostal", "01002");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPubFillFormDatosNotificacionSolicitudCommand.notificacionTelefono", "777888444");
		
		// siguiente
		UtilDriver.clickBoton(driver, null, null, " Siguiente");
		
		
		/***/
		// prorroga
		UtilDriver.clickByText(driver,"Prórroga");
		UtilDriver.setCampoById(driver, "datosDenominacionNumLocalizadorProrroga", vo.getNumLocalizador());
		UtilDriver.setCampoById(driver, "datosDenominacionTextoLocalizadorProrroga", vo.getDescLocalizador());
		
		// finalizar
		UtilDriver.clickBoton(driver, null, null, " Finalizar");
		
		// firmar solicitud
		UtilDriver.clickBoton(driver, "botonSignDocumento", null, null);
		OPAccesoChrome.firmarConCertificado(driver);
		UtilDriver.clickBoton(driver, "descargarJustificanteGEISER", null, null);
		UtilDriver.clickBoton(driver, "descargarSolicitud", null, null);
		/***/
		
		
	}

}
