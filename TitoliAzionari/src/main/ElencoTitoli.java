package main;

import java.io.Serializable;
import java.util.Vector;

public class ElencoTitoli implements Serializable{

	private static final String DESCRIZIONE="Elenco Titoli:\n%s";

	private Vector<Titolo> titoli;

	public ElencoTitoli() {
		titoli= new Vector<Titolo>();
	}
	/**
	 * Aggiunge un titolo all'elenco
	 * @param titolo - titolo da aggiungere
	 * */
	public void addTitolo(Titolo titolo) {
		this.titoli.add(titolo);
	}
	/**
	 * Seleziona un titolo dall'elenco
	 * @param index - indirizzo del titolo da prendere
	 * @return Titolo scelto
	 * */
	public Titolo getTitolo(int index) {
		return this.titoli.get(index);
	}
	/**
	 * @return numero dei titoli nell'elenco
	 * */
	public int numeroTitoli() {
		return this.titoli.size();
	}
	/**
	 * Simula la variazione giornaliera per tutti i titoli in elenco
	 * */
	public void simulaVariazione() {
		for(Titolo tit : titoli)
			tit.variazGiornaliera();
	}
	/**
	 * @return Stringa descrittiva dell'elenco
	 * */
	public String toString() {
		StringBuffer desc = new StringBuffer();
		for(Titolo tit:titoli)
			desc.append(tit.toString()+"\n");
		return String.format(DESCRIZIONE, desc);
	}
}
