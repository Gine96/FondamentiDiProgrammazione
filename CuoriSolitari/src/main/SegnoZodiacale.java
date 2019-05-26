package main;

public enum SegnoZodiacale {
	ARIETE("ariete"),
	TORO("toro"),
	GEMELLI("gemelli"),
	CANCRO("cancro"),
	LEONE("leone"),
	VERGINE("vergine"),
	BILANCIA("bilancia"),
	SCORPIONE("scorpione"),
	SAGITTARIO("sagittario"),
	CAPRICORNO("capricorno"),
	ACQUARIO("acquario"),
	PESCI("pesci");
	private String segnoZodiacale;
	private SegnoZodiacale(String string) {
		this.segnoZodiacale=string;
	}
	public String getSegnoZodiacale() {
		return segnoZodiacale;
	}
	
	/**
	 * @param string stringa da controllare
	 * @return true se la stringa inserita è un segno zodiacale valido
	 * */
	public static boolean checkSegno(String string) {
		for(SegnoZodiacale sign : SegnoZodiacale.values()){
			if(string.equalsIgnoreCase(sign.getSegnoZodiacale())) {
				return true;
			}
		}
		return false;
	}
}
