package main;

public class Ingrediente {

	private String nome;
	private int calorie;

	/**
	 * @param _nome - nome dell'ingrediente
	 * @param _cal - calorie per ettogrammo
	 * */
	public Ingrediente(String _nome, int _cal) {
		this.nome=_nome;
		this.calorie=_cal;
	}

	public int getCalorie() {
		return this.calorie;
	}
	/**
	 * @return Stringa descrtittiva ingrediente
	 * */
	public String toString() {
		return this.nome+", "+this.calorie+" per hg";
	}
}
