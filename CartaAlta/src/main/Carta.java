package main;

public class Carta {

	public enum ValoreFrancese{
		DUE,
		TRE,
		QUATTRO,
		CINQUE,
		SEI,
		SETTE,
		OTTO,
		NOVE,
		DIECI,
		JACK,
		DONNA,
		RE,
		ASSE
	}
	public enum ValoreItaliano{
		DUE,
		QUATTRO,
		CINQUE,
		SEI,
		SETTE,
		FANTE,
		CAVALLO,
		RE,
		TRE,
		ASSE
	}
	private ValoreFrancese valoreFra;
	private ValoreItaliano valoreIta;
	public enum SemeFrancese{
		CUORI,
		QUADRI,
		FIORI,
		PICCHE
	}
	public enum SemeItaliano{
		BASTONI,
		SPADE,
		COPPE,
		ORI
	}
	private SemeFrancese semeFra;
	private SemeItaliano semeIta;
	private boolean ita;
	private boolean fra;
	/**
	 * Carte Francesi
	 * @param _valore valore della carta
	 * @param _seme seme della carta
	 * */
	public Carta(ValoreFrancese _valore, SemeFrancese _seme) {
		this.valoreFra=_valore;
		this.semeFra=_seme;
		this.fra=true;
		this.ita=false;
	}
	/**
	 * Carte Italiane
	 * @param _valore valore della carta
	 * @param _seme seme della carta
	 * */
	public Carta(ValoreItaliano _valore, SemeItaliano _seme) {
		this.valoreIta=_valore;
		this.semeIta=_seme;
		this.ita=true;
		this.fra=false;
	}
	/**
	 * @param card carta da controllare
	 * @return 0 se il valore è uguale, minore di 0 se il valore di card è più alto, maggiore di 0 se il valore di card è più basso
	 * */
	public int piuAlta(Carta card) {
		if(this.ita)
			return this.valoreIta.compareTo(card.valoreIta);
		else
			return this.valoreFra.compareTo(card.valoreFra);
	}

	/**
	 * @return Stringa descrizione della carta
	 * */
	public String toString() {
		String desc="";
		if(this.ita) 
			desc = this.valoreIta+" di "+this.semeIta;
		else if(this.fra) 
			desc = this.valoreFra+" di "+this.semeFra;
		return desc;
	}

}
