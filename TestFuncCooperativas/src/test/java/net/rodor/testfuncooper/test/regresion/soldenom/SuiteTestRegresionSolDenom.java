package net.rodor.testfuncooper.test.regresion.soldenom;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	TestRegresionSolDenomOnline.class,
	TestRegresionSolProrrogaDenomOnline.class,
	TestRegresionSolProrrogaDenomOnlineCont.class,
	// obsoleto ya no tiene sentido en esta version
	//TestRegresionAddObservaciones.class,
	TestRegresionSolDenomManual.class,
	TestRegresionGestionCertDenom.class
	
})

public class SuiteTestRegresionSolDenom {
	
	

}
