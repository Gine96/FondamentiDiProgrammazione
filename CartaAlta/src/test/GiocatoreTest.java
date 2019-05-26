package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Giocatore;

class GiocatoreTest {

	@Test
	void creazioneGiocatoreTest() throws Exception {
		assertEquals("Elia: 1000€", new Giocatore("Elia", 1000).toString());
	}
	
	@Test
	void addSoldiTest() throws Exception {
		Giocatore test=new Giocatore("Elia", 1000);
		assertEquals(1000, test.getSoldi());
		test.addSoldi(500);
		assertEquals(1500, test.getSoldi());
	}
	
	@Test
	void removeSoldiTest() throws Exception {
		Giocatore test=new Giocatore("Elia", 1000);
		assertEquals(1000, test.getSoldi());
		test.removeSoldi(500);
		assertEquals(500, test.getSoldi());
	}

}
