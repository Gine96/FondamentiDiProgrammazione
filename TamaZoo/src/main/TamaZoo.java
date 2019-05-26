package main;

import java.util.Random;
import java.util.Vector;

public class TamaZoo {
	private static final String ERRORE_NUMERO_TAMA="Il numero di tamagotchi deve essere almeno 1";
	//private static final String MORTO="%s è morto :c\n";
	private static final String TUTTI_MORTI="I tamagotchi dello zoo sono tutti morti :c";

	private Vector<Tamagotchi> tama;
	/**
	 * @param _nome - array di nomi dei tamagotchi
	 * @param _numeroTama - numero di tamagotchi da creare
	 * */
	public TamaZoo(Vector<String> _nome, int _numeroTama) {
		if(_numeroTama<1)
			throw new IllegalArgumentException(ERRORE_NUMERO_TAMA);
		tama=new Vector<Tamagotchi>();
		Random rand=new Random();
		for(int i=0;i<_numeroTama;i++) {
			int n=Math.abs(rand.nextInt());
			double randSodd=rand.nextDouble()*70+30;
			double randSaz=rand.nextDouble()*70+30;
			try {
				switch(n%3) {
				case 0:
					tama.add(new Tamagotchi(_nome.elementAt(i), randSodd, randSaz));
					break;
				case 1:
					tama.add(new TamaGordo(_nome.elementAt(i), randSodd));
					break;
				case 2:
					tama.add(new TamaTriste(_nome.elementAt(i), randSodd));
					break;
				}
			}catch (IllegalArgumentException e) {
				i--;
			}
		}
	}
	/**
	 * @param numeroBiscotti - numero di biscotti da dare a tutti i tamagotchi dello zoo
	 * */
	public void riceviBiscotti(int numeroBiscotti) {
		for(Tamagotchi tamagotchi : tama)
			if(!tamagotchi.sonoMorto())
				tamagotchi.riceviBiscotti(numeroBiscotti);
	}
	/**
	 * @param numeroCarezze - numero di carezze da fare a tutti i tamagotchi dello zoo
	 * */
	public void riceviCarezze(int numeroCarezze) {
		for(Tamagotchi tamagotchi : tama)
			if(!tamagotchi.sonoMorto())
				tamagotchi.riceviCarezze(numeroCarezze);
	}
	/**
	 * @return <code>true</code> - se sono tutti morti<br><code>false</code> - altrimenti
	 * */
	public boolean sonoTuttiMorti() {
		boolean tuttiMorti=true;
		for(Tamagotchi tamagotchi : tama)
			if(!tamagotchi.sonoMorto())
				tuttiMorti=false;
		return tuttiMorti;
	}
	/**
	 * @return Stringa descrittiva dello zoo
	 * */
	public String toString() {
		StringBuffer desc=new StringBuffer();
		for(Tamagotchi tamagotchi : tama) 
			desc.append(tamagotchi.toString());
		if(sonoTuttiMorti())
			return TUTTI_MORTI;
		return desc.toString();
	}

}
