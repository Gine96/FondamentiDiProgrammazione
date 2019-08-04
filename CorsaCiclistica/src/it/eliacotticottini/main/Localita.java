package it.eliacotticottini.main;

public class Localita {

	private static final String DESCRIZIONE="%-9s %14.2fkm %15dm\n";

	private String nome;
	private double distanzaDallaPrecedente;
	private int metriSulLivelloDelMare;
	/**
	 * @param _nomeLocalita - nome della localita
	 * @param _distanzaDallaPrecedente - distanza in chilometri dalla localita precedente
	 * @param _metriSulLivelloDelMare - altitudine della localita in metri
	 * */
	public Localita(String _nomeLocalita, double _distanzaDallaPrecedente, int _metriSulLivelloDelMare) {
		this.nome=_nomeLocalita;
		this.distanzaDallaPrecedente=_distanzaDallaPrecedente;
		this.metriSulLivelloDelMare=_metriSulLivelloDelMare;
	}
	/**
	 * @return distanza dalla localita precedente
	 * */
	public double getDistanzaDallaPrecedente() {
		return this.distanzaDallaPrecedente;
	}
	/**
	 * @return altitudine della localita
	 * */
	public int getAltitudine() {
		return this.metriSulLivelloDelMare;
	}
	/**
	 * @return nome della localita
	 * */
	public String getNome() {
		return this.nome;
	}
	/**
	 * @return stringa descrittiva della localita
	 * */
	public String toString() {
		return String.format(DESCRIZIONE, this.nome, this.distanzaDallaPrecedente, this.metriSulLivelloDelMare);
	}

}
