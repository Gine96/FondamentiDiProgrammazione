package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import main.Brano;
import main.CD;

class CDTest {

	private static final String TITOLO = "Anime salve";
	private static final String AUTORE = "Fabrizio De Andrè";

	@Test
	public void testToStringSenzaBrani() throws Exception {
		assertEquals("Anime salve, Fabrizio De Andrè\nElenco brani", new CD(TITOLO, AUTORE).toString().trim());
	}

	@Test
	public void testToStringConBrani() throws Exception {
		final CD cd = new CD(TITOLO, AUTORE);
		cd.aggiungiBrano(new Brano("Anime salve", 5, 52));
		cd.aggiungiBrano(new Brano("Le acciughe fanno il pallone", 4, 47));
		cd.aggiungiBrano(new Brano("Smisurata preghiera", 7, 8));
		assertEquals(
				"Anime salve, Fabrizio De Andrè\nElenco brani\n1\tAnime salve (05:52)\n2\tLe acciughe fanno il pallone (04:47)\n3\tSmisurata preghiera (07:08)",
				cd.toString());
	}

	@Test
	public void testHaTitoloTrue() throws Exception {
		final CD cd = new CD(TITOLO, AUTORE);
		assertTrue(cd.getTitolo().equalsIgnoreCase(TITOLO));
	}

	@Test
	public void testHaTitoloFalse() throws Exception {
		final CD cd = new CD(TITOLO, AUTORE);
		assertFalse(cd.getTitolo().equalsIgnoreCase("La buona novella"));
	}

	@Test
	public void testEstrazioneCasualeBrano() throws Exception {
		final CD cd = new CD("_A Title_", "_An Author_");
		final int numeroBrani = 10;
		for (int i = 0; i < numeroBrani; i++) {
			cd.aggiungiBrano(new Brano("Brano " + i, i, i));
		}
		final int numeroEstrazioni = 100;
		Set<String> titoliBraniEstratti = new HashSet<String>();
		for (int i = 0; i < numeroEstrazioni; i++) {
			Brano b = cd.selezionaBranoCasuale();
			titoliBraniEstratti.add(b.getTitolo());
		}
		assertTrue(titoliBraniEstratti.size() >= 7);
	}

}
