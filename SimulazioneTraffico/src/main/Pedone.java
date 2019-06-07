package main;

public class Pedone extends Elemento{

	private static final String PEDONE="P";
	
	public Pedone(int _velocita) {
		super(_velocita);
	}

	public String toString() {
		return PEDONE;
	}
}
