package net.rodor.testfuncooper.test.regresion.denominacion.certs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

/** 
 * Cuando un certificado ha sido enviado a firma, este puede ser recuperado para cambiarlo siempre
 * y cuando no haya sido ya firmado.
 * 
 * @author 52535465S
 *
 */
public class TestRegresionRecuperarCertificado extends TestRegresionBase {

	VOCertificado certificadoRecuperar = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionRecuperarCertificado....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/denominacion/certs/data_set_certificados_sp_config.xml");
		
		certificadoRecuperar = (VOCertificado) context.getBean("certificadoRecuperar");
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
		
	}
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionRecuperarCertificado....\n");

		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_DENOMINACION, OPMenu.MENU_DENOMINACIONES_CERTS);
		
		// recuperar certificado pendiente de firmar.
		OPListadoCertificados listado = new OPListadoCertificados(driver);
		listado.setCampo(OPListadoCertificados.CAMPO_RAZON_SOCIAL, "%"+certificadoRecuperar.getRazonSocial() + "%");
		listado.runEvt(OPListadoCertificados.EVT_BUSCAR);
		listado.goEnlaceDataHref(OPListadoCertificados.EVT_RECUPERAR_CERT);
		listado.runEvt(OPListadoCertificados.EVT_RECUPERAR_CERT_SI);
		
		assertTrue(true);
		System.out.println("Fin TestRegresionRecuperarCertificado\n");
		
		
	}
}
