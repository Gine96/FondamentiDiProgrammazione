package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Carta;
import main.Carta.SemeFrancese;
import main.Carta.SemeItaliano;
import main.Carta.ValoreFrancese;
import main.Carta.ValoreItaliano;

class CartaTest {

	@Test
	void creazioneCartaItalianaTest() throws Exception {
		Carta card=new Carta(ValoreItaliano.ASSE,SemeItaliano.COPPE);
		assertEquals("ASSE di COPPE", card.toString());
	}

	@Test
	void creazioneCartaFranceseTest() throws Exception {
		Carta card=new Carta(ValoreFrancese.ASSE,SemeFrancese.CUORI);
		assertEquals("ASSE di CUORI", card.toString());
	}

	@Test
	void cartaPiuAltaFrTest() throws Exception {
		boolean test=new Carta(ValoreFrancese.ASSE, SemeFrancese.CUORI).piuAlta(new Carta(ValoreFrancese.JACK,SemeFrancese.QUADRI))>0;
		assertTrue(test);
		boolean test2=new Carta(ValoreFrancese.CINQUE,SemeFrancese.PICCHE).piuAlta(new Carta(ValoreFrancese.ASSE,SemeFrancese.PICCHE))<0;
		assertTrue(test2);
		boolean test3=new Carta(ValoreFrancese.DONNA,SemeFrancese.QUADRI).piuAlta(new Carta(ValoreFrancese.DONNA,SemeFrancese.FIORI))==0;
		assertTrue(test3);
		boolean test4=new Carta(ValoreFrancese.DONNA,SemeFrancese.QUADRI).piuAlta(new Carta(ValoreFrancese.DONNA,SemeFrancese.QUADRI))==0;
		assertTrue(test4);
	}

	@Test
	void cartaPiuAltaItTest() throws Exception {
		boolean test=new Carta(ValoreItaliano.ASSE, SemeItaliano.BASTONI).piuAlta(new Carta(ValoreItaliano.DUE,SemeItaliano.COPPE))>0;
		assertTrue(test);
		boolean test2=new Carta(ValoreItaliano.CINQUE, SemeItaliano.SPADE).piuAlta(new Carta(ValoreItaliano.TRE,SemeItaliano.ORI))<0;
		assertTrue(test2);
		boolean test3=new Carta(ValoreItaliano.CAVALLO, SemeItaliano.ORI).piuAlta(new Carta(ValoreItaliano.CAVALLO,SemeItaliano.COPPE))==0;
		assertTrue(test3);
		boolean test4=new Carta(ValoreItaliano.CAVALLO, SemeItaliano.ORI).piuAlta(new Carta(ValoreItaliano.CAVALLO,SemeItaliano.ORI))==0;
		assertTrue(test4);
	}

}
