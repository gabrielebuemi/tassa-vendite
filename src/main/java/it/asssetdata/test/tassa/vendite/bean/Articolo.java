package it.asssetdata.test.tassa.vendite.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import it.asssetdata.test.tassa.exception.TassaVenditeException;
import it.asssetdata.test.tassa.vendite.util.CalcolaTassa;

public class Articolo implements Serializable {
	
	private static final long serialVersionUID = 1897315254104389201L;

	protected String descrizione;
	protected EnumTipoArticolo tipoArticolo;
	protected BigDecimal prezzoNetto;
	protected BigDecimal valoreImposta;
	protected BigDecimal prezzoFinale;
	protected int numeroArticoliAcquistati;
		
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public BigDecimal getPrezzoNetto() {
		return prezzoNetto;
	}
	public void setPrezzoNetto(BigDecimal prezzoNetto) {
		this.prezzoNetto = prezzoNetto;
	}
	public BigDecimal getValoreImposta() {
		return valoreImposta;
	}
	public void setValoreImposta(BigDecimal valoreImposta) {
		this.valoreImposta = valoreImposta;
	}
	public BigDecimal getPrezzoFinale() {
		return prezzoFinale;
	}
	public void setPrezzoFinale(BigDecimal prezzoFinale) {
		this.prezzoFinale = prezzoFinale;
	}
	public EnumTipoArticolo getTipoArticolo() {
		return tipoArticolo;
	}
	public void setTipoArticolo(EnumTipoArticolo tipoArticolo) {
		this.tipoArticolo = tipoArticolo;
	}
	
	/**
	 * calcola valore imposta vendita e ritorno il totale delle tasse da 
	 * aggiungere all' articolo
	 * @throws TassaVenditeException 
	 */
	protected void calcolaImportoTotaleTasse() throws TassaVenditeException{
		if (this.getPrezzoNetto()==null) {
			throw new TassaVenditeException("Prezzo netto articolo non presente!");
		}
		if (this.valoreImposta==null) {
			this.valoreImposta = CalcolaTassa.getInstance().calcolaImpostaVendita(this.getPrezzoNetto(), this.getTipoArticolo());
		}
	}
	
	/**
	 * calcola importo finale dell'articolo (comprese le tasse)
	 * 
	 * @return
	 * @throws TassaVenditeException 
	 */
	public BigDecimal calcolaPrezzoFinale() throws TassaVenditeException{
		if (this.getPrezzoNetto()==null) {
			throw new TassaVenditeException("Prezzo netto articolo non presente!");
		}
		this.calcolaImportoTotaleTasse();
		this.prezzoFinale = this.getPrezzoNetto().add(this.getValoreImposta());
		return this.prezzoFinale.multiply(new BigDecimal(numeroArticoliAcquistati));
	}
	
	/**
	 * calcola importo tasse totale da aggiungere al prezzo betto dell'articolo
	 * 
	 * @return
	 */
	public BigDecimal getImportoTasseTotale(){
		return this.valoreImposta;
	}	

	public int getNumeroArticoliAcquistati() {
		return numeroArticoliAcquistati;
	}
	public void setNumeroArticoliAcquistati(int numeroArticoliAcquistati) {
		this.numeroArticoliAcquistati = numeroArticoliAcquistati;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Articolo [descrizione=");
		builder.append(descrizione);
		builder.append(", tipoArticolo=");
		builder.append(tipoArticolo);
		builder.append(", prezzoNetto=");
		builder.append(prezzoNetto);
		builder.append(", valoreImposta=");
		builder.append(valoreImposta);
		builder.append(", prezzoFinale=");
		builder.append(prezzoFinale);
		builder.append(", numeroArticoliAcquistati=");
		builder.append(numeroArticoliAcquistati);
		builder.append("]");
		return builder.toString();
	}
	
}
