package main;

public class Vuoto extends Elemento{
	
	private static final String SPAZIO=" ";

	public Vuoto() {
		super(0);
	}

	public String toString() {
		return SPAZIO;
	}
}
