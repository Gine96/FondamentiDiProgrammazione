package main;

import utils.IO;
import utils.MyMenu;

public class CartaAltaMain {
	private static final String INSERISCI_NOME="Inserisci il nome del giocatore";
	private static final String INSERISCI_SALDO="Inserisci il denaro iniziale";
	private static final String MESS_USCITA="Arrivederci";
	private static final String MESS_ESTRAZIONE="Hai estratto:";
	private static final String MESS_ESTRAZIONE_BANCO="Il banco ha estratto:";
	private static final String MESS_PUNTARE="Quanto vuoi puntare su questa carta?(min 1€)";
	private static final String VALORE_UGUALE="%s ha lo stesso valore di %s";
	private static final String VALORE_PIU_ALTO="%s è più alta di %s";
	private static final String VALORE_PIU_BASSO="%s è più bassa di %s";
	private static final String PUNTATA_PERSA="Hai perso %d€";
	private static final String PUNTATA_VINTA="Hai vinto %d€";
	private static final String GAME_OVER="Hai perso tutti i soldi!\nGAME OVER";

	private static final String MENU_PRINCIPALE="Menù Carta Alta";
	private static final String OPZIONI_PRINCIPALE[]= {
			"Gioca",
			"Vedi Mazzo"
	};
	private static final String MENU_MAZZO="Menù scelta mazzo";
	private static final String OPZIONI_SCELTA_MAZZO[]= {
			"Italiane",
			"Francesi"
	};

	private static Mazzo mazzo;
	private static Giocatore player;

	public static void main(String[] args) {
		creaGiocatore();
		boolean stop=sceltaMazzo();
		MyMenu menuPrincipale=new MyMenu(MENU_PRINCIPALE, OPZIONI_PRINCIPALE);
		while(!stop) {
			System.out.println(player);
			stop=scelta(menuPrincipale.scelta());
		}

	}

	private static boolean scelta(int _opzione) {
		switch (_opzione) {
		case 0://Esci
			System.out.println(MESS_USCITA);
			return true;
		case 1://Gioca
			boolean stop=gioca();
			if(stop)
				System.out.println(GAME_OVER);
			return stop;
		case 2://Vedi mazzo
			System.out.println(mazzo.toString());
			break;
		}
		return false;
	}

	private static boolean gioca() {
		Carta estratta=mazzo.estraiCartaCasuale();
		System.out.println(MESS_ESTRAZIONE);
		System.out.println(estratta.toString());
		System.out.println(MESS_PUNTARE);
		int puntata=IO.inputInt(1,player.getSoldi());
		Carta estrattaBanco=mazzo.estraiCartaCasuale();
		System.out.println(MESS_ESTRAZIONE_BANCO);
		System.out.println(estrattaBanco.toString());
		if(estratta.piuAlta(estrattaBanco)==0) 
			System.out.println(String.format(VALORE_UGUALE, estratta, estrattaBanco));
		else if(estratta.piuAlta(estrattaBanco)<0) {
			System.out.println(String.format(VALORE_PIU_BASSO, estratta, estrattaBanco));
			System.out.println(String.format(PUNTATA_PERSA, puntata));
			player.removeSoldi(puntata);
		}else {
			System.out.println(String.format(VALORE_PIU_ALTO, estratta, estrattaBanco));
			System.out.println(String.format(PUNTATA_VINTA, puntata));
			player.addSoldi(puntata);
		}
		return player.getSoldi()<=0?true:false;
	}

	private static boolean sceltaMazzo() {
		MyMenu menuMazzo=new MyMenu(MENU_MAZZO, OPZIONI_SCELTA_MAZZO);
		switch (menuMazzo.scelta()) {
		case 0:
			System.out.println(MESS_USCITA);
			return true;
		case 1://Italiane
			mazzo=new Mazzo(OPZIONI_SCELTA_MAZZO[0]);
			break;
		case 2://Francesi
			mazzo=new Mazzo(OPZIONI_SCELTA_MAZZO[1]);
			break;
		}
		return false;
	}

	private static void creaGiocatore() {
		System.out.println(INSERISCI_NOME);
		String nome=IO.inputString();
		System.out.println(INSERISCI_SALDO);
		int denaro=IO.inputInt(1);
		player=new Giocatore(nome, denaro);
	}
}
