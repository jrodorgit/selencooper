package net.rodor.testfuncooper.administracion;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPBasica;

public class OPDetalleUsuario extends OPBasica{
	
	public OPDetalleUsuario(WebDriver driver) {
		super(driver);
	}
	
	public static final String CAMPO_NIF = "nif";
	public static final String CAMPO_NOMBRE = "nombre";
	public static final String CAMPO_APELLIDO_1 = "apellido1";
	public static final String CAMPO_APELLIDO_2 = "apellido2";
	
	
	public static final String EVT_ACEPTAR = "aceptar";

}
