package net.rodor.testfuncooper.test.regresion.denominacion.denoms;

import static org.junit.Assert.assertNotNull;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.denominaciones.OPListadoDenominaciones;
import net.rodor.testfuncooper.denominaciones.VODenominacion;
import net.rodor.testfuncooper.menu.OPMenu;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionDenominaciones extends TestRegresionBase {

	
	VODenominacion denominacionReservada = null;
	VODenominacion denominacionInscrita = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionDenominaciones....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/denominacion/denoms/data_set_denominacion_sp_config.xml");
		
		denominacionReservada = (VODenominacion) context.getBean("denominacionReservada");
		denominacionInscrita = (VODenominacion) context.getBean("denominacionInscrita");
		
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
		
	}
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionDenominaciones....\n");
		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_DENOMINACION, OPMenu.MENU_DENOMINACIONES_DENOMS);
		
		// consultar denominacion reservada por nombre
		OPListadoDenominaciones listado = new OPListadoDenominaciones(driver);
		listado.setCampo(OPListadoDenominaciones.CAMPO_RAZON_SOCIAL, "%"+denominacionReservada.getRazonSocial().substring(0, 10) + "%");
		listado.runEvt(OPListadoDenominaciones.EVT_BUSCAR);
		assertNotNull(UtilDriver.buscarTexto(driver,"td", denominacionReservada.getNumInfor()));
		
		// consultar denominacion inscrita por numero inscripcion
		listado.setCampo(OPListadoDenominaciones.CAMPO_NUMERO_INSCRIPCION,denominacionInscrita.getNumIns());
		listado.runEvt(OPListadoDenominaciones.EVT_BUSCAR);
		assertNotNull(UtilDriver.buscarTexto(driver,"td", denominacionInscrita.getRazonSocial()));
		listado.goEnlaceByOnClick(OPListadoDenominaciones.EVT_CONSULTAR);
		
		listado.clickBotonVisibleByText(OPListadoDenominaciones.EVT_CERRAR);
		
		System.out.println("Fin TestRegresionDenominaciones\n");
		
		
	}
}
