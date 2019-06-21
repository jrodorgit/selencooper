package net.rodor.testfuncooper.cooperativas;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPBasica;


public class OPListadoCooperativas extends OPBasica {

	public OPListadoCooperativas(WebDriver driver) {
		super(driver);
	}

	public static final String CAMPO_NUMERO_INSCRIPCION = "idNumeroInscripcion";
	public static final String CAMPO_NUMERO_INFORMATICO = "idNumeroInformatico";
	public static final String CAMPO_RAZON_SOCIAL = "idRazonSocial";

	public static final String EVT_LIMPIAR_FILTRO = "idBotonLimpiarFiltro";
	public static final String EVT_BUSCAR = "idBotonBuscar";
	public static final String EVT_CONSULTAR = "idCooperativa";

}
