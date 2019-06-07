package main;

import java.util.Random;

public class Strada {
	
	private static final String COLLISIONE_AUTO="Collisione tra auto a (%d;%d)";
	private static final String COLLISIONE_AUTO_PEDONE="Collisione tra auto e pedone a (%d:%d)";
	private static final String COLLISIONE_PEDONI="Collisione tra pedoni a (%d:%d)";

	private static final int VELOCITA_AUTO=3;
	private static final int VELOCITA_PEDONE=1;

	private int righe;
	private int colonne;
	private Elemento[][] strada;

	public Strada(int dimRighe, int dimColonne) {
		this.righe=dimRighe;
		this.colonne=dimColonne;
		this.strada=new Elemento[dimRighe][dimColonne];
		for(int i=0;i<dimRighe;i++)
			for(int j=0;j<dimColonne;j++){
				Random rand=new Random();
				switch(Math.abs(rand.nextInt())%10) {
				case 0://10% pedone
					strada[i][j]=new Pedone(VELOCITA_PEDONE);
					break;
				case 1://10% auto
					strada[i][j]=new Auto(VELOCITA_AUTO);
					break;
				default://80% vuoto
					strada[i][j]=new Vuoto();
				}
			}
	}
	
	private Elemento[][] stradaVuota(){
		Elemento[][] stradaVuota=new Elemento[this.righe][this.colonne];
		for(int i=0;i<this.righe;i++)
			for(int j=0;j<this.colonne;j++)
				stradaVuota[i][j]=new Vuoto();
		return stradaVuota;
	}

	public void avanza() {
		Elemento[][] stradaNuova=stradaVuota();
		for(int i=0;i<this.righe;i++)
			for(int j=0;j<this.colonne;j++){
				Elemento corrente=this.strada[i][j];
				int velocitaElementoAttuale=corrente.getVelocita();
				try {
					if(corrente.getClass()==Auto.class) {
						//se corrente è un'auto
						int posFutura=j+velocitaElementoAttuale;
						Elemento futuro=this.strada[i][posFutura];
						if(futuro.getClass()==Vuoto.class)
							//se c'è il vuoto non succede nulla
							stradaNuova[i][posFutura]=corrente;
						else if(futuro.getClass()==Auto.class){
							//entrambe tra auto, vengono cancellate entrambe
							System.out.println(String.format(COLLISIONE_AUTO,i,posFutura));
							stradaNuova[i][posFutura]=new Vuoto();
							this.strada[i][j]=new Vuoto();
						}else {
							//se collidono un'auto e un pedone, il pedone viene cancellato
							System.out.println(String.format(COLLISIONE_AUTO_PEDONE,i,posFutura));
							stradaNuova[i][posFutura]=corrente;
							this.strada[i][posFutura]=new Vuoto();
						}
					}else if(corrente.getClass()==Pedone.class) {
						//se corrente è un pedone
						int posFutura=i+velocitaElementoAttuale;
						Elemento futuro=this.strada[posFutura][j];
						if(futuro.getClass()==Vuoto.class)
							//se c'è il vuoto non succede nulla
							stradaNuova[posFutura][j]=corrente;
						else if(futuro.getClass()==Auto.class){
							//se collidono un'auto e un pedone, il pedone viene cancellato
							System.out.println(String.format(COLLISIONE_AUTO_PEDONE,posFutura,j));
							stradaNuova[posFutura][j]=futuro;
							this.strada[i][j]=new Vuoto();
						}else {
							//collisione tra pedoni, vengono cancellati entrambi
							System.out.println(String.format(COLLISIONE_PEDONI,posFutura,j));
							stradaNuova[posFutura][j]=new Vuoto();
							this.strada[i][j]=new Vuoto();
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					//se un elemento esce dalla strada viene cancellato
					stradaNuova[i][j]=new Vuoto();
				}
			}
		this.strada=stradaNuova;
	}
	
	public String toString() {
		StringBuffer desc=new StringBuffer();
		int numeroCaratteri=this.colonne*3+this.colonne+1;
		for(int i=0;i<this.righe;i++) {
			for(int k=0;k<numeroCaratteri;k++)
				desc.append("-");
			desc.append("\n|");
			for(int j=0;j<this.colonne;j++)
				desc.append(" "+this.strada[i][j]+" |");
			desc.append("\n");
		}
		for(int i=0;i<numeroCaratteri;i++)
			desc.append("-");
		
		return desc.toString();
	}

}
