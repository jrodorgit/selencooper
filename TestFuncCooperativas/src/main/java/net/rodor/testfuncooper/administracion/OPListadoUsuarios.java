package net.rodor.testfuncooper.administracion;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPBasica;

public class OPListadoUsuarios extends OPBasica{
	
	public OPListadoUsuarios(WebDriver driver) {
		super(driver);
	}

	public static final String EVT_NUEVO_USUARIO = "botonAdd";
}
