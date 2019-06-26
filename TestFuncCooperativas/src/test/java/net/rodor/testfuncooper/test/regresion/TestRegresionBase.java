package net.rodor.testfuncooper.test.regresion;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.Env;
import net.rodor.testfuncooper.UtilServiceImpl;

public class TestRegresionBase {

	public WebDriver driver = null;
	public Env env = null;
	public  UtilServiceImpl serv;

	public void inicializaEntorno() throws InterruptedException, AWTException{

		System.out.println("Inicializando Entorno....\n");
		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/test/regresion/data_set_env_sp_config.xml");
		env = (Env) contextEnv.getBean("env");
		
		serv = contextEnv.getBean(UtilServiceImpl.class);
	}
	public void finalizaEntorno(){
		System.out.println("Finalizando Entorno ...\n");
		driver.close();
	}
}
