package it.eliacotticottini.main;

import java.util.ArrayList;

import utils.IO;

public class MainCorsaCiclistica {

	private static final String INTESTAZIONE="Programma Corsa Ciclistica";
	private static final String NOME_TAPPA="Inserisci il nome della tappa";
	private static final String ALTRE_TAPPE="Vuoi aggiugnere altre tappe?";
	private static final String ALTRE_LOCALITA="Vuoi aggiungere altre localita?";
	private static final String DISTANZA_CORSA="Distanza percorsa: %.2fkm";
	private static final String DISLIVELLO_SALITA="Dislivello salite: %dm";
	private static final String DISLIVELLO_DISCESA="Dislivello discese: %dm";
	private static final String RIEPILOGO="Riepilogo corsa";

	public static void main(String[] args) {
		ArrayList<Tappa> tappe=new ArrayList<Tappa>();
		boolean finitoTappe=false;
		System.out.println(INTESTAZIONE);
		while(!finitoTappe) {
			System.out.println(NOME_TAPPA);
			String nome=IO.inputString();
			Tappa tappa=new Tappa(nome);
			boolean finitoLocalita=false;
			while(!finitoLocalita&&!tappa.isCircuito()) {
				tappa.addLocalita();
				if(!tappa.isCircuito())
					finitoLocalita=!IO.siNo(ALTRE_LOCALITA);
			}
			tappe.add(tappa);
			finitoTappe=!IO.siNo(ALTRE_TAPPE);
		}
		double distanzaCorsa=0;
		int dislivelloSalita=0;
		int dislivelloDiscesa=0;
		for(Tappa tappa : tappe) {
			System.out.println(tappa);
			distanzaCorsa+=tappa.calcoloDistanza();
			dislivelloSalita+=tappa.calcolaDislivelloSalita();
			dislivelloDiscesa+=tappa.calcolaDislivelloDiscesa();
		}
		System.out.println(RIEPILOGO);
		System.out.println(String.format(DISTANZA_CORSA, distanzaCorsa));
		System.out.println(String.format(DISLIVELLO_SALITA, dislivelloSalita));
		System.out.println(String.format(DISLIVELLO_DISCESA, dislivelloDiscesa));
	}
}
