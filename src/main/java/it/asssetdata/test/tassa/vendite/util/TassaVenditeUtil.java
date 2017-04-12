package it.asssetdata.test.tassa.vendite.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import it.asssetdata.test.tassa.vendite.bean.EnumTipoArticolo;

public class TassaVenditeUtil {

	public final static BigDecimal IMPOSTA_VENDITA = new BigDecimal(10);
	public final static BigDecimal DAZIO_DOGANALE = new BigDecimal(5);
	private static List<EnumTipoArticolo> articoliEsentiImposta;
	
	public static List<EnumTipoArticolo> getArticoliEsentiImposta(){
		if (articoliEsentiImposta==null) {
			articoliEsentiImposta = new ArrayList<EnumTipoArticolo>(3);
			articoliEsentiImposta.add(EnumTipoArticolo.CIBO);
			articoliEsentiImposta.add(EnumTipoArticolo.LIBRO);
			articoliEsentiImposta.add(EnumTipoArticolo.PRODOTTO_MEDICO);			
		}
		return articoliEsentiImposta;
	}
	
}
