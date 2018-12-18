package net.rodor.testfuncooper.legajos;

import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.OPAccesoBase;
import net.rodor.testfuncooper.UtilDriver;

public class OPListadoLegajo extends OPLegajosBase {

	private static final String BOTON_BUSCAR = "buscar";
	private static final String NUMERO_REGISTRO = "numeroRegistro";
	private static final String FECHA_DESDE = "fechadDesde";
	private static final String NUMERO_INSCRIPCION = "numeroInscripcion";
	private static final String TABLA_LEGAJOS = "tablaLegajo";
	public static final String URL = "/busqueda/legajoSearchReload.htm";
	
	public static void buscarLegajo(WebDriver driver,VOLegajo vo) throws InterruptedException{
		
		UtilDriver.goURL(driver, OPAccesoBase.URL_PRIV+OPLegajosBase.URL+URL);
		
		//establacemos campos de busqueda.
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION, vo.getNumeroInscripcion());
		UtilDriver.setCampoById(driver, NUMERO_REGISTRO, vo.getNumeroRegistro());
		UtilDriver.setCampoById(driver, FECHA_DESDE, vo.getFechaCreacion());
		UtilDriver.clickBoton(driver, null, BOTON_BUSCAR);

		//ir al detalle del legajo si se ha encontrado.
		if( UtilDriver.exiteRegistroEntabla(driver, TABLA_LEGAJOS, vo.getNumeroRegistro()) ){
			UtilDriver.clickAnchor(driver, "href", "idLegajo");
			System.out.println("Busqueda de legajo correcta!");	
		}else{
			System.out.println("!!!!!NOOOO  se encuentra el legajo!!!!!");	
		}

		
		
	}
	/****
//driver.get(OPAccesoBase.URL_PRIV+OPLegajosBase.URL+URL);
		//Thread.sleep(2000);
		UtilDriver.goURL(driver, OPAccesoBase.URL_PRIV+OPLegajosBase.URL+URL);
		
		//WebElement elementoWeb = driver.findElement(By.id(NUMERO_INSCRIPCION));
		//elementoWeb.sendKeys(vo.getNumeroInscripcion());
		UtilDriver.setCampoById(driver, NUMERO_INSCRIPCION, vo.getNumeroInscripcion());
		
		//elementoWeb = driver.findElement(By.id(NUMERO_REGISTRO));
		//elementoWeb.sendKeys(vo.getNumeroRegistro());
		UtilDriver.setCampoById(driver, NUMERO_REGISTRO, vo.getNumeroRegistro());
		
		//elementoWeb = driver.findElement(By.name(BOTON_BUSCAR));
		//elementoWeb.click();
		//Thread.sleep(2000);
		UtilDriver.clickBoton(driver, null, BOTON_BUSCAR);

		//String result = driver.findElement(By.xpath(".//*[@id='tablaLegajo']//td[contains(.,'63263')]")).getText();
		//String result = driver.findElement(By.xpath(".//*[@id='"+TABLA_LEGAJOS+"']//td[contains(.,'"+vo.getNumeroRegistro()+"')]")).getText();
		//driver.findElement(By.xpath(".//a[contains(@href,'idLegajo')]")).click();
		if( UtilDriver.exiteRegistroEntabla(driver, TABLA_LEGAJOS, vo.getNumeroRegistro()) ){
			UtilDriver.clickAnchor(driver, "href", "idLegajo");
			System.out.println("Busqueda de legajo correcta!");	
		}else{
			System.out.println("!!!!!NOOOO  se encuentra el legajo!!!!!");	
		}

	 
	 
	 */
	
}
