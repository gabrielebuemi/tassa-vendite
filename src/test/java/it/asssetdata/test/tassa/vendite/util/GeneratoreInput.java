package it.asssetdata.test.tassa.vendite.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import it.asssetdata.test.tassa.vendite.bean.Articolo;
import it.asssetdata.test.tassa.vendite.bean.ArticoloImportato;
import it.asssetdata.test.tassa.vendite.bean.EnumTipoArticolo;

public class GeneratoreInput {
	
	public List<Articolo> input1;
	public List<Articolo> input2;
	public List<Articolo> input3;
	
	/**
	 * Input 1:
	 *    - 1 book at 12.49
	 *    - 1 music CD at 14.99
	 *    - 1 chocolate bar at 0.85
	 *    
	 * @return
	 */
	public List<Articolo> getInput1() {
		if (input1 != null) {
			 return input1;
		}
		
		input1 = new ArrayList<Articolo>(4);
		Articolo book = new Articolo();
		book.setNumeroArticoliAcquistati(1);
		book.setDescrizione("book");
		book.setPrezzoNetto(new BigDecimal("12.49"));
		book.setTipoArticolo(EnumTipoArticolo.LIBRO);		
		input1.add(book);
		
		Articolo cd = new Articolo();
		cd.setNumeroArticoliAcquistati(1);
		cd.setDescrizione("music CD");
		cd.setPrezzoNetto(new BigDecimal("14.99"));
		cd.setTipoArticolo(EnumTipoArticolo.ALTRO);
		input1.add(cd);
		
		Articolo cioccolato = new Articolo();
		cioccolato.setNumeroArticoliAcquistati(1);
		cioccolato.setDescrizione("chocolate bar");
		cioccolato.setPrezzoNetto(new BigDecimal("0.85"));
		cioccolato.setTipoArticolo(EnumTipoArticolo.CIBO);
		input1.add(cioccolato);
		
		return input1;
	}
	
	/**
	 * Input 2:
	 *    - 1 imported box of chocolates at 10.00
	 *    - 1 imported bottle of perfume at 47.50
	 *    
	 * @return
	 */
	public List<Articolo> getInput2() {
		if (input2 != null) {
			 return input2;
		}
		input2 = new ArrayList<Articolo>(2);

		Articolo cioccolatoImportato = new ArticoloImportato();
		cioccolatoImportato.setNumeroArticoliAcquistati(1);
		cioccolatoImportato.setDescrizione("imported box of chocolates");
		cioccolatoImportato.setPrezzoNetto(new BigDecimal("10.00"));
		cioccolatoImportato.setTipoArticolo(EnumTipoArticolo.CIBO);
		input2.add(cioccolatoImportato);
		
		Articolo profumoImportato = new ArticoloImportato();
		profumoImportato.setNumeroArticoliAcquistati(1);
		profumoImportato.setDescrizione("imported bottle of perfume");
		profumoImportato.setPrezzoNetto(new BigDecimal("47.50"));
		profumoImportato.setTipoArticolo(EnumTipoArticolo.ALTRO);		
		input2.add(profumoImportato);
		
		return input2;
	}
	
	/**
	 * Input 3:
	 *    - 1 imported bottle of perfume at 27.99
	 *    - 1 bottle of perfume at 18.99
	 *    - 1 packet of headache pills at 9.75
	 *    - 1 box of imported chocolates at 11.25
	 *    
	 * @return
	 */
	public List<Articolo> getInput3() {
		if (input3 != null) {
			 return input3;
		}
		input3 = new ArrayList<Articolo>(4);
		Articolo profumoImportato = new ArticoloImportato();
		profumoImportato.setNumeroArticoliAcquistati(1);
		profumoImportato.setDescrizione("imported bottle of profume");
		profumoImportato.setPrezzoNetto(new BigDecimal("27.99"));
		profumoImportato.setTipoArticolo(EnumTipoArticolo.ALTRO);
		input3.add(profumoImportato);
		
		Articolo profumo = new Articolo();
		profumo.setNumeroArticoliAcquistati(1);
		profumo.setDescrizione("bottle of perfume");
		profumo.setPrezzoNetto(new BigDecimal("18.99"));
		profumo.setTipoArticolo(EnumTipoArticolo.ALTRO);
		input3.add(profumo);
		
		Articolo pillole = new Articolo();
		pillole.setNumeroArticoliAcquistati(1);
		pillole.setDescrizione("packet of headache pills");
		pillole.setPrezzoNetto(new BigDecimal("9.75"));
		pillole.setTipoArticolo(EnumTipoArticolo.PRODOTTO_MEDICO);
		input3.add(pillole);
		
		Articolo cioccolatoImportato = new ArticoloImportato();
		cioccolatoImportato.setNumeroArticoliAcquistati(1);
		cioccolatoImportato.setDescrizione("box of imported chocolates");
		cioccolatoImportato.setPrezzoNetto(new BigDecimal("11.25"));
		cioccolatoImportato.setTipoArticolo(EnumTipoArticolo.CIBO);
		input3.add(cioccolatoImportato);			
		
		return input3;
	}
	
	public void stampaArticoli(List<Articolo> articoli){
		StringBuilder builder = new StringBuilder();
		for (Articolo articolo : articoli) {
			builder.append(String.format("%s %s at %s \n",articolo.getNumeroArticoliAcquistati(), articolo.getDescrizione(), articolo.getPrezzoNetto()));
		}
		System.out.println(builder.toString());
	}

	public void setInput1(List<Articolo> input1) {
		this.input1 = input1;
	}

	public void setInput2(List<Articolo> input2) {
		this.input2 = input2;
	}

	public void setInput3(List<Articolo> input3) {
		this.input3 = input3;
	}

}
