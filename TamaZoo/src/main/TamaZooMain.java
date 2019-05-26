package main;

import java.util.Random;
import java.util.Vector;

import utils.IO;
import utils.MyMenu;

public class TamaZooMain {
	private static final String MESS_BENVENUTO="Benvenuto nel programma TamaZoo";
	private static final String MESS_USCITA="Sei sicuro di voler uscire?";
	private static final String MESS_ARRIVEDERCI="Arrivederci";
	
	private static final String INSERISCI_NOME="Inserisci un nome per #%d:";
	private static final String INSERISCI_NUMERO="Inserisci il numero di tamagotchi che vuoi creare:";
	
	private static final String MESS_BISCOTTI="Sono stati dati %d biscotti a tutti i tamagotchi";
	private static final String MESS_CAREZZE="Sono state fatte %d carezze a tutti i tamagotchi";

	private static final int MAX_AGGIUNTA=10;

	private static final String[] OPZIONI= {
			"Dai Biscotti",
			"Fai Carezze"
	};

	private static TamaZoo zoo;

	public static void main(String[] args) {
		System.out.println(MESS_BENVENUTO);
		creazioneZoo();
		System.out.println(zoo);
		MyMenu principale=new MyMenu("Menu Principale", OPZIONI);
		boolean finito=false;
		while(!finito) 
			finito=continua(principale.scelta());
		System.out.println(MESS_ARRIVEDERCI);
	}

	private static void creazioneZoo() {
		System.out.println(INSERISCI_NUMERO);
		int numeroTama=IO.inputInt(0);
		Vector<String> nomi=new Vector<String>();
		for(int i=0;i<numeroTama;i++) {
			System.out.println(String.format(INSERISCI_NOME, i+1));
			nomi.add(IO.inputString());
		}
		zoo=new TamaZoo(nomi, numeroTama);
	}

	private static boolean continua(int scelta) {
		Random rand=new Random();
		int numeroCasuale=rand.nextInt(MAX_AGGIUNTA);
		while(numeroCasuale<0)
			numeroCasuale=rand.nextInt(MAX_AGGIUNTA);
		switch(scelta) {
		case 0://Esci
			return IO.siNo(MESS_USCITA);
		case 1://dai biscotti
			zoo.riceviBiscotti(numeroCasuale);
			System.out.println(String.format(MESS_BISCOTTI, numeroCasuale));
			break;
		case 2://fai carezze
			zoo.riceviCarezze(numeroCasuale);
			System.out.println(String.format(MESS_CAREZZE, numeroCasuale));
			break;
		}
		System.out.println(zoo);
		return zoo.sonoTuttiMorti();
	}
}