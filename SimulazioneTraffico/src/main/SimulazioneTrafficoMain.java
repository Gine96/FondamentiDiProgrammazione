package main;

import utils.IO;

public class SimulazioneTrafficoMain {	

	private static final String BENVENUTO = "Benvenuto in Simulazione Traffico";
	private static final String CONTINUA = "Vuoi continuare con la simulazione?";
	private static final String ARRIVEDERCI = "Arrivederci";
	private static final String SIMULAZIONE_TERMINATA = "La simulazione e' terminata";

	public static void main(String[] args) {
		System.out.println(BENVENUTO);
		Strada strada=new Strada(4,10);
		System.out.println(strada);
		boolean finito=false;
		while(!finito) {
			finito=!IO.siNo(CONTINUA)||!strada.simulazioneTerminata();
			if(!finito) {
				strada.avanza();
				System.out.println(strada);
			}
		}
		System.out.println(SIMULAZIONE_TERMINATA);
		System.out.println(ARRIVEDERCI);

	}
}
