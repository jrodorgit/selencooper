package net.rodor.testfuncooper.test.regresion.administracion;

import java.awt.AWTException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.OPAccesoChrome;
import net.rodor.testfuncooper.UtilDriver;
import net.rodor.testfuncooper.administracion.OPDetalleUsuario;
import net.rodor.testfuncooper.administracion.OPListadoUsuarios;
import net.rodor.testfuncooper.administracion.VOUsuario;
import net.rodor.testfuncooper.menu.OPMenu;
import net.rodor.testfuncooper.test.regresion.TestRegresionBase;

public class TestCrearUsuario extends TestRegresionBase {

	VOUsuario usuario = null;
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando TestCrearUsuario....\n");
		
		// acceso a intranet - menu administracion > usuarios
		UtilDriver.goMenu(driver, OPMenu.MENU_ADMINISTRACION, OPMenu.MENU_ADMINISTRACION_USUARIOS);

		// vamos a crear usuario
		OPListadoUsuarios listadoUsu = new OPListadoUsuarios(driver);
		listadoUsu.runEvt(OPListadoUsuarios.EVT_NUEVO_USUARIO);
		
		// rellenamos formulario
		OPDetalleUsuario detalle = new OPDetalleUsuario(driver);
		detalle.setCampo(OPDetalleUsuario.CAMPO_NIF, usuario.getNif());
		detalle.setCampo(OPDetalleUsuario.CAMPO_NOMBRE, usuario.getNombre());
		detalle.setCampo(OPDetalleUsuario.CAMPO_APELLIDO_1, usuario.getApel1());
		detalle.setCampo(OPDetalleUsuario.CAMPO_APELLIDO_2, usuario.getApel2());
		// modificar
		usuario.setRoles(new String[]{"7"});
		detalle.clickCheckBox("7");
		//Aceptar
		detalle.runEvtByName(OPDetalleUsuario.EVT_ACEPTAR);
		
		
		System.out.println("Fin TestCrearUsuario\n");
	}
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestCrearUsuario....\n");
		
		inicializaEntorno();
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/administracion/data_set_admin_sp_config.xml");
		usuario = (VOUsuario) context.getBean("usuario");
		
		
		driver = OPAccesoChrome.autenticacion(env.getProps().get("URL_PRIV"));
		
		
	}
	@After
	public void finaliza(){
		finalizaEntorno();
	}
	
	
}
