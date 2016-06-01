package ro.ase.cts.teste;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.cts.singletonAndProxy.ProxyDepozit;

public class TestCaseLoadFromFile {

	ProxyDepozit depozit;
	static String filetest="filetest.txt";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		File fout = new File(filetest);
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		
	 
		bw.write("Pulpa de pui condimentata");
		bw.newLine();
		bw.write("castraveti murati");
		bw.newLine();
		bw.write("maioneza");
	
		
		bw.close();
	}

	
	@Test
	public void test() {
		ArrayList<String> ingredienteAsteptate=new ArrayList<>();
		
		ingredienteAsteptate.add("Pulpa de pui condimentata");
		ingredienteAsteptate.add("castraveti murati");
		ingredienteAsteptate.add("maioneza");
		
		depozit=new ProxyDepozit(filetest);
		
		
		assertEquals("Verificare loadFromFile ingrediente",ingredienteAsteptate, depozit.ingrediente());
		
	}

}
