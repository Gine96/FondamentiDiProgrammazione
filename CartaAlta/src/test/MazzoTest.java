package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Mazzo;

class MazzoTest {

	@Test
	void creazioneMazzoFraTest() throws Exception{
		assertEquals("DUE di CUORI\n" + 
				"TRE di CUORI\n" + 
				"QUATTRO di CUORI\n" + 
				"CINQUE di CUORI\n" + 
				"SEI di CUORI\n" + 
				"SETTE di CUORI\n" + 
				"OTTO di CUORI\n" + 
				"NOVE di CUORI\n" + 
				"DIECI di CUORI\n" + 
				"JACK di CUORI\n" + 
				"DONNA di CUORI\n" + 
				"RE di CUORI\n" + 
				"ASSE di CUORI\n" + 
				"DUE di QUADRI\n" + 
				"TRE di QUADRI\n" + 
				"QUATTRO di QUADRI\n" + 
				"CINQUE di QUADRI\n" + 
				"SEI di QUADRI\n" + 
				"SETTE di QUADRI\n" + 
				"OTTO di QUADRI\n" + 
				"NOVE di QUADRI\n" + 
				"DIECI di QUADRI\n" + 
				"JACK di QUADRI\n" + 
				"DONNA di QUADRI\n" + 
				"RE di QUADRI\n" + 
				"ASSE di QUADRI\n" + 
				"DUE di FIORI\n" + 
				"TRE di FIORI\n" + 
				"QUATTRO di FIORI\n" + 
				"CINQUE di FIORI\n" + 
				"SEI di FIORI\n" + 
				"SETTE di FIORI\n" + 
				"OTTO di FIORI\n" + 
				"NOVE di FIORI\n" + 
				"DIECI di FIORI\n" + 
				"JACK di FIORI\n" + 
				"DONNA di FIORI\n" + 
				"RE di FIORI\n" + 
				"ASSE di FIORI\n" + 
				"DUE di PICCHE\n" + 
				"TRE di PICCHE\n" + 
				"QUATTRO di PICCHE\n" + 
				"CINQUE di PICCHE\n" + 
				"SEI di PICCHE\n" + 
				"SETTE di PICCHE\n" + 
				"OTTO di PICCHE\n" + 
				"NOVE di PICCHE\n" + 
				"DIECI di PICCHE\n" + 
				"JACK di PICCHE\n" + 
				"DONNA di PICCHE\n" + 
				"RE di PICCHE\n" + 
				"ASSE di PICCHE\n", new Mazzo("Francesi").toString());
	}

	@Test
	void creazioneMazzoItaTest() throws Exception {
		assertEquals("DUE di BASTONI\n" + 
				"QUATTRO di BASTONI\n" + 
				"CINQUE di BASTONI\n" + 
				"SEI di BASTONI\n" + 
				"SETTE di BASTONI\n" + 
				"FANTE di BASTONI\n" + 
				"CAVALLO di BASTONI\n" + 
				"RE di BASTONI\n" + 
				"TRE di BASTONI\n" + 
				"ASSE di BASTONI\n" + 
				"DUE di SPADE\n" + 
				"QUATTRO di SPADE\n" + 
				"CINQUE di SPADE\n" + 
				"SEI di SPADE\n" + 
				"SETTE di SPADE\n" + 
				"FANTE di SPADE\n" + 
				"CAVALLO di SPADE\n" + 
				"RE di SPADE\n" + 
				"TRE di SPADE\n" + 
				"ASSE di SPADE\n" + 
				"DUE di COPPE\n" + 
				"QUATTRO di COPPE\n" + 
				"CINQUE di COPPE\n" + 
				"SEI di COPPE\n" + 
				"SETTE di COPPE\n" + 
				"FANTE di COPPE\n" + 
				"CAVALLO di COPPE\n" + 
				"RE di COPPE\n" + 
				"TRE di COPPE\n" + 
				"ASSE di COPPE\n" + 
				"DUE di ORI\n" + 
				"QUATTRO di ORI\n" + 
				"CINQUE di ORI\n" + 
				"SEI di ORI\n" + 
				"SETTE di ORI\n" + 
				"FANTE di ORI\n" + 
				"CAVALLO di ORI\n" + 
				"RE di ORI\n" + 
				"TRE di ORI\n" + 
				"ASSE di ORI\n", new Mazzo("Italiane").toString());
	}

}
