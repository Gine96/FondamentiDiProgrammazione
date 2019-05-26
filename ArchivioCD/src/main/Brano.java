package main;

public class Brano {
	private static final String DESCRIZIONE="%s (%02d:%02d)";

	private String titolo;
	private int durata;
	private int secondi,minuti;
	
	/**
	 * @param _titolo titolo brano
	 * @param _durata durata brano in secondi
	 * */
	public Brano(String _titolo,int _durata) {
		this.titolo=_titolo;
		this.durata=_durata;
		this.minuti=_durata/60;
		this.secondi=_durata%60;
	}
	
	public Brano(String _titolo, int _minuti, int _secondi) {
		this.titolo=_titolo;
		this.minuti=_minuti;
		this.secondi=_secondi;
		this.durata=this.minuti*60+this.secondi;
	}

	public String getTitolo() {
		return this.titolo;
	}
	public int getDurata() {
		return this.durata;
	}
	
	/**
	 * Stringa descrizione per il brano
	 * @return stringa descrittiva
	 * */
	public String toString() {
		return String.format(DESCRIZIONE, this.titolo, this.minuti, this.secondi);
	}
	
}
