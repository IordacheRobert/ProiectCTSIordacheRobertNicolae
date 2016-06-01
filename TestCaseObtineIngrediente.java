package ro.ase.cts.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ase.cts.exceptii.ExceptieNull;
import ro.ase.cts.singletonAndProxy.ProxyDepozit;

public class TestCaseObtineIngrediente {

	private ProxyDepozit depozit;

	@Before
	public void setUp() throws Exception {
		depozit=new ProxyDepozit();
	}

	@After
	public void tearDown() throws Exception {
		depozit=null;
	}

	@Test
	public void testObtineIngredientNull() {
		String ingredient = null;

		try {
			depozit.obtineIngrediente(ingredient);
			fail("Nu se poate obtine un produs null");
		} catch (ExceptieNull ex) {

		}
	}
	
	
	@Test
	public void testObtineIngredientExistent(){
		String ingredient = "ketchup";

		assertTrue("Verificare obtinere ingredient existent",depozit.obtineIngrediente(ingredient));
		
	}

}
