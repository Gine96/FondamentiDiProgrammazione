package main;

import java.io.Serializable;

public class Lotto implements Serializable{

	private static final String DESCRIZIONE="%s\nStock: %10d\n";

	private Titolo titoloAzionario;
	private int quantita;
	/**
	 * @param _titolo - Titolo azionario
	 * @param _quantita - quantità di titoli posseduti
	 * */
	public Lotto(Titolo _titolo, int _quantita) {
		this.titoloAzionario=_titolo;
		this.quantita=_quantita;
	}
	/**
	 * @return valore del Lotto
	 * */
	public double valore() {
		return this.quantita*this.titoloAzionario.getPrezzo();
	}
	/**
	 * @return Stringa descrittiva del Lotto
	 * */
	public String toString() {
		return String.format(DESCRIZIONE, this.titoloAzionario.toString(), this.quantita);
	}

}
