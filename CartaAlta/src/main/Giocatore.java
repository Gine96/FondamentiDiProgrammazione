package main;

public class Giocatore {
	private static final String DESCRIZIONE="%s: %d€";
	private String nome;
	private int soldi;

	/**
	 * @param _nome nome del giocatore
	 * @param _soldi soldi disponibili inizialmente
	 * */
	public Giocatore(String _nome, int _soldi) {
		this.nome=_nome;
		this.soldi=_soldi;
	}

	/**
	 * @return soldi attuali del giocatore
	 * */
	public int getSoldi() {
		return this.soldi;
	}
	/**
	 * @param _soldi soldi da aggiungere al conto del giocatore
	 * */
	public void addSoldi(int _soldi) {
		this.soldi+=_soldi;
	}
	/**
	 * @param _soldi soldi da togliere al conto del giocatore
	 * */
	public void removeSoldi(int _soldi) {
		this.soldi-=_soldi;
	}
	/**
	 * @return Stringa descrizione giocatore
	 * */
	public String toString() {
		return String.format(DESCRIZIONE, this.nome, this.soldi);
	}
}
