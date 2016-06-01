package ro.ase.cts.teste;

import static org.junit.Assert.*;

import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.cts.SimpleFactory.ProdusFactory;
import ro.ase.cts.SimpleFactory.TipProdus;
import ro.ase.cts.builder.Client;
import ro.ase.cts.exceptii.ExceptieCapacitateMaxima;
import ro.ase.cts.facade.Magazin;
import ro.ase.cts.strategyAndObserver.Comanda;
import ro.ase.cts.util.TipPlata;

public class TestCaseProcesareComanda {

	Magazin magazin;
	Client client;
	DefaultTableModel model;
	
	
	
	
	
	@Before
	public void setUp() throws Exception {
		this.magazin=new Magazin();
		this.client=new Client("Xulescu","Ion","Bucuresti, Centrul Vechi","0763965284",TipPlata.CARD);
		model=new DefaultTableModel();
	}

	@After
	public void tearDown() throws Exception {
		this.magazin=null;
		this.client=null;
		this.model=null;
	}

	@Test
	public void testProcesareComandaFaraProduse() {
		Comanda comanda=new Comanda();
		
		try{
			magazin.procesareComanda(client, comanda,model);
			fail("Esuare verificare comanda fara produse");
		}catch(Exception ex){
			
		}
		
	}
	
	@Test
	public void ProcesareComandaClientNull() throws ExceptieCapacitateMaxima{
		Client temp=null;
		Comanda comanda=new Comanda();
		comanda.adaugareProdus(ProdusFactory.creareProdus(TipProdus.BOOSTER));
		comanda.adaugareProdus(ProdusFactory.creareProdus(TipProdus.CRISPYSANDWICH));
	
		
		try{
			magazin.procesareComanda(temp, comanda,model);
			fail("Esuare verificare procesare comanda cu, client null");
		}catch(Exception ex){
			
		}
	}
	
	@Test
	public void ProcesareComandaComandaNull() throws ExceptieCapacitateMaxima{
		Comanda comanda=null;
		
		try{
			magazin.procesareComanda(client, comanda,model);
			fail("Esuare verificare procesare comanda null");
		}catch(Exception ex){
			
		}
	}

}
