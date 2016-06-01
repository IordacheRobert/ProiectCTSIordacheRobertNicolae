package ro.ase.cts.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCaseClientBuilder.class, TestCaseComandaAdaugaProdus.class,
		TestCaseComandaCalculeavaValoareTotala.class, TestCaseConstructorClient.class, TestCaseLoadFromFile.class,
		TestCaseNumeClient.class, TestCaseObtineIngrediente.class, TestCaseProcesareComanda.class })
public class AllTests {

}
