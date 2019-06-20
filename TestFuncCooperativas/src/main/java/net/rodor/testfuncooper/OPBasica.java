package net.rodor.testfuncooper;

import org.openqa.selenium.WebDriver;

public class OPBasica {

	public static final String HREF= "href";
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
	public void setCampo(String idCampo, String valorCampo) throws InterruptedException {
		UtilDriver.setCampoById(driver, idCampo, valorCampo);
	}
	public void goEnlace(String idEnlace) throws InterruptedException {
		UtilDriver.clickAnchor(driver, HREF, idEnlace);
	}
	public void clickCheckBox(String texto) throws InterruptedException{
		UtilDriver.clickCheckBox(driver, "checkbox", texto);
	}
}
