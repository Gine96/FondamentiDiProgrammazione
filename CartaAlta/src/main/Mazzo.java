package main;

import java.util.Random;

import main.Carta.SemeFrancese;
import main.Carta.SemeItaliano;
import main.Carta.ValoreFrancese;
import main.Carta.ValoreItaliano;

public class Mazzo {
	private static final String ITALIANE="Italiane";
	private static final String FRANCESI="Francesi";

	private Carta carte[];
	/**
	 * @param _tipo tipo di mazzo da usare (Francese o Italiano)
	 * */
	public Mazzo(String _tipo) {
		if(_tipo.equalsIgnoreCase(ITALIANE)) {
			carte=new Carta[40];
			int i=0;
			for(SemeItaliano seme : SemeItaliano.values()) 
				for(ValoreItaliano valore : ValoreItaliano.values()) {
					carte[i]=new Carta(valore,seme);
					i++;
				}
		}else if(_tipo.equalsIgnoreCase(FRANCESI)) {
			carte=new Carta[52];
			int i=0;
			for(SemeFrancese seme : SemeFrancese.values())
				for(ValoreFrancese valore : ValoreFrancese.values()) {
					carte[i]=new Carta(valore,seme);
					i++;
				}
		}
	}
	/**
	 * Estrae carta casuale dal mazzo
	 * @return carta estratta
	 * */
	public Carta estraiCartaCasuale() {
		Random rand=new Random();
		mischia();
		return carte[rand.nextInt(carte.length)];
	}

	private void mischia() {
		Random rand=new Random();
		for(int i=0;i<this.carte.length;i++) {
			int randomPosition = rand.nextInt(carte.length);
			Carta temp = carte[i];
			carte[i] = carte[randomPosition];
			carte[randomPosition] = temp;
		}
	}

	/**
	 * @return Stringa del mazzo
	 * */
	public String toString() {
		StringBuffer desc=new StringBuffer();
		for(int i=0;i<carte.length;i++) 
			desc.append(carte[i].toString()+"\n");
		return desc.toString();
	}
}
