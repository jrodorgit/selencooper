package net.rodor.testfuncooper.legajos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.rodor.testfuncooper.OPAccesoBase;

public class OPBusquedaLegajo extends OPLegajosBase {

	private static final String BOTON_BUSCAR = "buscar";
	private static final String NUMERO_REGISTRO = "numeroRegistro";
	private static final String NUMERO_INSCRIPCION = "numeroInscripcion";
	private static final String TABLA_LEGAJOS = "tablaLegajo";
	public static final String URL = "/busqueda/legajoSearchReload.htm";
	
	public static void buscarLegajo(WebDriver driver,VOLegajo vo) throws InterruptedException{
		driver.get(OPAccesoBase.URL_PRIV+OPLegajosBase.URL+URL);
		Thread.sleep(2000);
		
		WebElement elementoWeb = driver.findElement(By.id(NUMERO_INSCRIPCION));
		elementoWeb.sendKeys(vo.getNumeroInscripcion());
		
		elementoWeb = driver.findElement(By.id(NUMERO_REGISTRO));
		elementoWeb.sendKeys(vo.getNumeroRegistro());
		
		elementoWeb = driver.findElement(By.name(BOTON_BUSCAR));
		elementoWeb.click();
		Thread.sleep(2000);

		//String result = driver.findElement(By.xpath(".//*[@id='tablaLegajo']//td[contains(.,'63263')]")).getText();
		String result = driver.findElement(By.xpath(".//*[@id='"+TABLA_LEGAJOS+"']//td[contains(.,'"+vo.getNumeroRegistro()+"')]")).getText();
		driver.findElement(By.xpath(".//a[contains(@href,'idLegajo')]")).click();

		System.out.println("Busqueda de legajo correcta:"+result);
		
	}
	
}
