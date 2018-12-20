package net.rodor.testfuncooper.asientos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OPRelacionAsientos extends OPAsientosBase {

	private static final String BOTON_ADD_RELACION = "botonAnnadirRegistroAsiento";
	public final static String BOTON_RELACION = " Relación";
	public final static String BOTON_ACEPTAR_REL = "Aceptar";
	public final static String BOTON_CERRAR_VENTANA_OK = "close closeCorrect";
	public final static String BOTON_VOLVER = "Volver";
	
	private static final String NUMERO_ASIENTO = "numeroAsiento";
	private static final String OBS_RELACION = "observacionesRelacionAsientos";
	private static final String BOTON_SEARCH = "botonSearch";
	private static final String TABLA_ASIENTOS_NO_ASOCIADOS = "tablaAsientoNoRelacionado";
	private static final String CHECKBOX_SELECCION_MASIVA = "seleccionarTodos";
	/**
	 * Relaciona los asientos A y B para la cooperativa. Es necesario haber buscado el asiento A y acceder a su consulta.
	 * @param driver
	 * @param asientoA
	 * @param asientoB
	 * @throws InterruptedException 
	 */
	public static void addRelacionAsientos(WebDriver driver,VOAsiento asientoA, VOAsiento asientoB, String textoRelacion) throws InterruptedException{
		
		System.out.println("Alta de relacion entre asientos A"+ asientoA.toString());
		System.out.println("y B"+ asientoB.toString());
		
		//clic en +Relacion
		driver.findElement(By.xpath("//button[text()='"+ BOTON_RELACION + "']")).click();
		Thread.sleep(2000);
		
		// buscar asiento B
		WebElement elementoWeb = driver.findElement(By.id(NUMERO_ASIENTO));
		elementoWeb.sendKeys(asientoB.getNumeroAsiento());
		
		driver.findElement(By.id(BOTON_SEARCH)).click();
		Thread.sleep(3000);
		
		
		// seleccionar asientoB deseado del lsitado de no relacionados
		elementoWeb = driver.findElement(By.id(TABLA_ASIENTOS_NO_ASOCIADOS));
		elementoWeb.findElement(By.id(CHECKBOX_SELECCION_MASIVA)).click();
		
		//click en agregar asiento
		driver.findElement(By.id(BOTON_ADD_RELACION)).click();
		Thread.sleep(2000);
		
		// rellenar observaciones a la relacion
		elementoWeb = driver.findElement(By.id(OBS_RELACION));
		elementoWeb.sendKeys(textoRelacion);
		Thread.sleep(1000);
		
		// click en aceptar observacion
		driver.findElement(By.xpath("//button[text()='"+BOTON_ACEPTAR_REL+"']")).click();
		Thread.sleep(3000);
		
		// cerrar pantalla de aviso de relacion alta correcta.
		driver.findElement(By.xpath("//button[@class='"+BOTON_CERRAR_VENTANA_OK+"']")).click();
		Thread.sleep(2000);
		
		//volver a detalle de Asiento
		driver.findElement(By.xpath("//button[contains(.,'"+BOTON_VOLVER+"')]")).click();
		
		Thread.sleep(3000);
		
		System.out.println("Alta de relacion entre asientos correcta");
		
	}
	
	
}
