package main;

import java.util.ArrayList;

public class ElencoIngredienti {
	private static final String INGREDIENTE_PRESENTE="Ingrediente presente in elenco";
	private static final String INGREDIENTE_NON_PRESENTE="Ingrediente non presente in elenco";

	ArrayList<Ingrediente> ingredienti;

	public ElencoIngredienti() {
		ingredienti=new ArrayList<Ingrediente>();
	}

	public void addIngrediente(Ingrediente ingrediente) {
		if(!this.ingredienti.contains(ingrediente))
			this.ingredienti.add(ingrediente);
		else
			System.out.println(INGREDIENTE_PRESENTE);
	}

	public void removeIngrediente(Ingrediente ingrediente) {
		if(this.ingredienti.contains(ingrediente))
			this.ingredienti.remove(ingrediente);
		else
			System.out.println(INGREDIENTE_NON_PRESENTE);
	}

	public Ingrediente getIngrediente(int index) {
		return this.ingredienti.get(index);
	}

	public int size() {
		return this.ingredienti.size();
	}

	public String toString() {
		StringBuffer desc=new StringBuffer();
		int i=0;
		for(Ingrediente ing : this.ingredienti) {
			i++;
			desc.append(i+"- "+ing.toString());
		}
		return desc.toString();
	}
}
