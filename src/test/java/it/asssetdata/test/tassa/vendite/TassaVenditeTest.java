package it.asssetdata.test.tassa.vendite;

import java.math.BigDecimal;

import it.asssetdata.test.tassa.vendite.blogic.CarrelloSpesa;
import it.asssetdata.test.tassa.vendite.util.GeneratoreInput;
import junit.framework.TestCase;

public class TassaVenditeTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGeneraScontrino() {
		GeneratoreInput generatoreInput = new GeneratoreInput();
		
		/**
		 * Input 
		 */
		System.out.println("INPUT");
		System.out.println("");
		
		System.out.println("Input 1:");
		generatoreInput.stampaArticoli(generatoreInput.getInput1());
		
		System.out.println("Input 2:");
		generatoreInput.stampaArticoli(generatoreInput.getInput2());
		
		System.out.println("Input 3:");
		generatoreInput.stampaArticoli(generatoreInput.getInput3());
		
		/**
		 * Output
		 */
		System.out.println("OUTPUT");
		System.out.println("");
		CarrelloSpesa carrelloSpesa1 = new CarrelloSpesa(generatoreInput.getInput1());
		carrelloSpesa1.generaScontrino();
		System.out.println("Output 1:");
		System.out.println(carrelloSpesa1.toString());
		
		CarrelloSpesa carrelloSpesa2 = new CarrelloSpesa(generatoreInput.getInput2());
		carrelloSpesa2.generaScontrino();
		System.out.println("Output 2:");
		System.out.println(carrelloSpesa2.toString());
		
		CarrelloSpesa carrelloSpesa3 = new CarrelloSpesa(generatoreInput.getInput3());
		carrelloSpesa3.generaScontrino();
		System.out.println("Output 3:");
		System.out.println(carrelloSpesa3.toString());

		assertEquals(new BigDecimal("12.49"), carrelloSpesa1.getArticoli().get(0).getPrezzoFinale());
		assertEquals(new BigDecimal("16.49"), carrelloSpesa1.getArticoli().get(1).getPrezzoFinale());
		assertEquals(new BigDecimal("0.85"), carrelloSpesa1.getArticoli().get(2).getPrezzoFinale());
		assertEquals(new BigDecimal("1.50"), carrelloSpesa1.getScontrino().getImportoTasse());
		assertEquals(new BigDecimal("29.83"), carrelloSpesa1.getScontrino().getImportoTotale());
		                            
		assertEquals(new BigDecimal("10.50"), carrelloSpesa2.getArticoli().get(0).getPrezzoFinale());
		assertEquals(new BigDecimal("54.65"), carrelloSpesa2.getArticoli().get(1).getPrezzoFinale());
		assertEquals(new BigDecimal("7.65"), carrelloSpesa2.getScontrino().getImportoTasse());
		assertEquals(new BigDecimal("65.15"), carrelloSpesa2.getScontrino().getImportoTotale());
		                            
		assertEquals(new BigDecimal("32.19"), carrelloSpesa3.getArticoli().get(0).getPrezzoFinale());
		assertEquals(new BigDecimal("20.89"), carrelloSpesa3.getArticoli().get(1).getPrezzoFinale());
		assertEquals(new BigDecimal("9.75"), carrelloSpesa3.getArticoli().get(2).getPrezzoFinale());
		assertEquals(new BigDecimal("11.85"), carrelloSpesa3.getArticoli().get(3).getPrezzoFinale());
		assertEquals(new BigDecimal("6.70"), carrelloSpesa3.getScontrino().getImportoTasse());
		assertEquals(new BigDecimal("74.68"), carrelloSpesa3.getScontrino().getImportoTotale());
		
	}

}
