package main;

public class TamaGordo extends Tamagotchi{

	private static final String DESCRIZIONE="%s\t%s\nSazietà: %.2f";

	private static final double FATTORE_SODDISFAZIONE=0.5;

	private String tipo;

	/**
	 * @param _nome - nome del tamagordo
	 * @param _sazieta - valore iniziale sazietà
	 * */
	public TamaGordo(String _nome, double _sazieta) {
		super(_nome, VALORE_MAX, _sazieta);
		this.tipo="INGORDO";
	}

	/**
	 * @return <code>true</code> - se la sazietà è minore del 30%<br><code>false</code> - altrimenti
	 * */
	@Override
	public boolean sonoTriste() {
		controlloStato();
		if(getSazieta()<VALORE_MAX*SOGLIA_MIN)
			return true;
		return false;
	}

	/**
	 * @return <code>true</code> - se la sazietà è pari a 0<br><code>false</code> - altrimenti
	 * */
	@Override
	public boolean sonoMorto() {
		controlloStato();
		if(getSazieta()==VALORE_MIN)
			return true;
		return false;
	}

	/**
	 * toglie il doppio della soddisfazione rispetto al modello normale
	 * */
	@Override
	public void riceviCarezze(int numeroCarezze) {
		setSazieta(getSazieta()-numeroCarezze*FATTORE_SODDISFAZIONE);
	}

	@Override
	public String toString() {
		controlloStato();
		StringBuffer desc=new StringBuffer();
		if(!sonoMorto()) {
			desc.append(String.format(DESCRIZIONE, getNome(), this.tipo, getSazieta()));
			if(sonoTriste())
				desc.append(String.format(MESS_INFELICE, getNome()));
		}else
			desc.append(String.format(MESS_MORTO, getNome()));
		desc.append("\n");
		return desc.toString();
	}

}
