package main;

import java.util.Random;
import java.util.Vector;

public class CD {
	private static final String BRANO_CONTENUTO="Questo brano è già presente nel CD";
	private static final String BRANO_NON_CONTENUTO="Questo brano non è presente nel CD";
	private static final String DESCRIZIONE="%s, %s\nElenco brani";
	private static final String SCONOSCIUTO="Sconosciuto";
	
	private Vector<Brano> elencoBrani;
	private String titolo;
	private String autore;
	
	/**
	 * Costruttore CD
	 * @param _titolo titolo del CD
	 * @param _autore autore del CD
	 * */
	public CD(String _titolo,String _autore) {
		this.titolo=_titolo;
		this.autore=_autore;
		this.elencoBrani=new Vector<Brano>();
	}
	/**
	 * @param _titolo titolo del CD
	 * */
	public CD(String _titolo) {
		this(_titolo, SCONOSCIUTO);
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	public String getAutore() {
		return this.autore;
	}
	
	private boolean branoContenuto(Brano brano){
		boolean contenuto=false;
		for(int i=0;i<elencoBrani.size();i++) 
			if(elencoBrani.contains(brano))
				contenuto=true;
		return contenuto;
	}
	
	/**
	 * Aggiungi un brano al CD, se non è già presente
	 * @param brano brano da aggiungere
	 * */
	public void aggiungiBrano(Brano brano) {
		if(!branoContenuto(brano))
			this.elencoBrani.add(brano);
		else
			System.out.println(BRANO_CONTENUTO);
	}
	
	/**
	 * Seleziona un brano casuale dal CD
	 * @return brano scelto
	 * */
	public Brano selezionaBranoCasuale() {
		Random rand = new Random();
		return elencoBrani.get(rand.nextInt(elencoBrani.size()));
	}
	
	/**
	 * @param titoloBrano titolo del brano scelto
	 * @return null se il brano cercato non è presente nel CD; brano cercato.
	 * */
	public Brano selezionaBrano(String titoloBrano) {
		int index=-1;
		for(int i=0;i<elencoBrani.size();i++) {
			if(elencoBrani.get(i).getTitolo().equalsIgnoreCase(titoloBrano)) {
				index=i;
				break;
			}
		}
		if(index<0) {
			System.out.println(BRANO_NON_CONTENUTO);
			return null;
		}else
			return elencoBrani.get(index);
	}
	
	/**
	 * Stringa descrizione del CD
	 * @return stringa descrittiva
	 * */
	public String toString() {
		StringBuffer desc=new StringBuffer();
		desc.append(String.format(DESCRIZIONE, this.titolo, this.autore));
		for(int i=0;i<elencoBrani.size();i++) {
			desc.append("\n"+(i+1)+"\t"+elencoBrani.get(i).toString());
		}
		return desc.toString();
	}
	
}
