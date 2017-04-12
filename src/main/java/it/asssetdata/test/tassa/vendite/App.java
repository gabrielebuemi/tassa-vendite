package it.asssetdata.test.tassa.vendite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import it.asssetdata.test.tassa.vendite.bean.Articolo;
import it.asssetdata.test.tassa.vendite.bean.ArticoloImportato;
import it.asssetdata.test.tassa.vendite.bean.EnumTipoArticolo;
import it.asssetdata.test.tassa.vendite.blogic.CarrelloSpesa;

/**
 * 
 * Input 3:
 *    - 1 imported bottle of perfume at 27.99
 *    - 1 bottle of perfume at 18.99
 *    - 1 packet of headache pills at 9.75
 *    - 1 box of imported chocolates at 11.25
 *
 */
public class App  {
	
	public static void main( String[] args ) {
		List<Articolo> articoli = getInput3();
		CarrelloSpesa carrelloSpesa = new CarrelloSpesa(articoli);
		carrelloSpesa.generaScontrino();
		System.out.println(carrelloSpesa.toString());
	}

	private static List<Articolo> getInput3() {
		List<Articolo> articoli = new ArrayList<Articolo>(4);
		Articolo profumoImportato = new ArticoloImportato();
		profumoImportato.setNumeroArticoliAcquistati(1);
		profumoImportato.setDescrizione("imported bottle of profume");
		profumoImportato.setPrezzoNetto(new BigDecimal("27.99"));
		profumoImportato.setTipoArticolo(EnumTipoArticolo.ALTRO);
		articoli.add(profumoImportato);

		Articolo profumo = new Articolo();
		profumo.setNumeroArticoliAcquistati(1);
		profumo.setDescrizione("bottle of perfume");
		profumo.setPrezzoNetto(new BigDecimal("18.99"));
		profumo.setTipoArticolo(EnumTipoArticolo.ALTRO);
		articoli.add(profumo);

		Articolo pillole = new Articolo();
		pillole.setNumeroArticoliAcquistati(1);
		pillole.setDescrizione("packet of headache pills");
		pillole.setPrezzoNetto(new BigDecimal("9.75"));
		pillole.setTipoArticolo(EnumTipoArticolo.PRODOTTO_MEDICO);
		articoli.add(pillole);

		Articolo cioccolatoImportato = new ArticoloImportato();
		cioccolatoImportato.setNumeroArticoliAcquistati(1);
		cioccolatoImportato.setDescrizione("box of imported chocolates");
		cioccolatoImportato.setPrezzoNetto(new BigDecimal("11.25"));
		cioccolatoImportato.setTipoArticolo(EnumTipoArticolo.CIBO);
		articoli.add(cioccolatoImportato);			

		return articoli;
	}
}
