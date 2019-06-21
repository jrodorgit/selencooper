package net.rodor.testfuncooper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import net.rodor.testfuncooper.test.regresion.acceso.TestRegresionAuthFirmaCentralizada;
import net.rodor.testfuncooper.test.regresion.cooperativas.TestRegresionCooperativasConsulta;
import net.rodor.testfuncooper.test.regresion.legajos.TestRegresionLegajos;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	TestRegresionAuthFirmaCentralizada.class,
	TestRegresionAsientos.class,
	TestRegresionLegajos.class,
	TestRegresionSolDenomOnline.class,
	TestRegresionSolDenomManual.class,
	TestRegresionGestionCertDenom.class,
	TestRegresionEnviarExpedFirma.class,
	TestRegresionFirmarExpediente.class,
	
	// pedir prorroga
	TestRegresionSolProrrogaDenomOnline.class,
	TestRegresionCooperativasConsulta.class
})

public class SuiteTestRegresion {

	// the class remains empty,
	// used only as a holder for the above annotations
}
