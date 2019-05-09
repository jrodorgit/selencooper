package net.rodor.testfuncooper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestRegresionLegajos.class,
	TestRegresionSolDenomOnline.class
	//TestRegresionAsientos.class
})

public class SuiteTestRegresion {

	// the class remains empty,
	// used only as a holder for the above annotations
}
