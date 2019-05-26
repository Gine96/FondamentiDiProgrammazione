package main;

import java.io.Serializable;

import utils.NumeriCasuali;

public class Titolo implements Serializable{

	private static final String DESCRIZIONE="Nome:\t%s\nValore: %17.4f";

	private static final double VAR_MIN=-0.2;
	private static final double VAR_MAX=+0.2;

	private String nome;
	private double valore;
	/**
	 * @param _nome - nome del titolo
	 * @param _valore - valore del titolo
	 * */
	public Titolo(String _nome, double _valore) {
		this.nome=_nome;
		this.valore=_valore;
	}
	/**
	 * Aggiorna il valore del titolo alzandolo o abbassandolo al massimo del 20%
	 * */
	public void variazGiornaliera() {
		this.valore+=valore*NumeriCasuali.estraiDouble(VAR_MIN, VAR_MAX);
	}
	/**
	 * @return valore del titolo
	 * */
	public double getPrezzo() {
		return this.valore;
	}
	/**
	 * @return nome del titolo
	 * */
	public String getNome() {
		return this.nome;
	}
	/**
	 * @return Stringa descrittiva del titolo
	 * */
	public String toString() {
		return String.format(DESCRIZIONE, this.nome, this.valore);
	}


}
