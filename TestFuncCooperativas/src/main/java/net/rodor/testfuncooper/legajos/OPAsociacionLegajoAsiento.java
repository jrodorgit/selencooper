package net.rodor.testfuncooper.legajos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.rodor.testfuncooper.asientos.VOAsiento;

public class OPAsociacionLegajoAsiento {
	
	private static final String TABLA_ASIENTOS_LEGAJOS_ASOCIADOS = "tablaAsientosLegajosAsociados_wrapper";
	private static final String CHECKBOX_SELECCION_MASIVA = "checkboxSeleccionMasiva";
	private static final String TABLA_ASIENTOS_LEGAJOS_NO_ASOCIADOS = "tablaAsientosLegajosNoAsociados";
	private static final String BOTON_SEARCH = "botonSearch";
	private static final String NUMERO_ASIENTO = "numeroAsiento";
	private static final String BOTON_AGREGAR_RELACION = "agregar";
	private static final String BOTON_ATRAS = "botonAtras";

	/**
	 * Relacion un legajo con un asiento. Es necesario que exista el asiento y haber ejecutado la prueba de busqueda de legajo para situar ahi la prueba.
	 * @param driver
	 * @param vo
	 * @throws InterruptedException
	 */
	public static void addAsientoALegajo(WebDriver driver,VOLegajo vo, VOAsiento asiento) throws InterruptedException{
		
		//clic en +Relacion
		driver.findElement(By.name(BOTON_AGREGAR_RELACION)).click();
		Thread.sleep(3000);
		
		// buscar asiento para asociar.
		WebElement elementoWeb = driver.findElement(By.id(NUMERO_ASIENTO));
		elementoWeb.sendKeys(asiento.getNumeroAsiento());
		
		driver.findElement(By.id(BOTON_SEARCH)).click();
		Thread.sleep(3000);
		
		// seleccionar asiento deseado del lsitado de no relacionados
		elementoWeb = driver.findElement(By.id(TABLA_ASIENTOS_LEGAJOS_NO_ASOCIADOS));
		elementoWeb.findElement(By.className(CHECKBOX_SELECCION_MASIVA)).click();

		//click en agregar asiento
		driver.findElement(By.name(BOTON_AGREGAR_RELACION)).click();
		Thread.sleep(2000);
		
		//comprobamos que esta dadao de alta la asociacion
		elementoWeb = driver.findElement(By.id(TABLA_ASIENTOS_LEGAJOS_ASOCIADOS));
		elementoWeb.findElement(By.xpath("//td[contains(.,'"+asiento.getNumeroAsiento()+"')]"));
		
		Thread.sleep(1000);
		
		//volvemos a detalle legajo
		driver.findElement(By.id(BOTON_ATRAS)).click();
		Thread.sleep(2000);
		System.out.println("Relacion asiento-legajo correcto");		
		
	}
}
