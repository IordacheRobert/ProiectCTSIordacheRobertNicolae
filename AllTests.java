package ro.ase.cts.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCaseClientBuilder.class, TestCaseComandaAdaugaProdus.class,
		TestCaseComandaCalculeazaValoareTotala.class, TestCaseConstructorClient.class, TestCaseGetNumeClient.class,
		TestCaseLoadFromFile.class, TestCaseObtineIngrediente.class, TestCaseProcesareComanda.class,
		TestCaseSetNumeClient.class, TestCaseStergeProdusComanda.class })
public class AllTests {

}
