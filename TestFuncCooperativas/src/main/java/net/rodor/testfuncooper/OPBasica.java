package net.rodor.testfuncooper;

import org.openqa.selenium.WebDriver;

public class OPBasica {

	public static final String HREF= "href";
	public static final String TITLE= "title";
	public static final String ONCLICK= "onclick";
	
	public WebDriver driver = null;

	public OPBasica(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void runEvt(String idEvt) throws InterruptedException {
		UtilDriver.clickBoton(driver, idEvt, null);
	}
	public void runEvtByName(String evtName) throws InterruptedException {
		UtilDriver.clickBoton(driver, null, evtName);
	}
	public void runEvtByTexto(String evtTexto) throws InterruptedException {
		UtilDriver.clickBoton(driver, null, null,evtTexto);
	}
	public void setCampo(String idCampo, String valorCampo) throws InterruptedException {
		UtilDriver.setCampoById(driver, idCampo, valorCampo);
	}
	public void goEnlace(String idEnlace) throws InterruptedException {
		UtilDriver.clickAnchor(driver, HREF, idEnlace);
	}
	public void goEnlaceByOnClick(String texto) throws InterruptedException {
		UtilDriver.clickAnchor(driver, ONCLICK, texto);
	}
	public void clickCheckBox(String texto) throws InterruptedException{
		UtilDriver.clickCheckBox(driver, "checkbox", texto);
	}
}
