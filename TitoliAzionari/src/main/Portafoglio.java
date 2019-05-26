package main;

import java.io.Serializable;
import java.util.Vector;

public class Portafoglio implements Serializable{

	private static final String DESCRIZIONE="Nome Portafoglio: %s\nElenco Titoli:\n%sValore Totale Portafoglio '%s': %1.4f\n";

	private Vector<Lotto> lotti;
	private ElencoTitoli titoli;
	private String nome;
	/**
	 * @param _nome - nome del portafoglio
	 * @param _titoli - elenco dei titoli del portafoglio
	 * */
	public Portafoglio(String _nome, ElencoTitoli _titoli) {
		this.lotti= new Vector<Lotto>();
		this.titoli=_titoli;
		this.nome=_nome;
	}
	/**
	 * @return valore totale del portafoglio
	 * */
	public double valore() {
		double valore=0;
		for(Lotto lotto : lotti) 
			valore+=lotto.valore();
		return valore;
	}
	/**
	 * Aggiunge un Lotto al portafoglio
	 * @param lotto - Lotto da inserire
	 * */
	public void addLotto(Lotto lotto) {
		this.lotti.add(lotto);
	}
	/**
	 * Simula la variazione giornaliera per ogni titolo del portafoglio
	 * */
	public void simulaVariazione() {
		this.titoli.simulaVariazione();
	}
	/**
	 * @return Stringa descrittiva del portafoglio
	 * */
	public String toString() {
		StringBuffer desc=new StringBuffer();
		for(Lotto lotto : lotti)
			desc.append(lotto.toString()+"\n");
		return String.format(DESCRIZIONE, this.nome, desc.toString(), this.nome, this.valore());
	}

}