package main;

import java.util.Random;
import java.util.Vector;

public class ArchivioCD {
	private static final String VUOTO="Archivio vuoto";
	
	private Vector<CD> elencoCD;
	
	public ArchivioCD() {
		this.elencoCD=new Vector<CD>();
	}

	/**
	 * Aggiungi un CD all'archivio
	 * @param _titolo titolo cd da aggiungere
	 * */
	public void aggiungiCD(String _titolo) {
		CD inserire = new CD(_titolo);
		this.aggiungiCD(inserire);
	}
	
	/**
	 * Aggiungi un CD all'archivio
	 * @param cd cd da aggiungere
	 * */
	public void aggiungiCD(CD cd) {
		this.elencoCD.add(cd);
	}
	/**
	 * @param titoloCD titolo del cd da cercare
	 * @return null se il cd cercato non è presente nell'archivio; cd cercato.
	 * */
	public CD cercaCD(String titoloCD) {
		int index=-1;
		for(int i=0;i<elencoCD.size();i++) {
			if(elencoCD.get(i).getTitolo().equals(titoloCD)) {
				index=i;
				break;
			}
		}
		if(index<0) {
			//System.out.println(CD_NON_CONTENUTO);
			return null;
		}else
			return elencoCD.get(index);
	}
	/**
	 * @param titoloCD titolo del cd da controllare
	 * @return true se contenuto; false se no
	 * */
	public boolean contiene(String titoloCD) {
		if(cercaCD(titoloCD)==null)
			return false;
		else
			return true;
	}
	/**
	 * Stringa elenco archivio
	 * @return stringa elenco
	 * */
	public String toString() {
		if(this.elencoCD.isEmpty())
			return VUOTO;
		else {
			StringBuffer desc=new StringBuffer();
			for(int i=0;i<elencoCD.size();i++) 
				desc.append("\n"+(i+1)+"\t"+elencoCD.get(i).getTitolo()+", "+elencoCD.get(i).getAutore());
			return desc.toString();
		}
	}
	/**
	 * Elimina il cd scelto
	 * @param _titolo titolo cd da eliminare
	 * */
	public void eliminaCD(String _titolo) {
		CD cercato = cercaCD(_titolo);
		this.elencoCD.remove(cercato);
	}
	
	/**
	 * Elimina il cd scelto
	 * @param cd cd da eliminare
	 * */
	public void eliminaCD(CD cd) {
		this.eliminaCD(cd.getTitolo());
	}
	/**
	 * Seleziona un cd casuale dall'archivio
	 * */
	public void selezionaCasuale() {
		if(elencoCD.isEmpty())
			System.out.println(VUOTO);
		else {
			Random rand = new Random();
			System.out.println(elencoCD.get(rand.nextInt(elencoCD.size())).selezionaBranoCasuale().toString());
		}
	}
	/**
	 * @return numero dei cd contenuti nell'archivio
	 * */
	public int getNumeroCd() {
		return elencoCD.size();
	}
	
}
