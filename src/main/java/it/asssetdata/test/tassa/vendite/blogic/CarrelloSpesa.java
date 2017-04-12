package it.asssetdata.test.tassa.vendite.blogic;

import java.io.Serializable;
import java.util.List;

import it.asssetdata.test.tassa.exception.TassaVenditeException;
import it.asssetdata.test.tassa.vendite.bean.Articolo;
import it.asssetdata.test.tassa.vendite.bean.Scontrino;

public class CarrelloSpesa implements Serializable {

	private static final long serialVersionUID = 6839501547978443830L;

	private List<Articolo> articoli;
	private Scontrino scontrino;

	public CarrelloSpesa(List<Articolo> articoli) {
		this.articoli = articoli;
	}		
	public List<Articolo> getArticoli() {
		return articoli;
	}
	public void setArticoli(List<Articolo> articoli) {
		this.articoli = articoli;
	}
	public Scontrino getScontrino() {
		return scontrino;
	}
	public void setScontrino(Scontrino scontrino) {
		this.scontrino = scontrino;
	}

	/**
	 * data una lista di articoli calcola gli importi totali: prezzo finale e 
	 * tasse applicate (che include imposte vendite e eventuale dazio doganale)
	 * 
	 * @return
	 */
	public Scontrino generaScontrino() {
		try {
			if (this.articoli==null || this.articoli.isEmpty()) {
				throw new TassaVenditeException("Nessun articolo presente nel carrello!");
			}
			if (this.scontrino==null)
				scontrino = new Scontrino();
			for (Articolo articolo : articoli) {
				scontrino.setImportoTotale( scontrino.getImportoTotale().add(articolo.calcolaPrezzoFinale()) );
				scontrino.setImportoTasse( scontrino.getImportoTasse().add(articolo.getImportoTasseTotale()) );
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return scontrino;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Articolo articolo : articoli) {
			builder.append(String.format("%s %s at: %s \n",articolo.getNumeroArticoliAcquistati(), articolo.getDescrizione(), articolo.getPrezzoFinale()));
		}
		builder.append(scontrino.toString());
		return builder.toString();
	}
}
