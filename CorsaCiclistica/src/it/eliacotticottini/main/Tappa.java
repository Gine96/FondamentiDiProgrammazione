package it.eliacotticottini.main;

import java.util.ArrayList;

import utils.IO;

public class Tappa {

	private static final String INTESTAZIONE="\nLOCALITA'\tDISTANZA\tALTITUDINE\n";
	private static final String LOCALITA_PRESENTE="Localita gia' presente";
	private static final String CIRCUITO="Si tratta di un circuito?";
	private static final String NOME_LOCALITA="Inserisci il nome della localita";
	private static final String QUANTI_GIRI="Quante volte viene percorso il circuito? ";
	private static final String ALTRA_LOCALITA="Inserisci un'altra localita";
	private static final String DISTANZA="Inserisci la distanza in chilometri dalla precedente localita";
	private static final String ALTITUDINE="Inserisci l'altitudine in metri della localita";
	private static final String CIRCUITO_CHIUSO="Il circuito e' chiuso, non si possono inserire altre localita";
	private static final String DISTANZA_PERCORSA="Distanza percorsa: %.2fkm\n";
	private static final String DISLIVELLO_SALITE="Dislivello salite: %dm\n";
	private static final String DISLIVELLO_DISCESE="Dislivello discese: %dm\n";
	private static final String DESC_CIRCUITO="\nCircuito: %d giri";

	private ArrayList<Localita> localita;
	private int giriCircuito;
	private boolean isCircuito;
	private String nome;
	/**
	 * @param _nome - nome della tappa
	 * */
	public Tappa(String _nome) {
		localita=new ArrayList<Localita>();
		this.nome=_nome;
		this.giriCircuito=0;
		this.isCircuito=false;
	}
	/**
	 * @return <code>true</code> se la tappa e' un circuito<br><code>false</code> se non lo e'
	 * */
	public boolean isCircuito() {
		return this.isCircuito;
	}
	/**
	 * Metodo per la creazione e l'aggiunta di una localita alla tappa
	 * */
	public void addLocalita() {
		if(!this.isCircuito) {
			System.out.println(NOME_LOCALITA);
			String nomeLocalita=IO.inputString();
			boolean giaInserita=false;
			for(Localita loc : this.localita) 
				if(loc.getNome().contentEquals(nomeLocalita)) {
					System.out.println(LOCALITA_PRESENTE);
					if(IO.siNo(CIRCUITO)) {
						this.isCircuito=true;
						System.out.println(QUANTI_GIRI);
						this.giriCircuito=IO.inputInt(1);
						giaInserita=true;
					}else 
						while(loc.getNome().contentEquals(nomeLocalita)) {
							System.out.println(ALTRA_LOCALITA);
							nomeLocalita=IO.inputString();
						}
				}
			double distanzaLocalitaPrecedente;
			if(this.localita.size()==0) 
				distanzaLocalitaPrecedente=0;
			else {
				System.out.println(DISTANZA);
				distanzaLocalitaPrecedente=IO.inputDouble(0);
			}
			int altitudine=0;
			if(!giaInserita) {
				System.out.println(ALTITUDINE);
				altitudine=IO.inputInt(0);
			}else
				altitudine=this.cercaLocalita(nomeLocalita).getAltitudine();
			Localita inserimento=new Localita(nomeLocalita, distanzaLocalitaPrecedente, altitudine);
			this.localita.add(inserimento);
		}else 
			System.out.println(CIRCUITO_CHIUSO);

	}

	private Localita cercaLocalita(String nome) {
		for(Localita loc:this.localita)
			if(loc.getNome().contentEquals(nome))
				return loc;
		return null;//non dovrebbe mai verificarsi
	}
	/**
	 * @return distanza percorsa nella tappa
	 * */
	public double calcoloDistanza() {
		double distanzaTotale=0;
		for(Localita loc : this.localita)
			distanzaTotale+=loc.getDistanzaDallaPrecedente();
		if(this.isCircuito) 
			distanzaTotale*=giriCircuito;
		return distanzaTotale;
	}
	/**
	 * @return dislivello delle salite della tappa
	 * */
	public int calcolaDislivelloSalita() {
		int dislivello=0;
		for(int i=0;i<this.localita.size()-1;i++) {
			Localita esaminata=this.localita.get(i);
			Localita successiva=this.localita.get(i+1);
			if(esaminata.getAltitudine()<successiva.getAltitudine()) 
				dislivello+=(successiva.getAltitudine()-esaminata.getAltitudine());
		}
		return dislivello;
	}
	/**
	 * @return dislivello delle discese della tappa
	 * */
	public int calcolaDislivelloDiscesa() {
		int dislivello=0;
		for(int i=0;i<this.localita.size()-1;i++) {
			Localita esaminata=this.localita.get(i);
			Localita successiva=this.localita.get(i+1);
			if(esaminata.getAltitudine()>successiva.getAltitudine()) 
				dislivello+=(esaminata.getAltitudine()-successiva.getAltitudine());
		}
		return dislivello;
	}
	/**
	 * @return stringa descrittiva della tappa, con elenco delle localita e dati relativi
	 * */
	public String toString() {
		StringBuffer desc=new StringBuffer();
		desc.append(this.nome);
		if(this.isCircuito)
			desc.append(String.format(DESC_CIRCUITO, this.giriCircuito));
		desc.append(INTESTAZIONE);
		for(Localita loc:this.localita) 
			desc.append(loc);
		desc.append(String.format(DISTANZA_PERCORSA, this.calcoloDistanza()));
		desc.append(String.format(DISLIVELLO_SALITE, this.calcolaDislivelloSalita()));
		desc.append(String.format(DISLIVELLO_DISCESE, this.calcolaDislivelloDiscesa()));
		return desc.toString();
	}

}
