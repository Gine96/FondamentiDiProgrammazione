package main;

import java.io.Serializable;

/*
 * Serve solo da supporto
 * */
public class Contenitore implements Serializable{

	private Portafoglio portafoglio;
	private ElencoTitoli elenco;
	/**
	 * @param _wallet - portafoglio da inserire nel contenitore
	 * @param _elenco - elenco titoli da inserire nel contenitore
	 * */
	public Contenitore(Portafoglio _wallet, ElencoTitoli _elenco) {
		this.portafoglio=_wallet;
		this.elenco=_elenco;
	}
	/**
	 * @return portafoglio contenuto
	 * */
	public Portafoglio getPortafoglio() {
		return this.portafoglio;
	}
	/**
	 * @return elenco titoli contenuto
	 * */
	public ElencoTitoli getElencoTitoli() {
		return this.elenco;
	}

}
