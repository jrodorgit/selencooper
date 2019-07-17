package net.rodor.testfuncooper.denominaciones;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPBasica;

public class OPListadoCertificados extends OPBasica {

	public OPListadoCertificados(WebDriver driver) {
		super(driver);
	}

	public static final String CAMPO_RAZON_SOCIAL = "textoBuscar";
	

	public static final String EVT_BUSCAR = "botonSearch";
	public static final String EVT_CONSULTAR_CERT = "idCertificado";
	public static final String EVT_RECUPERAR_CERT = "DeletePendienteFirma.htm?idDenominacion";
	public static final String EVT_RECUPERAR_CERT_SI = "botonOK";
	public static final String EVT_VOLVER = "botonAtras";

}
