package main;

import utils.IO;
/**
 * Classe Tamagotchi
 * @author Elia Cotti Cottini
 * */
public class Tamagotchi {
	private static final String MESS_RINGRAZIAMENTO = "Grazie!";
	private static final String MESS_FAME="Ho fame!";
	private static final String MESS_INSODDISFATTO="Sono insoddisfatto!";
	private static final String MESS_VALORE_NON_VALIDO="Inserisci un valore tra 0 e %d";
	private static final String MESS_MORTO = "Oh no! %s è morto :c";
	private static final String MESS_FELICE = "Sono felice! :D";
	private static final String MESS_TRISTE = "Sono triste :c";
	
	private static final int MAX_VALUE=100;
	private static final int MAX_BISCOTTI=10;
	private static final int MAX_CAREZZE=10;
	private static final double SOGLIA_FELICITA=80;
	private static final double SOGLIA_FAME=20;
	private static final double SOGLIA_SODDISFAZIONE=20;
	
	private int soddisfazione,sazieta;
	private String nome;
	
	/**
	 * Costruttore per l'oggetto tamagotchi
	 * @param _soddisfazione valore iniziale di soddisfazione
	 * @param _sazieta valore iniziale di sazietà
	 * @param _nome nome del tamagotchi
	 * 
	 * */
	public Tamagotchi(String _nome,int _soddisfazione,int _sazieta) {
		this.soddisfazione=_soddisfazione;
		this.sazieta=_sazieta;
		this.nome=_nome;
	}
	//Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSoddisfazione() {
		return soddisfazione;
	}
	public void setSoddisfazione(int soddisfazione) {
		this.soddisfazione = soddisfazione;
	}
	public int getSazieta() {
		return sazieta;
	}
	public void setSazieta(int sazieta) {
		this.sazieta = sazieta;
	}
	
	/**
	 * Aggiorna e stampa lo stato del tamagotchi.
	 * Controlla i valori di sazietà e soddisfazione
	 * 
	 * */
	public void updateStato() {
		if(isVivo()) {
			if(isSazio()==-1)
				System.out.println(MESS_FAME);
			if(isSoddisfatto()==-1)
				System.out.println(MESS_INSODDISFATTO);
			if(isFelice())
				System.out.println(MESS_FELICE);
			if(isTriste())
				System.out.println(MESS_TRISTE);
			//Controllo min/max soddisfazione
			if(this.soddisfazione<0)
				this.soddisfazione=0;
			else if(this.soddisfazione>Tamagotchi.MAX_VALUE)
				this.soddisfazione=Tamagotchi.MAX_VALUE;
			//Controllo min/max sazietà
			if(this.sazieta<0)
				this.sazieta=0;
			else if(this.sazieta>Tamagotchi.MAX_VALUE)
				this.sazieta=Tamagotchi.MAX_VALUE;
			showStato();
		}else {
			showStato();
			System.out.println(String.format(MESS_MORTO, this.nome));
		}
	}
	private int isSazio() {
		if(this.sazieta<Tamagotchi.SOGLIA_FAME)
			return -1;
		else if(this.sazieta>Tamagotchi.SOGLIA_FELICITA)
			return 1;
		return 0;
	}
	private int isSoddisfatto() {
		if(this.soddisfazione<Tamagotchi.SOGLIA_SODDISFAZIONE)
			return -1;
		else if(this.soddisfazione>Tamagotchi.SOGLIA_FELICITA)
			return 1;
		return 0;
	}
	/**
	 * Controlla se il tamagotchi è felice o no
	 * @return <code>true</code> se sazietà e soddisfazione sono entrambe alte
	 * <p><code>false</code> altrimenti
	 * 
	 * */
	public boolean isFelice() {
		if(!isTriste()&&(isSazio()==1&&isSoddisfatto()==1))
			return true;
		return false;
	}
	/**
	 * Controlla se il tamagotchi è triste o no
	 * @return <code>true</code> se sazietà e soddisfazione sono entrambe basse o se la loro differenza è alta
	 * <p><code>false</code> altrimenti
	 * 
	 * */
	public boolean isTriste() {
		if((isSazio()==-1&&isSoddisfatto()==-1)||(Math.abs(this.soddisfazione-this.sazieta)>25))
			return true;
		return false;
	}
	
	/**
	 * Controlla se il tamagotchi è vivo o no
	 * @return <code>true</code> se è vivo; <code>false</code> altrimenti
	 * */
	public boolean isVivo() {
		if(this.sazieta<=0||this.soddisfazione<=0)
			return false;
		else
			return true;
	}
	/**
	 * Metodo per dare biscotti.
	 * Legge il valore intero del numero di biscotti da dare al tamagotchi
	 * e controlla che sia stato inserito un valore valido
	 * @param value numero di biscotti da dare
	 * */
	public void daiBiscotti(int value) {
		while(value>Tamagotchi.MAX_BISCOTTI||value<0) {
			System.out.println(String.format(MESS_VALORE_NON_VALIDO, Tamagotchi.MAX_BISCOTTI));
			value=IO.inputInt();
		}
		this.sazieta+=value;
		this.soddisfazione-=5;
		System.out.println(MESS_RINGRAZIAMENTO);
		//updateStato();
	}
	/**
	 * Metodo per fare carezze.
	 * Legge il valore intero del numero di carezze da fare al tamagotchi
	 * e controlla che sia stato inserito un valore valido
	 * @param value numero di carezze da fare
	 * */
	public void faiCarezze(int value) {
		while(value>Tamagotchi.MAX_CAREZZE||value<0) {
			System.out.println(String.format(MESS_VALORE_NON_VALIDO, Tamagotchi.MAX_CAREZZE));
			value=IO.inputInt();
		}
		this.soddisfazione+=value;
		this.sazieta-=5;
		System.out.println(MESS_RINGRAZIAMENTO);
		//updateStato();
	}
	/**
	 * Stampa il valore di sazietà e di soddisfazione del tamagotchi
	 * */
	public void showStato() {
		System.out.println("Sazietà: "+this.sazieta);
		System.out.println("Soddisfazione: "+this.soddisfazione);
	}
	
}
