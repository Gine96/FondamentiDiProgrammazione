package main;

import java.util.ArrayList;

public class ElencoRicette {

	private static final String RICETTA_PRESENTE="Ricetta presente in elenco";
	private static final String RICETTA_NON_PRESENTE="Ricetta non presente in elenco";

	private ArrayList<Ricetta> ricette;

	public ElencoRicette() {
		ricette=new ArrayList<Ricetta>();
	}

	public void addRicetta(Ricetta ricetta) {
		if(!this.ricette.contains(ricetta))
			this.ricette.add(ricetta);
		else
			System.out.println(RICETTA_PRESENTE);
	}

	public void removeRicetta(Ricetta ricetta) {
		if(this.ricette.contains(ricetta))
			this.ricette.remove(ricetta);
		else
			System.out.println(RICETTA_NON_PRESENTE);
	}

	public Ricetta getRicetta(int index) {
		return this.ricette.get(index);
	}

	public int size() {
		return this.ricette.size();
	}

	public String toString() {
		StringBuffer desc=new StringBuffer();
		int i=0;
		for(Ricetta ric:this.ricette) {
			i++;
			desc.append(i+"- "+ric.getNome()+", "+ric.calcoloCalorie());
		}
		return desc.toString();
	}

}
