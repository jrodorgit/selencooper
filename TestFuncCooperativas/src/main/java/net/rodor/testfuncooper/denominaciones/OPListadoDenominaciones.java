package net.rodor.testfuncooper.denominaciones;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPBasica;

public class OPListadoDenominaciones extends OPBasica {

	public OPListadoDenominaciones(WebDriver driver) {
		super(driver);
	}

	public static final String CAMPO_RAZON_SOCIAL = "textoBuscar";
	public static final String CAMPO_NUMERO_INFORMATICO = "numeroInformatico";
	public static final String CAMPO_NUMERO_INSCRIPCION = "numeroRegistro";


	public static final String EVT_BUSCAR = "botonSearch";
	public static final String EVT_CERRAR = "Cerrar";
	public static final String EVT_CONSULTAR = "loadDetalleDenominacion";

}
