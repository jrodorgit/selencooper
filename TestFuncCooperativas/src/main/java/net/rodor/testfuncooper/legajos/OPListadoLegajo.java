package net.rodor.testfuncooper.legajos;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.UtilDriver;

public class OPListadoLegajo extends OPLegajosBase {

	private static final String TEXTO_ASIENTO = "textoAsiento";
	private static final String BOTON_BUSCAR = "buscar";
	private static final String NUMERO_INSCRIPCION = "numeroInscripcionFiltro";
	private static final String TABLA_LEGAJOS = "tablaLegajo";
	public static final String URL = "/busqueda/legajoSearchReload.htm";
	private static final String DESCRIPCION = "descripcion";
	
	public static void consultarLegajo(WebDriver driver,VOLegajo vo) throws InterruptedException{
		
		System.out.println("Busqueda de legajo-"+vo.toString());
		
		UtilDriver.goMenu(driver, OPLegajosBase.MENU,OPLegajosBase.SUB_MENU_LISTADO);
		
		//establacemos campos de busqueda.
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION, vo.getNumeroInscripcion());
		UtilDriver.setCampoById(driver, DESCRIPCION, vo.getDescripcion());
		UtilDriver.setCampoById(driver, TEXTO_ASIENTO, "exercitation");
		
		UtilDriver.clickBoton(driver, null, BOTON_BUSCAR);

		//ir al detalle del legajo si se ha encontrado.
		if( UtilDriver.exiteRegistroEnTabla(driver, TABLA_LEGAJOS, vo.getDescripcion()) ){
			UtilDriver.clickAnchor(driver, "href", "idLegajo");
			System.out.println("Correcto.\n");
		}else{
			System.out.println("!!!!!NOOOO  se encuentra el legajo!!!!!");	
		}

		
		
	}
	
	
}
