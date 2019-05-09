package net.rodor.testfuncooper.soldenomonline;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPBase;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.legajos.OPLegajosBase;


public class OPAltaSolicitud extends OPBase{
	
	public static final String MENU = "Solicitud ";
	public static final String SUB_MENU_CERTIFICACION_DENOMINACION = "Certificación Denominación";
	public static final String SUB_MENU_CERTIFICACION_DENOMINACION_ALTA = "Alta Solicitud";
	
	@Test
	public static void alta(WebDriver driver, VOSolDenomOnline vo) throws InterruptedException {
		
		System.out.println("Alta de Solicitud Denominacion on Line-" + vo.toString());
		UtilDriver.goMenuBis(driver, OPAltaSolicitud.MENU, OPAltaSolicitud.SUB_MENU_CERTIFICACION_DENOMINACION, OPAltaSolicitud.SUB_MENU_CERTIFICACION_DENOMINACION_ALTA);
		
		
	}

}
