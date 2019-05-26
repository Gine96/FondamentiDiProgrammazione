package main;

public class Tamagotchi {
	protected static final String MESS_MORTO="%s è morto";
	protected static final String MESS_INFELICE=" è triste :c";

	private static final String DESCRIZIONE="%s\t%s\nSazietà: %.2f\tSoddisfazione: %.2f";

	private static final String VALORE_SAZIETA_NON_VALIDO="Valore inserito non valido";
	private static final String VALORE_SODDISFAZIONE_NON_VALIDO="Valore inserito non valido";

	protected static final int VALORE_MAX=100;
	protected static final int VALORE_MIN=0;
	protected static final double SOGLIA_MAX=0.9;
	protected static final double SOGLIA_MIN=0.3;
	private static final double FATTORE_SAZIETA=0.25;
	private static final double FATTORE_SODDISFAZIONE=0.5;

	private String nome;
	private String tipo;
	private double sazieta;
	private double soddisfazione;
	/**
	 * @param _nome - nome del tamagotchi
	 * @param _soddisfazione - grado di soddisfazione iniziale (positivo)
	 * @param _sazieta - grado di sazietà iniziale (positivo)
	 * */
	public Tamagotchi(String _nome, double _soddisfazione, double _sazieta) {
		if(_soddisfazione<VALORE_MIN||_soddisfazione>VALORE_MAX)
			throw new IllegalArgumentException(VALORE_SAZIETA_NON_VALIDO);
		if(_sazieta<VALORE_MIN||_sazieta>VALORE_MAX)
			throw new IllegalArgumentException(VALORE_SODDISFAZIONE_NON_VALIDO);
		this.nome=_nome;
		this.tipo="NORMALE";
		this.sazieta=_sazieta;
		this.soddisfazione=_soddisfazione;
	}

	/**
	 * @return <code>true</code> - se la sazietà non è tra 30% e 90% e la soddisfazione è minore del 30%<br><code>false</code> - altrimenti
	 * */
	public boolean sonoTriste() {
		controlloStato();
		if(this.sazieta<VALORE_MAX*SOGLIA_MIN||this.sazieta>VALORE_MAX*SOGLIA_MAX||this.soddisfazione<VALORE_MAX*SOGLIA_MIN)
			return true;
		return false;
	}

	/**
	 * @return <code>true</code> - se la sazietà è al 100% o se uno dei due valori raggiunge 0<br><code>false</code> - altrimenti
	 * */
	public boolean sonoMorto() {
		controlloStato();
		if(this.sazieta==VALORE_MAX||this.sazieta==VALORE_MIN||this.soddisfazione==VALORE_MIN)
			return true;
		return false;
	}
	/**
	 * @param numeroBiscotti - numero di biscotti da dare al tamagotchi
	 * */
	public void riceviBiscotti(int numeroBiscotti) {
		for(int i=0;i<numeroBiscotti;i++)
			this.sazieta+=this.sazieta*0.1;
		this.soddisfazione-=numeroBiscotti*FATTORE_SODDISFAZIONE;
	}
	/**
	 * @param numeroCarezze - numero di carezze da fare al tamagotchi
	 * */
	public void riceviCarezze(int numeroCarezze) {
		this.soddisfazione+=numeroCarezze;
		this.sazieta-=numeroCarezze*FATTORE_SAZIETA;
	}
	//serve per controllare i valori dello stato
	protected void controlloStato() {
		if(this.sazieta<VALORE_MIN)
			this.sazieta=VALORE_MIN;
		if(this.sazieta>VALORE_MAX)
			this.sazieta=VALORE_MAX;
		if(this.soddisfazione<VALORE_MIN)
			this.soddisfazione=VALORE_MIN;
		if(this.soddisfazione>VALORE_MAX)
			this.soddisfazione=VALORE_MAX;
	}

	protected double getSazieta() {
		return sazieta;
	}

	protected void setSazieta(double sazieta) {
		this.sazieta = sazieta;
	}

	protected double getSoddisfazione() {
		return soddisfazione;
	}

	protected void setSoddisfazione(double soddisfazione) {
		this.soddisfazione = soddisfazione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return Stringa descrittiva del tamagotchi
	 * */
	public String toString() {
		controlloStato();
		StringBuffer desc=new StringBuffer();
		if(!sonoMorto()) {
			desc.append(String.format(DESCRIZIONE, this.nome, this.tipo , this.sazieta, this.soddisfazione));
			if(sonoTriste())
				desc.append(String.format(MESS_INFELICE, this.nome));
		}else
			desc.append(String.format(MESS_MORTO, this.nome));
		desc.append("\n");
		return desc.toString();
	}
}
