package ro.ase.cts.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.cts.builder.Client;
import ro.ase.cts.util.TipPlata;

public class TestCaseGetNumeClient {
	Client client;
	
	
	@Before
	public void setUp() throws Exception {
		client=new Client("Dumistrescu", "Ion","Bucharest,sector 6,Strada Xulescu","0763625252", TipPlata.CASH);
	}

	@After
	public void tearDown() throws Exception {
		client=null;
	}
		
	@Test
	public void testGetNumeNormal() {
		String valoareAsteptata="Robert";
		
		client.setNume(valoareAsteptata);
		
		assertEquals("Verificare getNumeClient",valoareAsteptata,client.getNume());
	}

}
