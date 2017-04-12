package it.asssetdata.test.tassa.vendite.bean;

import java.math.BigDecimal;

import it.asssetdata.test.tassa.exception.TassaVenditeException;
import it.asssetdata.test.tassa.vendite.util.CalcolaTassa;

public class ArticoloImportato extends Articolo {

	private static final long serialVersionUID = -6383941219684672023L;

	private BigDecimal valoreDazioDoganale;

	public BigDecimal getValoreDazioDoganale() {
		return valoreDazioDoganale;
	}
	public void setValoreDazio(BigDecimal valoreDazioDoganale) {
		this.valoreDazioDoganale = valoreDazioDoganale;
	}
	/**
	 * calcola il dazio doganale
	 * 
	 * @return
	 */
	protected BigDecimal calcolaDazioDoganale(){
		if (this.getPrezzoNetto()==null) {
			return null;
		}
		this.valoreDazioDoganale = CalcolaTassa.getInstance().calcolaDazioDoganale(this.getPrezzoNetto(), this.tipoArticolo);
		return this.valoreDazioDoganale;
	}
	/**
	 * calcola importo tasse totale da aggiungere al prezzo betto dell'articolo
	 * 
	 * @return
	 */
	@Override
	public BigDecimal getImportoTasseTotale(){
		return this.valoreImposta.add(this.valoreDazioDoganale);
	}
	/**
	 * calcola importo finale dell'articolo (comprese le tasse)
	 * 
	 * @return
	 * @throws TassaVenditeException 
	 */
	@Override
	public BigDecimal calcolaPrezzoFinale() throws TassaVenditeException {
		if (super.getPrezzoNetto()==null) {
			throw new TassaVenditeException("Prezzo netto articolo non presente!");
		}
		this.calcolaImportoTotaleTasse();
		this.prezzoFinale = this.getPrezzoNetto().add(getImportoTasseTotale());
		return this.prezzoFinale.multiply(new BigDecimal(numeroArticoliAcquistati));
	}
	/**
	 * calcola importo tasse totale: valore imposta + dazio doganale - ritorno il totale delle tasse da 
	 * aggiungere all' articolo
	 * 
	 * @throws TassaVenditeException 
	 */
	protected void calcolaImportoTotaleTasse() throws TassaVenditeException{
		if (this.getPrezzoNetto()==null) {
			throw new TassaVenditeException("Prezzo netto articolo non presente!");
		}
		super.calcolaImportoTotaleTasse();
		if (this.valoreDazioDoganale==null)
			this.valoreDazioDoganale = CalcolaTassa.getInstance().calcolaDazioDoganale(this.getPrezzoNetto(), this.tipoArticolo);		
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticoloImportato [valoreDazioDoganale=");
		builder.append(valoreDazioDoganale);
		builder.append("]");
		return builder.toString();
	}
}
