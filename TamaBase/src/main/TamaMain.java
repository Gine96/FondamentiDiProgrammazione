package main;

import utils.IO;

public class TamaMain {
	private static final String SALUTO = "Benvenuto nel programma Tamagotchi";
	private static final String INIZIALIZZA = "Per iniziare crea il tuo tamagotchi";
	private static final String MESS_NOME = "Inserisci un nome:";
	private static final String MESS_VALORE_INIZIALE = "Inserisci un valore iniziale per la %s";
	private static final String SAZIETA="sazietà:";
	private static final String SODDISFAZIONE="soddisfazione:";
	private static final String MESS_VALORE_NON_VALIDO="Inserisci un valore valido!";
	private static final String MESS_SCELTA="Inserisci il numero corrispondente all'azione da svolgere:\n1.Dai biscotto\n2.Fai carezze\n3.Esci dal programma";
	private static final String MESS_CHIUSURA = "Ciao!";
	
	public static Tamagotchi tama;
	public static boolean stop=false;
	public static void main(String[] args) {
		System.out.println(SALUTO);
		creaTama();
		while(!stop&&tama.isVivo()) {
			System.out.println(MESS_SCELTA);
			int scelta=IO.inputInt();
			switch(scelta) {
			case 1:
				System.out.println("Quanti biscotti vuoi darmi?");
				tama.daiBiscotti(IO.inputInt());
				tama.updateStato();
				break;
			case 2:
				System.out.println("Quante carezze vuoi farmi?");
				tama.faiCarezze(IO.inputInt());
				tama.updateStato();
				break;
			case 3:
				System.out.println(MESS_CHIUSURA);
				stop=true;
				break;
			default:
				System.out.println(MESS_VALORE_NON_VALIDO);
				break;
			}
		}
	}
	
	private static void creaTama() {
		System.out.println(INIZIALIZZA);
		System.out.println(MESS_NOME);
		String tmpName=IO.inputString();
		System.out.println(String.format(MESS_VALORE_INIZIALE,SAZIETA));
		int tmpSaz=IO.inputInt();
		while(tmpSaz>100||tmpSaz<0) {
			System.out.println(MESS_VALORE_NON_VALIDO);
			tmpSaz=IO.inputInt();
		}
		System.out.println(String.format(MESS_VALORE_INIZIALE, SODDISFAZIONE));
		int tmpSodd=IO.inputInt();
		while(tmpSodd>100||tmpSodd<0) {
			System.out.println(MESS_VALORE_NON_VALIDO);
			tmpSodd=IO.inputInt();
		}
		tama = new Tamagotchi(tmpName,tmpSodd, tmpSaz);
	}
}
