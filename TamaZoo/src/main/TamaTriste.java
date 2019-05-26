package main;

public class TamaTriste extends Tamagotchi{

	private static final String DESCRIZIONE="%s\t%s\nSazietà: %.2f";

	private String tipo;

	/**
	 * @param _nome - nome del tamatriste
	 * @param _sazieta - valore iniziale sazietà
	 * */
	public TamaTriste(String _nome, double _sazieta) {
		super(_nome, 0, _sazieta);
		this.tipo="TRISTE";
	}
	/**
	 * @return <code>true</code>
	 * */
	@Override
	public boolean sonoTriste() {
		controlloStato();
		return true;
	}
	/**
	 * @return <code>true</code> - se il valore di sazietà è 0 o 100%<br><code>false</code> - altrimenti 
	 * */
	@Override
	public boolean sonoMorto() {
		controlloStato();
		if(getSazieta()==VALORE_MIN||getSazieta()==VALORE_MAX)
			return true;
		return false;
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
