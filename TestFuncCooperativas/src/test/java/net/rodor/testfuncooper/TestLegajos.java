package net.rodor.testfuncooper;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.rodor.testfuncooper.asientos.VOAsiento;
import net.rodor.testfuncooper.legajos.OPAltaLegajo;
import net.rodor.testfuncooper.legajos.OPBusquedaLegajo;
import net.rodor.testfuncooper.legajos.OPLegajoAsiento;
import net.rodor.testfuncooper.legajos.OPModificarLegajo;
import net.rodor.testfuncooper.legajos.VODocumento;
import net.rodor.testfuncooper.legajos.VOLegajo;

public class TestLegajos {

	@Test
	public void test() throws InterruptedException, AWTException {
		
		System.out.println("Test Legajos e entorno:" +OPAccesoBase.URL_LOGIN_PRIV);
		WebDriver driver = OPAccesoChrome.autenticacion(OPAccesoBase.URL_LOGIN_PRIV);
		
		// preparando legajo con el que trabajaremos.
		VOLegajo legajo = new VOLegajo("001","A10023","exp-001-1023-023");
		VODocumento doc = new VODocumento("C:\\Java\\","AngularJSCheatSheet.pdf");
		VOAsiento asiento = new VOAsiento("010", "001");
		
		
		// alta de legajo
		OPAltaLegajo.alta(driver,legajo);
		
		//busqueda
		OPBusquedaLegajo.buscarLegajo(driver,legajo);
		
		//modificacion del expediente de legajo
		OPModificarLegajo.modificarLegajo(driver,legajo);
		
		// add documento a legajo
		OPModificarLegajo.addDocALegajo(driver,legajo, doc);
		
		// visualizacion del documento
		OPModificarLegajo.visualizarDocLegajo(driver, legajo, doc);
		
		// del documento legajo
		OPModificarLegajo.delDocLegajo(driver,legajo);
		
		// anadimos relacion con asiento
		OPLegajoAsiento.addAsientoALegajo(driver, legajo,asiento);
		
		// borramos la relacion legajo-asiento
		OPModificarLegajo.delAsientoLegajo(driver, legajo);
		
		driver.close();
		
		assertTrue(true);
	}

	
	/*// driver navegador
	System.setProperty("webdriver.chrome.driver", "C:\\Java\\chromedriver.exe");
	//System.setProperty("webdriver.ie.driver", "C:\\Java\\IEDriverServer.exe");
	//System.setProperty("webdriver.edge.driver", "C:\\Java\\MicrosoftWebDriver.exe");
	
	
	WebDriver driver = new ChromeDriver();
	//WebDriver driver = new InternetExplorerDriver();
	//WebDriver driver = new EdgeDriver();
	

	// url cooperativas
	driver.get("https://localhost/cooperativas/priv/login.htm");
	Thread.sleep(3000);
	
	WebElement searchBox = driver.findElement(By.id("botonEntrarCertificado"));
	searchBox.click();
	Thread.sleep(10000);
	
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_TAB);
	robot.delay(1000);
	robot.keyPress(KeyEvent.VK_TAB);
	robot.delay(1000);
	robot.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(10000);
	robot.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
	robot.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
	//driver.switchTo().activeElement().click();
	//driver.switchTo().activeElement().sendKeys(Keys.TAB);
	//driver.switchTo().activeElement().sendKeys(Keys.ENTER);
*/	
}
