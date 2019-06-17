package net.rodor.testfuncooper;

import java.awt.AWTException;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.menu.OPMenu;
import net.rodor.testfuncooper.soldeno.VOSolDenomOnline;
import net.rodor.testfuncooper.soldenommanual.OPAltaSolicitudManual;

public class TestRegresionGestionCertDenom {

	
	private  UtilServiceImpl serv;
	VOSolDenomOnline soldenom = null;
	WebDriver driver = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionGestionCertDenom....\n");
		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");

		serv = contextEnv.getBean(UtilServiceImpl.class);
		
		ApplicationContext contextEnvBis = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");
		
		Env env = (Env) contextEnvBis.getBean("env");
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
		System.out.println("----------------------------\n");
	}
	@After
	public void finaliza(){
		System.out.println("Finalizacion \n");
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando Test Regresion Gestion Certificado Denominacion....\n");

		// obtenemos la solicitud de denominacion para la que vamos a generar certificado negativo.
		soldenom = serv.getUltimaSolDenominacion();
		
		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_DENOMINACION, OPMenu.MENU_DENOMINACION_BUSQ_EXPEDIENTES);
		
		// buscar expediente de solicitud
		UtilDriver.setCampoById(driver, "numExpediente", soldenom.getNumexpediente());
		UtilDriver.clickBoton(driver, "botonSearch", null, null);
		
		//ir detalle de expediente
		UtilDriver.clickAnchor(driver, "href", "idExpediente");
		
		// anadimos observaciones al expediente
		UtilDriver.setCampoById(driver, "observacionExpediente", "Obsevaciones automaticas al expediente:"+soldenom.getNumexpediente());
		UtilDriver.clickByTextoBoton(driver, "dir", "button");
		
		// ir al denominacion para generar certificado negativo.
		UtilDriver.clickAnchor(driver, "href", "idDenominacion");
		
		// buscamos una denominacion para ver si exite
		UtilDriver.clearCampoById(driver, "textoBuscar");
		UtilDriver.setCampoById(driver, "textoBuscar", "BERGANTIÑOS");
		UtilDriver.clickByTextoBoton(driver, "Buscar", "submit");
		
		// accedemos al detalle de denominacion y lo cerramos
		UtilDriver.clickAnchor(driver, "onclick", "5848");
		UtilDriver.clickByTextoClassBoton(driver,"Cerrar","btn btn-sm btn-default");
		
		// generamos certificado negativo por tiempo de reserva por defecto.
		UtilDriver.clickByTextoBoton(driver,"Negativo","button");
		UtilDriver.clickByTextoBoton(driver,"Aceptar","button");
		
		
		
		
		System.out.println("Fin Test Regresion Gestion Certificado Denominacion\n"+ soldenom.toString());
	}
	
}
