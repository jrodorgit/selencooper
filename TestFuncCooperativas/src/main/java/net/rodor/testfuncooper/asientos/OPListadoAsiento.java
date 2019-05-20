package net.rodor.testfuncooper.asientos;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.UtilDriver;
import static org.junit.Assert.*;

public class OPListadoAsiento  extends OPAsientosBase {
	
	private static final String ENLACE_CONSULTAR_ASIENTO = "idRegistroAsiento";
	private static final String ENLACE_BORRAR_ASIENTO = "RegistroAsientoDelete";
	public static final String URL = "asientoSearchLoad.htm";
	private static final String NUMERO_INSCRIPCION = "numeroInscripcion";
	private static final String NUMERO_ASIENTO = "numeroAsiento";
	private static final String BOTON_BUSCAR = "buscar";
	//private static final String TABLA_ASIENTOS = "tablaAsientoSearch";
	private static final String BOTON_OK = "botonOK";
	
	/**
	 * busca un asiento de cooperativa por numero asiento y lo consulta
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void consultarAsiento(WebDriver driver,VOAsiento vo) throws InterruptedException{

		System.out.println("Consulta de asiento-"+vo.toString());
		
		// buscamos asiento
		buscarAsiento( driver, vo);
		
		// click en ir a detale
		UtilDriver.clickAnchor(driver, ATR_HREF, ENLACE_CONSULTAR_ASIENTO);
		
		System.out.println("Correcto.\n");
		
		
	}
	
	/**
	 * Busca un asiento por numero de inscripcion de cooperativa y por numero de asiento y accede a su detalle.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void buscarAsiento(WebDriver driver,VOAsiento vo) throws InterruptedException{
		
		//UtilDriver.goMenu(driver, OPAsientosBase.MENU,OPAsientosBase.SUB_MENU_LISTADO);
		
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION,vo.getNumeroInscripcionCooper());
		UtilDriver.setCampoById(driver, NUMERO_ASIENTO,vo.getNumeroAsiento());
		
		UtilDriver.clickBoton( driver,null,  BOTON_BUSCAR );
		
		
	}
	
	/**
	 * Elimina un asiento de una cooperativa.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void eliminarAsiento(WebDriver driver,VOAsiento vo) throws InterruptedException{
		
		System.out.println("Delete asiento - "+vo.toString());
		
		// ir a detalle de asiento
		buscarAsiento( driver, vo);
		
		// clic en borrar asiento
		UtilDriver.clickAnchor(driver, ATR_DATA_HREF, ENLACE_BORRAR_ASIENTO);
		
		//confirmar borrado
		UtilDriver.clickBoton(driver, BOTON_OK, null);
		
		// comprobar mensaje de borrado correcto
		assertNotNull(UtilDriver.buscarById(driver, MSG_ALERT_SUCCESS,null,null));		
				
		System.out.println("Delete asiento correcto");
	}
}
