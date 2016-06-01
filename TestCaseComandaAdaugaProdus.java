package ro.ase.cts.teste;

import static org.junit.Assert.fail;

import java.security.InvalidParameterException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.ase.cts.SimpleFactory.Booster;
import ro.ase.cts.SimpleFactory.CrispySandwich;
import ro.ase.cts.SimpleFactory.Produs;
import ro.ase.cts.exceptii.ExceptieCapacitateMaxima;
import ro.ase.cts.exceptii.ExceptieNull;
import ro.ase.cts.strategyAndObserver.Comanda;

public class TestCaseComandaAdaugaProdus {
	Comanda comanda;

	@Before
	public void setUp() throws Exception {
		comanda = new Comanda();
	}

	@After
	public void tearDown() throws Exception {
		comanda.getProduseCos().clear();
		comanda = null;
	}

	@Test
	public void testAdaugaProdusCosCapacitateMaxima() throws ExceptieCapacitateMaxima {
		try {
			for (int i = 0; i < comanda.getCapacitateMaxima() + 5; i++) {
				comanda.adaugareProdus(new Booster());
			}
			fail("Capacitate maxima depasita");
		} catch (ExceptieCapacitateMaxima ex) {

		}
	}

	@Test
	public void testAdaugareProdusNull() throws ExceptieCapacitateMaxima {
		try {
			comanda.adaugareProdus(null);
			fail("Nu se poate adauga un produs null");
		} catch (ExceptieNull ex) {

		}
	}

	@Test
	public void testAdaugareProdusCuPretNegativ() throws ExceptieCapacitateMaxima {
		Produs produs = new CrispySandwich();
		produs.pret = -50;

		try {
			comanda.adaugareProdus(produs);
			fail("Eroare adaugare produs cu pret negativ");
		} catch (InvalidParameterException e) {

		}

	}
	
	@Test
	public void testAdaugareProdusCuPretZero() throws ExceptieCapacitateMaxima {
		Produs produs = new CrispySandwich();
		produs.pret =0;

		try {
			comanda.adaugareProdus(produs);
			fail("Eroare adaugare produs cu pret egal cu 0");
		} catch (InvalidParameterException e) {

		}

	}

}
