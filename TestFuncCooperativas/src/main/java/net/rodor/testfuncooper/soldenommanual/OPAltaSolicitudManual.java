package net.rodor.testfuncooper.soldenommanual;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPBase;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.soldenomonline.VOSolDenomOnline;

public class OPAltaSolicitudManual extends OPBase{
	
	public static final String MENU = "Solicitud ";
	public static final String SUB_MENU_CERTIFICACION_DENOMINACION = "Certificación Denominación";
	public static final String SUB_MENU_CERTIFICACION_DENOMINACION_ALTA = "Alta manual de Solicitud de Denominación";
	
	@Test
	public static void alta(WebDriver driver, VOSolDenomOnline vo) throws InterruptedException, AWTException {
		
		System.out.println("Alta de Solicitud Denominacion Manual - " + vo.toString());
		
		UtilDriver.goMenuBis(driver, OPAltaSolicitudManual.MENU, OPAltaSolicitudManual.SUB_MENU_CERTIFICACION_DENOMINACION, OPAltaSolicitudManual.SUB_MENU_CERTIFICACION_DENOMINACION_ALTA);
		
		//Datos generales.
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPrivFillFormDatosGeneralesCommand.datosGeneralesNumeroRegistro", "125478");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPrivFillFormDatosGeneralesCommand.datosGeneralesFechaRecepcion", "05/06/2019");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPrivFillFormDatosGeneralesCommand.datosGeneralesFechaSolicitud", "05/06/2019");
		
		// siguiente
		UtilDriver.clickBoton(driver, null, null, " Siguiente");

		//Datos Solicitante
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPrivFillFormDatosSolicitanteCommand.datosSolicitanteRazonSocialNombre", "Fulanito el de Los Palotes");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPrivFillFormDatosSolicitanteCommand.datosSolicitanteNif", "12345678Z");
		
		// siguiente
		UtilDriver.clickBoton(driver, null, null, " Siguiente");
		
		//Denominaciones
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPrivFillFormDatosDenominacionCommand.datosDenominacionDenominaciones0", vo.getDenominacionUno());
		UtilDriver.clickBoton(driver, null, null, "");
		UtilDriver.setCampoById(driver, "solicitudCreacionCertDenominacionPrivFillFormDatosDenominacionCommand.datosDenominacionDenominaciones1", vo.getDenominacionDos());
		
		// finalizar
		UtilDriver.clickBoton(driver, null, null, " Finalizar");
	}

}
