package net.rodor.testfuncooper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	TestRegresionAsientos.class,
	TestRegresionLegajos.class,
	TestRegresionSolDenomOnline.class,
	TestRegresionSolDenomManual.class,
	TestRegresionGestionCertDenom.class,
	TestRegresionEnviarExpedFirma.class,
	TestRegresionFirmarExpediente.class,
	
	// pedir prorroga
	TestRegresionSolProrrogaDenomOnline.class
})

public class SuiteTestRegresion {

	// the class remains empty,
	// used only as a holder for the above annotations
}
