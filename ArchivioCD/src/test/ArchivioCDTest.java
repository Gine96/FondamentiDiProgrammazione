package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.ArchivioCD;
import main.CD;

class ArchivioCDTest {

	@Test
	public void testAggiuntaCd() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.aggiungiCD(new CD("Anime salve", "Fabrizio De Andr�"));
		archivio.aggiungiCD(new CD("Storia di un impiegato", "Fabrizio De Andr�"));
		assertEquals(2, archivio.getNumeroCd());
	}
	
	@Test
	public void testRicercaTitoloPresente() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.aggiungiCD(new CD("Anime salve", "Fabrizio De Andr�"));
		archivio.aggiungiCD(new CD("Storia di un impiegato", "Fabrizio De Andr�"));
		assertTrue(archivio.contiene("Anime salve"));
	}
	
	@Test
	public void testRicercaTitoloNonPresente() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.aggiungiCD(new CD("Anime salve", "Fabrizio De Andr�"));
		archivio.aggiungiCD(new CD("Storia di un impiegato", "Fabrizio De Andr�"));
		assertFalse(archivio.contiene("La buona novella"));
	}
	
	@Test
	public void testEliminazioneCdPerTitolo() throws Exception {
		final ArchivioCD archivio = new ArchivioCD();
		archivio.aggiungiCD(new CD("Anime salve", "Fabrizio De Andr�"));
		archivio.aggiungiCD(new CD("Storia di un impiegato", "Fabrizio De Andr�"));
		assertEquals(2, archivio.getNumeroCd());
		archivio.eliminaCD("Anime salve");
		assertEquals(1, archivio.getNumeroCd());
		assertFalse(archivio.contiene("Anime salve"));
	}

}
