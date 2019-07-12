package main;

public class Ricetta {

	private static final String PRIMO_PIATTO="Primo Piatto";
	private static final String SECONDO_PIATTO="Secondo Piatto";
	private static final String INGREDIENTI="\nIngredienti:\n";

	private String nome;
	private String descrizione;
	private Ingrediente[] ingredienti;
	private int[] quantita;
	private boolean isPrimoPiatto;

	public Ricetta(String _nome,String _descrizione, Ingrediente[] _ingredienti, int[] _quantita, boolean _primoPiatto) {
		this.nome=_nome;
		this.descrizione=_descrizione;
		this.ingredienti=_ingredienti;
		this.quantita=_quantita;
		this.isPrimoPiatto=_primoPiatto;
	}

	public String getNome() {
		return this.nome;
	}

	public int calcoloCalorie() {
		int i=0;
		int calorieTotali=0;
		for(Ingrediente ing : this.ingredienti) {
			calorieTotali+=ing.getCalorie()*(this.quantita[i]*0.01);
		}
		return calorieTotali;
	}

	public boolean isPrimoPiatto() {
		return this.isPrimoPiatto;
	}

	public String toString() {
		StringBuffer desc=new StringBuffer();
		desc.append(this.nome);
		desc.append(INGREDIENTI);
		int i=0;
		for(Ingrediente ing : this.ingredienti) {
			desc.append(this.quantita[i]+"g di "+ing+"\n");
			i++;
		}
		desc.append(this.descrizione+"\n");
		if(this.isPrimoPiatto)
			desc.append(PRIMO_PIATTO);
		else
			desc.append(SECONDO_PIATTO);
		desc.append("\nCalorie Totali: "+this.calcoloCalorie());
		return desc.toString();
	}

}
