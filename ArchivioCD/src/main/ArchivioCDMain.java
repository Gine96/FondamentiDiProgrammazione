package main;

import utils.IO;
import utils.MyMenu;

public class ArchivioCDMain {
	private static final String MESS_STOP="Vuoi terminare l'esecuzione?";
	private static final String MESS_CHIUSURA="Arrivederci";
	private static final String MESS_OPZIONE_NON_VALIDA="Inserisci un opzione valida";
	
	private static final String MESS_CD_NON_CONTENUTO="Il cd non è contenuto";
	private static final String MESS_CD_CONTENUTO="Questo cd è già presente nell'archivio";
	private static final String MESS_AGGIUNGI_BRANO="Vuoi aggiungere un altro brano";
	
	private static final String INS_TITOLO_CD="Inserisci il titolo del cd";
	private static final String INS_AUTORE="Inserisci l'autore del cd";
	private static final String INS_BRANI="Inserisci i brani";
	private static final String INS_TITOLO_BRANO="Inserisci il titolo del brano";
	private static final String INS_DURATA_BRANO="Inserisci la durata del brano in secondi (almeno 1)";
	
	private static final String TITOLO_MENU_PRINCIPALE="Menu Principale";
	private static final String OPZIONI[]= {
			"Seleziona CD",
			"Aggiungi CD",
			"Elimina CD",
			"Mostra archivio",
			"Seleziona brano casuale"
	};
	
	public static void main(String[] args) {
		boolean stop=false;
		MyMenu menuPrincipale=new MyMenu(TITOLO_MENU_PRINCIPALE,OPZIONI);
		ArchivioCD archivio=new ArchivioCD();
		while(!stop) 
			stop=scelta(menuPrincipale.scelta(),archivio);
		System.out.println(MESS_CHIUSURA);
	}
	
	public static boolean scelta(int opzione, ArchivioCD archivio) {
		switch(opzione) {
		//Esci
		case 0:
			return IO.siNo(MESS_STOP);
		//Seleziona CD
		case 1:
			System.out.println(OPZIONI[0]);
			System.out.println(INS_TITOLO_CD);
			CD selezionato = archivio.cercaCD(IO.inputString());
			if(selezionato!=null) 
				System.out.println(selezionato.toString());
			else
				System.out.println(MESS_CD_NON_CONTENUTO);
			break;
		//Aggiungi CD
		case 2:
			System.out.println(OPZIONI[1]);
			System.out.println(INS_TITOLO_CD);
			creaCD(archivio);
			break;
		//Elimina CD
		case 3:
			System.out.println(OPZIONI[2]);
			System.out.println(INS_TITOLO_CD);
			CD scelto = archivio.cercaCD(IO.inputString());
			if(scelto!=null)
				archivio.eliminaCD(scelto);
			else
				System.out.println(MESS_CD_NON_CONTENUTO);
			break;
		//Mostra archivio
		case 4:
			System.out.println(OPZIONI[3]);
			System.out.println(archivio.toString());
			break;
		//Seleziona casuale
		case 5:
			//System.out.println(OPZIONI[4]);
			archivio.selezionaCasuale();
			break;
		/*
		 * Non viene mai eseguito perchè nella classe MyMenu viene eseguito un controllo
		 * sulla selezione delle opzioni 
		 * */
		default:
			System.out.println(MESS_OPZIONE_NON_VALIDA);
			break;
		}
		return false;
	}
	
	public static void creaCD(ArchivioCD arch) {
		String titoloCD=IO.inputString();
		if(arch.cercaCD(titoloCD)==null) {
			System.out.println(INS_AUTORE);
			String autore = IO.inputString();
			CD cd = new CD(titoloCD,autore);
			System.out.println(INS_BRANI);
			boolean continua = true;
			while(continua) {
				System.out.println(INS_TITOLO_BRANO);
				String titoloBrano=IO.inputString();
				System.out.println(INS_DURATA_BRANO);
				int durataBrano=IO.inputInt(1);
				Brano brano=new Brano(titoloBrano,durataBrano);
				cd.aggiungiBrano(brano);
				continua=IO.siNo(MESS_AGGIUNGI_BRANO);
			}
			arch.aggiungiCD(cd);
		}else
			System.out.println(MESS_CD_CONTENUTO);
	}
}
