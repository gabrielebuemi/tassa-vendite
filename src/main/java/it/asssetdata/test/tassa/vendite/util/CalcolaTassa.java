package it.asssetdata.test.tassa.vendite.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import it.asssetdata.test.tassa.vendite.bean.EnumTipoArticolo;

public class CalcolaTassa {
	
	private static CalcolaTassa instance;
	
	private CalcolaTassa() {
		super();
	}
	
	public static CalcolaTassa getInstance(){
		if(instance==null) {
			instance = new CalcolaTassa();
		}
		return instance;
	}
	
	/**
	 * calcola l'imposta di vendita in funzione della percentiale contenuta in TassaVenditeUtil.IMPOSTA_VENDITA
	 * 
	 * @param prezzo
	 * @param enumTipoArticolo
	 * @return
	 */
	public BigDecimal calcolaImpostaVendita(BigDecimal prezzo, EnumTipoArticolo enumTipoArticolo){
		BigDecimal imposta = new BigDecimal(0L);
		if ( TassaVenditeUtil.getArticoliEsentiImposta().contains(enumTipoArticolo) ) {
			return imposta;
		}
		imposta = prezzo.multiply(TassaVenditeUtil.IMPOSTA_VENDITA).divide(new BigDecimal(100));
		return this.arrotonda(imposta);
	}
	
	/**
	 * 
	 * calcola il dazio doganale in base alla percentuale TassaVenditeUtil.DAZIO_DOGANALE
	 * 
	 * @param prezzo
	 * @param tipoArticolo
	 * @return
	 */
	public BigDecimal calcolaDazioDoganale(BigDecimal prezzo, EnumTipoArticolo tipoArticolo){
		BigDecimal dazio = new BigDecimal(0L);
		dazio = prezzo.multiply(TassaVenditeUtil.DAZIO_DOGANALE).divide(new BigDecimal(100));		
		return this.arrotonda(dazio);
	}
	
	/**
	 * arrotonda per eccesso allo 0.05 piu' vicino
	 * 
	 * @param value
	 * @return
	 */
	private BigDecimal arrotonda(BigDecimal value) {
		BigDecimal incrementa = new BigDecimal(0.05);
		BigDecimal div = value.divide(incrementa, 0, RoundingMode.UP);
		return div.multiply(incrementa).setScale(2, RoundingMode.DOWN);
	}
	
}
