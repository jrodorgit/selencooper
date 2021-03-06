package net.rodor.testfuncooper;

import org.openqa.selenium.WebDriver;

public class OPBasica {

	public static final String HREF= "href";
	public static final String DATA_HREF= "data-href";
	public static final String TITLE= "title";
	public static final String ONCLICK= "onclick";
	public static final String DIV = "div";
	public static final String TD = "td";
	
	
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
	public void cleanAndSetCampo(String idCampo, String valorCampo) throws InterruptedException {
		UtilDriver.cleanAndSetCampoById(driver, idCampo, valorCampo);
	}
	
	public void goEnlace(String idEnlace) throws InterruptedException {
		UtilDriver.clickAnchor(driver, HREF, idEnlace);
	}
	public void goEnlaceDataHref(String idEnlace) throws InterruptedException {
		UtilDriver.clickAnchor(driver, DATA_HREF, idEnlace);
	}
	public void goEnlaceByOnClick(String texto) throws InterruptedException {
		UtilDriver.clickAnchor(driver, ONCLICK, texto);
	}
	public void clickCheckBox(String texto) throws InterruptedException{
		UtilDriver.clickCheckBox(driver, "checkbox", texto);
	}
	public void clickBotonVisibleByText(String texto) throws InterruptedException{
		UtilDriver.clickBotonVisibleByText(driver, texto);
	}
}
