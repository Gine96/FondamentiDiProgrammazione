package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Brano;

class BranoTest {

	private static final String TITOLO = "Il pescatore";
	private static final int MM = 4;
	private static final int SS = 46;

	@Test
	public void testToString() throws Exception {
		assertEquals("Il pescatore (04:46)", new Brano(TITOLO, MM, SS).toString());
	}

}
