package main;

public class Main {
	private static final String AFFINE="%s è affine con %s";
	private static final String NON_AFFINE="%s non è affine con %s";
	private static final String NOME_CUORE="Inserisci un nome per il cuore #%d: ";
	private static final String SESSO_CUORE="Inserisci il sesso del cuore #%d(m/f): ";
	private static final String ETA_CUORE="Inserisci l'età del cuore #%d: ";
	private static final String SEGNO_CUORE="Inserisci il segno zodiacale del cuore #%d: ";
	private static int counterN=1;
	private static int counterS=1;
	private static int counterE=1;
	private static int counterZ=1;
	
	public static void main(String[] args) {
		
		System.out.println("Benvenuto nel programma Cuori Solitari\n");
		
		CuoreSolitario c1 = new CuoreSolitario();
		insNomeCuore();
		c1.setName(IO.inputString());
		insSessoCuore();
		c1.setSesso(IO.inputChar());
		insEtaCuore();
		c1.setEta(IO.inputInt());
		insSegnoCuore();
		c1.setSegno(SegnoZodiacale.valueOf(IO.inputSegno()));
		insSegnoPartner();
		c1.setSegnoPartner(SegnoZodiacale.valueOf(IO.inputSegno()));
		
		
		CuoreSolitario c2 = new CuoreSolitario();
		insNomeCuore();
		c2.setName(IO.inputString());
		insSessoCuore();
		c2.setSesso(IO.inputChar());
		insEtaCuore();
		c2.setEta(IO.inputInt());
		insSegnoCuore();
		c2.setSegno(SegnoZodiacale.valueOf(IO.inputSegno()));
		insSegnoPartner();
		c2.setSegnoPartner(SegnoZodiacale.valueOf(IO.inputSegno()));
		
		System.out.println("Calcolo affinità...");
		if(c1.isAffine(c2)) {
			System.out.println(String.format(AFFINE, c1.getName(), c2.getName()));
		}else {
			System.out.println(String.format(NON_AFFINE, c1.getName(), c2.getName()));
		}
	
	
	
	}
	public static void insNomeCuore() {
		System.out.println(String.format(NOME_CUORE, counterN));
		counterN++;
	}
	public static void insSessoCuore() {
		System.out.println(String.format(SESSO_CUORE, counterS));
		counterS++;
	}
	public static void insEtaCuore() {
		System.out.println(String.format(ETA_CUORE, counterE));
		counterE++;
	}
	public static void insSegnoCuore() {
		System.out.println(String.format(SEGNO_CUORE, counterZ));
		counterZ++;
	}
	public static void insSegnoPartner() {
		System.out.println("Inserisci il segno zodiacale del partner ideale: ");
	}
}

