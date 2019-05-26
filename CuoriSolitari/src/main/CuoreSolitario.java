package main;

public class CuoreSolitario {
	private String name;
	private char sesso;
	private int eta;
	private final int DIFF_ETA= 6;
	private SegnoZodiacale segno,segnoPartner;
	
	/*
	 * Getters & Setters
	 * */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public char getSesso() {
		return sesso;
	}
	public void setSesso(char sesso) {
		this.sesso = sesso;
	}
	public SegnoZodiacale getSegno() {
		return segno;
	}
	public void setSegno(SegnoZodiacale segno) {
		this.segno = segno;
	}
	public SegnoZodiacale getSegnoPartner() {
		return segnoPartner;
	}
	public void setSegnoPartner(SegnoZodiacale segnoPartner) {
		this.segnoPartner = segnoPartner;
	}
	
	
	/**
	 * @param c Persona da sottoporre al controllo affinità
	 * @return true se la persona è affine, false se non lo è
	 */
	public boolean isAffine(CuoreSolitario c) {
		if(!(this.sesso==c.getSesso())&&Math.abs(this.eta-c.getEta())<DIFF_ETA&&this.segnoAffine(c)) 
			return true;
		else
			return false;
	}
	private boolean segnoAffine(CuoreSolitario c) {
		if(this.segnoPartner==c.getSegno()&&this.segno==c.getSegnoPartner())
			return true;
		else
			return false;
	}
	
	public void show() {
		System.out.println(this.name);
	}
	
	
	
}
