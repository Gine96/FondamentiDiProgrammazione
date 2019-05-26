package main;

import java.io.File;
import utils.GestioneFile;
import utils.IO;

public class TitoliAzionariMain {

	private static final String NOME_FILE="titoli_azionari.dat";

	private static final String CARICAMENTO_OK="Caricamento del file andato a buon fine";
	private static final String ERRORE_CAST="Errore riguardante il cast";
	private static final String FILE_NON_TROVATO="File %s non trovato";
	private static final String CREAZIONE_FILE="Creazione nuovo file '%s'";

	private static final String INSERISCI_QUANTITA="Inserisci il numero di azioni possedute di %s (min 0):";
	private static final String INSERISCI_NOME_TITOLO="Inserisci il nome del titolo da aggiungere:";
	private static final String INSERISCI_VALORE_TITOLO="Inserisci il valore di questo titolo (min 0):";
	private static final String CONTINUA_AGGIUNTA_TITOLI="Vuoi aggiungere ancora Titoli?";
	private static final String INSERISCI_NOME_PORTAFOGLIO="Inserisci un nome per il portafoglio:";

	private static final String SITUAZIONE_ATTUALE="Situazione al giorno %d";
	private static final String DOMANDA_SIMULAZIONE="Vuoi passare al giorno successivo?";

	public static void main(String[] args) {
		File file=new File(NOME_FILE);
		//� pi� facile da gestire il file avendo un solo oggetto da salvare e caricare
		Contenitore contenitore=null;
		ElencoTitoli titoli=null;
		Portafoglio portafoglio=null;

		boolean caricamentoCompletato=false;
		//controllo esistenza file per un eventuale caricamento
		if (file.exists()) {
			/*
			 * qua controlla che il cast funzioni correttamente in quanto GestioneFile.caricaOggetto(file) 
			 * � di tipo Object
			 * */
			try {
				contenitore = (Contenitore) GestioneFile.caricaOggetto(file);
				portafoglio = contenitore.getPortafoglio();
				titoli = contenitore.getElencoTitoli();
			} catch (ClassCastException e) {
				System.out.println(ERRORE_CAST);
			} catch (NullPointerException e){
				/*
				 * si verifica quando il file non viene caricato correttamente e portafoglio=contenitore.getPortafoglio()
				 * genera un'eccezione
				 * */
				System.out.println(e);
			}finally {
				//Controlla che il caricamento abbia funzionato
				if (contenitore!=null) {
					System.out.println(CARICAMENTO_OK);
					caricamentoCompletato = true;
				}
			}
		}

		if(!caricamentoCompletato) {
			System.out.println(String.format(FILE_NON_TROVATO, NOME_FILE));
			System.out.println(String.format(CREAZIONE_FILE, NOME_FILE));
			titoli=creaElencoTitoli();
			portafoglio=creaPortafoglio(titoli);
		}
		int giorno=0;
		boolean prosegui;
		do{
			giorno++;
			System.out.println(String.format(SITUAZIONE_ATTUALE, giorno));
			System.out.println(portafoglio);
			prosegui=IO.siNo(DOMANDA_SIMULAZIONE);
			if(prosegui)
				portafoglio.simulaVariazione();
		}while(prosegui);

		contenitore = new Contenitore(portafoglio, titoli);
		GestioneFile.salvaOggetto(file, contenitore);
		System.out.println("Salvataggio completato!");
		System.out.println("arrivederci!");

	}

	private static ElencoTitoli creaElencoTitoli() {
		ElencoTitoli elenco=new ElencoTitoli();
		boolean finito=false;
		while(!finito) {
			System.out.println(INSERISCI_NOME_TITOLO);
			String nome=IO.inputString();
			System.out.println(INSERISCI_VALORE_TITOLO);
			double valore=IO.inputDouble(0);
			Titolo titolo=new Titolo(nome, valore);
			elenco.addTitolo(titolo);
			finito=!IO.siNo(CONTINUA_AGGIUNTA_TITOLI);
		}
		return elenco;
	}

	private static Portafoglio creaPortafoglio(ElencoTitoli elencoTitoli) {
		System.out.println(INSERISCI_NOME_PORTAFOGLIO);
		Portafoglio portafoglio=new Portafoglio(IO.inputString(), elencoTitoli);
		for(int i=0;i<elencoTitoli.numeroTitoli();i++) {
			System.out.println(String.format(INSERISCI_QUANTITA, elencoTitoli.getTitolo(i).getNome()));
			portafoglio.addLotto(new Lotto(elencoTitoli.getTitolo(i), IO.inputInt(0)));
		}
		return portafoglio;
	}

}
