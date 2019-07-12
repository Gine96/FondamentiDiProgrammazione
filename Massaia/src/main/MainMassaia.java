package main;

import utils.IO;
import utils.MyMenu;

public class MainMassaia {

	private static final String NOME_PRINCIPALE="Menu Principale";
	private static final String VOCI[]= {
			"Crea Menu",
			"Vedi Ingredienti",
			"Vedi Ricette",
			"Inserisci Ingrediente",
			"Inserisci Ricetta",
			"Rimuovi Ingrediente",
			"Rimuovi Ricetta"
	};

	private static ElencoIngredienti ingredienti;
	private static ElencoRicette ricette;

	public static void main(String[] args) {
		ingredienti=new ElencoIngredienti();
		ricette=new ElencoRicette();
		MyMenu principale=new MyMenu(NOME_PRINCIPALE, VOCI);
		boolean finito=false;
		while(!finito) {
			finito=continua(principale.scelta());
		}
	}

	private static boolean continua(int scelta) {
		switch(scelta) {
		case 0://ESCI
			return true;
		case 1://Crea menu
			System.out.println("Inserisci il valore massimo di calorie per il tuo menu");
			int calMax=IO.inputInt(0);
			int sommaCalorie=0;

			break;
		case 2://Vedi ingredienti
			System.out.println(ingredienti);
			break;
		case 3://vedi ricette
			System.out.println(ricette);
			break;
		case 4://inserisci ingredienti
			System.out.println("Inserisci il nome dell'ingrediente che vuoi inserire");
			String nomeIng=IO.inputString();
			System.out.println("Inserisci le calorie per 100g");
			int calories=IO.inputInt(0);
			Ingrediente ing=new Ingrediente(nomeIng,calories);
			ingredienti.addIngrediente(ing);
			break;
		case 5://inserisci ricetta
			System.out.println("Inserisci il nome della ricetta che vuoi inserire");
			String nomeRic=IO.inputString();
			System.out.println("Inserisci il numero di ingredienti diversi per la tua ricetta");
			int numeroIngredienti=IO.inputInt(0);
			Ingrediente ingRicetta[]=new Ingrediente[numeroIngredienti];
			int ingredientiScelti[]=new int[numeroIngredienti];
			for(int i=0;i<numeroIngredienti;i++) {
				System.out.println(ingredienti);
				System.out.println("Scegli un ingrediente");
				int selezione=IO.inputInt(1, numeroIngredienti);
				ingredientiScelti[i]=selezione;
				for(int k : ingredientiScelti) 
					while(k==selezione) {
						System.out.println("Scegli un ingrediente diverso");
						selezione=IO.inputInt(1,numeroIngredienti);
					}
				ingRicetta[i]=ingredienti.getIngrediente(selezione-1);
			}
			int quantitaIngredienti[]=new int[numeroIngredienti];
			int j=0;
			for(Ingrediente ingrediente : ingRicetta) {
				System.out.println("Inserisci la quantita in grammi di "+ingrediente);
				quantitaIngredienti[j]=IO.inputInt(0);
				j++;
			}
			System.out.println("Inserisci la descrizione della ricetta");
			String descrizione=IO.inputString();
			boolean primo=IO.siNo("E' un primo piatto?");
			Ricetta ricetta=new Ricetta(nomeRic,descrizione,ingRicetta,quantitaIngredienti,primo);
			ricette.addRicetta(ricetta);
			break;
		case 6://rimuovi ingrediente
			System.out.println(ingredienti);
			System.out.println("Scegli quale rimuovere");
			Ingrediente rimuoviIng=ingredienti.getIngrediente(IO.inputInt(1, ingredienti.size())-1);
			ingredienti.removeIngrediente(rimuoviIng);
			break;
		case 7://rimuovi ricetta
			System.out.println(ricette);
			System.out.println("Scegli quale rimuovere");
			Ricetta rimuoviRic=ricette.getRicetta(IO.inputInt(1, ricette.size())-1);
			ricette.removeRicetta(rimuoviRic);
			break;
		}
		return false;
	} 
}
