package net.rodor.testfuncooper.test.regresion.denominacion.certs;

import static org.junit.Assert.assertNotNull;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.denominaciones.OPListadoCertificados;
import net.rodor.testfuncooper.denominaciones.VOCertificado;
import net.rodor.testfuncooper.menu.OPMenu;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionCertificados extends TestRegresionBase {

	
	VOCertificado certificadoNegativo = null;
	VOCertificado certificadoRecuperar = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionCertificados....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/denominacion/certs/data_set_certificados_sp_config.xml");
		
		certificadoNegativo = (VOCertificado) context.getBean("certificadoNegativo");
		certificadoRecuperar = (VOCertificado) context.getBean("certificadoRecuperar");
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
		
	}
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionCertificados....\n");
		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_DENOMINACION, OPMenu.MENU_DENOMINACIONES_CERTS);
		
		// consultar certificado por nombre
		OPListadoCertificados listado = new OPListadoCertificados(driver);
		listado.setCampo(OPListadoCertificados.CAMPO_RAZON_SOCIAL, "%"+certificadoNegativo.getRazonSocial() + "%");
		listado.runEvt(OPListadoCertificados.EVT_BUSCAR);
		assertNotNull(UtilDriver.buscarTexto(driver,"td", "CERT. NEGATIVO"));
		
		//consultar el certificado negativo ya firmado.
		listado.goEnlace(OPListadoCertificados.EVT_CONSULTAR_CERT);
		assertNotNull(UtilDriver.buscarTexto(driver,"div", "Datos del Documento"));
		listado.runEvt(OPListadoCertificados.EVT_VOLVER);
		
		// recuperar certificado pendiente de firmar.
		listado.cleanAndSetCampo(OPListadoCertificados.CAMPO_RAZON_SOCIAL, "%"+certificadoRecuperar.getRazonSocial() + "%");
		listado.runEvt(OPListadoCertificados.EVT_BUSCAR);
		listado.goEnlaceDataHref(OPListadoCertificados.EVT_RECUPERAR_CERT);
		listado.runEvt(OPListadoCertificados.EVT_RECUPERAR_CERT_SI);
		
		
		System.out.println("Fin TestRegresionCertificados\n");
		
		
	}
}