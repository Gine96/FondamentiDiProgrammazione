package main;

import java.util.Scanner;

public class IO {
	private static final String MINORENNE="Programma riservato a maggiorenni, inserisci un'età valida: ";
	private static final String ETA_TROPPO_ALTA="Hai inserito un'età troppo alta, inserisci un età valida: ";
	private static final String MESSAGGIO_STRINGA_VUOTA="Inserisci una stringa non vuota: ";
	private static final String MESSAGGIO_CHAR_NON_VALIDO="Inserisci un carattere valido: ";
	private static final String MESSAGGIO_SEGNO_NON_VALIDO="Inserisci un segno zodiacale valido: ";
	private static Scanner lettore;
	
	//private static Scanner s = new Scanner(System.in);
	
	public static String inputString() {
		String tmp;
		lettore = new Scanner(System.in);
		tmp=lettore.nextLine();
		while(tmp.trim().isEmpty()) {
			System.out.println(MESSAGGIO_STRINGA_VUOTA);
			tmp=lettore.nextLine();
		}
		
		return tmp;
	}
	public static int inputInt() {
		int tmp;
		lettore = new Scanner(System.in);
		tmp=lettore.nextInt();
		while(tmp<18) {
			System.out.println(MINORENNE);
			tmp=lettore.nextInt();
		}
		while(tmp>119) {
			System.out.println(ETA_TROPPO_ALTA);
			tmp=lettore.nextInt();
		}
		return tmp;
	}
	public static char inputChar() {
		char tmp;
		lettore = new Scanner(System.in);
		tmp=lettore.next().charAt(0);
		while(tmp!='m'&&tmp!='M'&&tmp!='f'&&tmp!='F') {
			System.out.println(MESSAGGIO_CHAR_NON_VALIDO);
			tmp=lettore.next().charAt(0);
		}
		return tmp;
	}
	public static String inputSegno() {
		String tmp;
		lettore = new Scanner(System.in);
		tmp=lettore.nextLine();
		while(!SegnoZodiacale.checkSegno(tmp)) {
			System.out.println(MESSAGGIO_SEGNO_NON_VALIDO);
			tmp=lettore.nextLine();
		}
		return tmp.toUpperCase();
	}
}
