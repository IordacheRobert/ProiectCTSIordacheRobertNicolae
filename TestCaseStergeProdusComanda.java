package ro.ase.cts.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.cts.SimpleFactory.Produs;
import ro.ase.cts.SimpleFactory.ProdusFactory;
import ro.ase.cts.SimpleFactory.TipProdus;
import ro.ase.cts.exceptii.ExceptieCapacitateMaxima;
import ro.ase.cts.exceptii.ExceptieNull;
import ro.ase.cts.strategyAndObserver.Comanda;

public class TestCaseStergeProdusComanda {

	
	Comanda comanda;
	
	@Before
	public void setUp() throws Exception {
		comanda=new Comanda();
		comanda.adaugareProdus(ProdusFactory.creareProdus(TipProdus.BOOSTER));
		comanda.adaugareProdus(ProdusFactory.creareProdus(TipProdus.CRISPYSANDWICH));
		comanda.adaugareProdus(ProdusFactory.creareProdus(TipProdus.BOOSTER));
	}

	@After
	public void tearDown() throws Exception {
		comanda=null;
	}

	@Test
	public void testStergereProdusExistent() {
		int valoareAsteptata=comanda.getProduseCos().size();
		comanda.stergeProdus(ProdusFactory.creareProdus(TipProdus.CRISPYSANDWICH));
		
		assertEquals("Verificare stergere produs",valoareAsteptata-1,comanda.getProduseCos().size());
		

	}

	@Test
	public void  testStergereProdusInexistent() throws ExceptieCapacitateMaxima{
		
		
		comanda.getProduseCos().clear();
		comanda.adaugareProdus(ProdusFactory.creareProdus(TipProdus.BOOSTER));
		int valoareAsteptata=comanda.getProduseCos().size();

		comanda.stergeProdus(ProdusFactory.creareProdus(TipProdus.CRISPYSANDWICH));
		
		assertEquals("Verificare stergere produs",valoareAsteptata,comanda.getProduseCos().size());
	}

	
	@Test
	public void testStergereProdusNull(){
		Produs produsTest=null;
		
		try{
		
		comanda.stergeProdus(produsTest);
		fail("Nu se poate sterge un produs cu valoarea null");
		
		}catch(ExceptieNull ex){
			
		}
	
		
		}

}
