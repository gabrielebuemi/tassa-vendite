package it.asssetdata.test.tassa.vendite.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Scontrino implements Serializable {

	private static final long serialVersionUID = -7600006549920814124L;
	private BigDecimal importoTasse = new BigDecimal(0L);
	private BigDecimal importoTotale = new BigDecimal(0L);
	
	public BigDecimal getImportoTasse() {
		return importoTasse;
	}
	public void setImportoTasse(BigDecimal importoTasse) {
		this.importoTasse = importoTasse;
	}
	public BigDecimal getImportoTotale() {
		return importoTotale;
	}
	public void setImportoTotale(BigDecimal importoTotale) {
		this.importoTotale = importoTotale;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("Sales Taxes: %s \n",this.importoTasse));
		builder.append(String.format("Total: %s \n",this.importoTotale));
		return builder.toString();
	}	
}
