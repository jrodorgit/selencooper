package net.rodor.testfuncooper;

import java.awt.AWTException;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rodor.testfuncooper.soldenomonline.VOSolDenomOnline;

public class TestRegresionGestionCertDenom {

	
	private  UtilServiceImpl serv;
	VOSolDenomOnline soldenom = null;
	
	@Before
	public void inicializaTest() throws InterruptedException, AWTException{

		System.out.println("Inicializando TestRegresionGestionCertDenom....\n");
		
		ApplicationContext contextEnv = new ClassPathXmlApplicationContext(
				"net/rodor/testfuncooper/data_set_env_sp_config.xml");
		/***
		int i = contextEnv.getBeanDefinitionCount();
		Map<String,UtilServiceImpl>  mapa = contextEnv.getBeansOfType(UtilServiceImpl.class);
		UtilServiceImpl pp = (UtilServiceImpl) contextEnv.getBean("UtilServiceImpl");
		***/
		serv = contextEnv.getBean(UtilServiceImpl.class);
		
		System.out.println("----------------------------\n");
	}
	@After
	public void finaliza(){
		System.out.println("Finalizacion \n");
	}
	
	@Test
	public void testRegresion() throws InterruptedException, AWTException{
		
		System.out.println("Lanzando Test Regresion Gestion Certificado Denominacion....\n");

		soldenom = serv.getUltimaSolDenominacion();
		
		System.out.println("Fin Test Regresion Gestion Certificado Denominacion\n"+ soldenom.toString());
	}
	
}
