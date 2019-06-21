package net.rodor.testfuncooper.test.regresion.cooperativas;

import static org.junit.Assert.assertNotNull;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.cooperativas.OPDetalleCooperativa;
import net.rodor.testfuncooper.cooperativas.OPListadoCooperativas;
import net.rodor.testfuncooper.cooperativas.VOCooperativa;
import net.rodor.testfuncooper.menu.OPMenu;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestRegresionCooperativasConsulta extends TestRegresionBase {

	
	VOCooperativa cooper = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionCooperativasConsulta....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/cooperativas/data_set_cooperativa_sp_config.xml");
		cooper = (VOCooperativa) context.getBean("cooperativa");
		
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
		
	}
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestRegresionCooperativasConsulta....\n");
		// acceso a intranet - menu busqueda expedientes
		UtilDriver.goMenu(driver, OPMenu.MENU_COOPERATIVAS, OPMenu.MENU_COOPERATIVAS_LISTADO);
		
		// consultar cooperativa
		OPListadoCooperativas listado = new OPListadoCooperativas(driver);
		listado.setCampo(OPListadoCooperativas.CAMPO_NUMERO_INSCRIPCION, cooper.getNumIns());
		listado.runEvt(OPListadoCooperativas.EVT_BUSCAR);
		listado.goEnlace(OPListadoCooperativas.EVT_CONSULTAR);
		
		// vemos que en el detalle esta bien la razon social
		OPDetalleCooperativa detalle = new OPDetalleCooperativa(driver);
		assertNotNull(UtilDriver.buscarTexto(driver,"strong", cooper.getRazonSocial()));
		
		// volvemos del detalle
		detalle.runEvt(OPDetalleCooperativa.EVT_VOLVER);
		
		System.out.println("Fin TestRegresionCooperativasConsulta\n");
		
		
	}
}
